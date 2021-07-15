package com.front.pDireccion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.front.pDireccion.common.exceptions.DAOException;
import com.front.pDireccion.common.exceptions.TipoException;
import com.front.pDireccion.dao.interfaces.IDAO;
import com.front.pDireccion.data.Direccion;
import com.front.pDireccion.data.Pais;
import com.front.pDireccion.data.Region;


public class DireccionDAO implements IDAO<Long, Direccion> {

	private static final Logger log = Logger.getLogger(DireccionDAO.class);
	
	DriverManagerMySQL driverManagerMySQL;
	
	public DireccionDAO() {
		this.driverManagerMySQL = DriverManagerMySQL.getInstancia();
	}
	
	@Override
	public List<Direccion> findAll() throws DAOException {
		log.debug("listar");

		// Bloque de inicialización de variables locales
		List<Direccion> direcciones = new ArrayList<Direccion>();
		try (Connection con = driverManagerMySQL.getConexion();
				 Statement st = con.createStatement();)
			{
				String query = "SELECT LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,"
							 + "CITY,STATE_PROVINCE,COUNTRY_ID "
							 + "FROM LOCATIONS";
				ResultSet rs = st.executeQuery(query);
				while( rs.next()) {
					Direccion direccion = new Direccion();
					direccion.setId(rs.getLong("LOCATION_ID"));
					direccion.setCalle(rs.getString("STREET_ADDRESS"));
					direccion.setCodPostal(rs.getString("POSTAL_CODE"));
					direccion.setCiudad(rs.getString("CITY"));
					direccion.setEstado(rs.getString("STATE_PROVINCE"));
					direccion.setPais(new Pais());
					direccion.getPais().setPaisId(rs.getString("COUNTRY_ID"));
					
					direcciones.add(direccion);				
				}
				rs.close();
			
				return direcciones;
				
			} catch (SQLException sqle) {
				log.error(sqle.getMessage(), sqle);
				throw new DAOException(TipoException.EXCEPCION_SQL);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(TipoException.EXCEPCION_GENERAL);
			}

	}

	@Override
	public Direccion findOne(Long id) throws DAOException {
		
		log.debug("buscar");
		Direccion direccion = null;
		String query = "SELECT L.LOCATION_ID,L.STREET_ADDRESS,L.POSTAL_CODE,L.CITY,L.STATE_PROVINCE, " + 
				"C.COUNTRY_ID, C.COUNTRY_NAME, " + 
				"R.REGION_ID, R.REGION_NAME " + 
				"FROM LOCATIONS L NATURAL JOIN COUNTRIES C NATURAL JOIN REGIONS R " + 
				"WHERE LOCATION_ID=?";
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{
				ps.setLong(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					direccion = new Direccion();
					direccion.setId(rs.getLong("LOCATION_ID"));
					direccion.setCalle(rs.getString("STREET_ADDRESS"));
					direccion.setCodPostal(rs.getString("POSTAL_CODE"));
					direccion.setCiudad(rs.getString("CITY"));
					direccion.setEstado(rs.getString("STATE_PROVINCE"));
					Pais pais=new Pais();
					pais.setPaisId(rs.getString("COUNTRY_ID"));
					pais.setNombre(rs.getString("COUNTRY_NAME"));
					direccion.setPais(pais);
					Region region=new Region();
					region.setId(rs.getInt("REGION_ID"));
					region.setNombre(rs.getString("REGION_NAME"));
					direccion.getPais().setRegion(region);
					
					
				} else {
					throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
				}
				if (rs.next()) {
					throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
				}
				rs.close();
				return direccion;
			} catch (SQLException sqle) {
				log.error(sqle.getMessage(), sqle);
				throw new DAOException(TipoException.EXCEPCION_SQL);
			} catch (DAOException daoe){
				if (daoe.getTipoExcepcion() == TipoException.ELEMENTO_DUPLICADO) {
					log.fatal(daoe.getMessage(),daoe);
				} else {
					log.error(daoe.getMessage(), daoe);
				}
				throw daoe;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(TipoException.EXCEPCION_GENERAL);
			}

	}

	@Override
	public void create(Direccion element) throws DAOException {
		log.debug("create");
		
		String query = "INSERT INTO LOCATIONS (LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,"
				     + "CITY,STATE_PROVINCE,COUNTRY_ID) VALUES(?,?,?,?,?,?)";
		
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{
			ps.setLong(1, element.getId());
			ps.setString(2, element.getCalle());
			ps.setString(3, element.getCodPostal());
			ps.setString(4, element.getCiudad());
			ps.setString(5, element.getEstado());
			ps.setString(6, element.getPais().getPaisId());
			
			int numFilas = ps.executeUpdate();
			
			if (numFilas == 0) {
				throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
			} else if (numFilas > 1) {
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}
			
			}catch (SQLException sqle) {
				log.error(sqle.getMessage(), sqle);
				throw new DAOException(TipoException.EXCEPCION_SQL);
			} catch (DAOException daoe){
				if (daoe.getTipoExcepcion() == TipoException.ELEMENTO_DUPLICADO) {
					log.fatal(daoe.getMessage(), daoe);
				} else {
					log.error(daoe.getMessage(), daoe);
				}
				throw daoe;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(TipoException.EXCEPCION_GENERAL);
			}		
	}

	@Override
	public void update(Direccion element) throws DAOException {
		log.debug("modificar");
		
		String query = "UPDATE LOCATIONS SET STREET_ADDRESS=?,"
				+     " POSTAL_CODE=?, CITY=?, STATE_PROVINCE=?,"
				+     " COUNTRY_ID=? WHERE LOCATION_ID=?";
		
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{			
			ps.setString(1, element.getCalle());
			ps.setString(2, element.getCodPostal());
			ps.setString(3, element.getCiudad());
			ps.setString(4, element.getEstado());
			ps.setString(5, element.getPais().getPaisId());
			ps.setLong(6, element.getId());
			
			int numFilas = ps.executeUpdate();
			
			if (numFilas == 0) {
				throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
			} else if (numFilas > 1) {
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}
			
			}catch (SQLException sqle) {
				log.error(sqle.getMessage(), sqle);
				throw new DAOException(TipoException.EXCEPCION_SQL);
			} catch (DAOException daoe){
				if (daoe.getTipoExcepcion() == TipoException.ELEMENTO_DUPLICADO) {
					log.fatal(daoe.getMessage(), daoe);
				} else {
					log.error(daoe.getMessage(), daoe);
				}
				throw daoe;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(TipoException.EXCEPCION_GENERAL);
			}
		
	}

	@Override
	public void delete(Long id) throws DAOException {
		log.debug("borrar");
		
		String query = "DELETE FROM LOCATIONS WHERE LOCATION_ID=?";
		
		try(Connection con = driverManagerMySQL.getConexion();
			PreparedStatement ps = con.prepareStatement(query)) 
			{
			ps.setLong(1, id);
			
			int numFilas = ps.executeUpdate();
			
			if (numFilas == 0) {
				throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			} else if (numFilas > 1) {
				throw new DAOException(TipoException.EXCEPCION_DAO);
			}
			
			}catch (SQLException sqle) {
				log.error(sqle.getMessage(), sqle);
				throw new DAOException(TipoException.EXCEPCION_SQL);
			} catch (DAOException daoe){
				if (daoe.getTipoExcepcion() == TipoException.EXCEPCION_DAO) {
					log.fatal(daoe.getMessage(), daoe);
				} else {
					log.error(daoe.getMessage(), daoe);
				}
				throw daoe;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(TipoException.EXCEPCION_GENERAL);
			}		
	}
}
