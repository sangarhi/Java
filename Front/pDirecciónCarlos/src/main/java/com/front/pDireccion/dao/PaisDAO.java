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
import com.front.pDireccion.data.Pais;
import com.front.pDireccion.data.Region;


public class PaisDAO implements IDAO<String, Pais> {

	private static final Logger log = Logger.getLogger(PaisDAO.class);
	
	DriverManagerMySQL driverManagerMySQL;
	
	public PaisDAO() {
		this.driverManagerMySQL = DriverManagerMySQL.getInstancia();
	}
	
	@Override
	public List<Pais> findAll() throws DAOException {
		log.debug("listar");

		// Bloque de inicializaci�n de variables locales
		List<Pais> paises = new ArrayList<Pais>();
		try (Connection con = driverManagerMySQL.getConexion();
				 Statement st = con.createStatement();)
			{
				String query = "SELECT COUNTRY_ID,COUNTRY_NAME,REGION_ID "							
							 + "FROM COUNTRIES ";
				ResultSet rs = st.executeQuery(query);
				while( rs.next()) {
					Pais pais = new Pais();
					pais.setPaisId(rs.getString("COUNTRY_ID"));
					pais.setNombre(rs.getString("COUNTRY_NAME"));					
					pais.setRegion(new Region());
					pais.getRegion().setId(rs.getInt("REGION_ID"));
					
					paises.add(pais);				
				}
				rs.close();
			
				return paises;
				
			} catch (SQLException sqle) {
				log.error(sqle.getMessage(), sqle);
				throw new DAOException(TipoException.EXCEPCION_SQL);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(TipoException.EXCEPCION_GENERAL);
			}

	}

	@Override
	public Pais findOne(String id) throws DAOException {
		
		log.debug("buscar");
		Pais pais = null;
		String query = "SELECT C.COUNTRY_ID, C.COUNTRY_NAME, " + 
				"R.REGION_ID, R.REGION_NAME " + 
				"FROM COUNTRIES C NATURAL JOIN REGIONS R " + 
				"WHERE COUNTRY_ID=?";
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{
				ps.setString(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					pais = new Pais();
					pais.setPaisId(rs.getString("COUNTRY_ID"));
					pais.setNombre(rs.getString("COUNTRY_NAME"));
					Region region=new Region();
					region.setId(rs.getInt("REGION_ID"));
					region.setNombre(rs.getString("REGION_NAME"));
					pais.setRegion(region);
					
					
				} else {
					throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
				}
				if (rs.next()) {
					throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
				}
				rs.close();
				return pais;
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
	public void create(Pais element) throws DAOException {
		log.debug("create");
		
		String query = "INSERT INTO COUNTRIES (COUNTRY_ID,COUNTRY_NAME,REGION_ID )"
			     + "VALUES(?,?,?)";
		
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{
			ps.setString(1, element.getPaisId());
			ps.setString(2, element.getNombre());			
			ps.setInt(3, element.getRegion().getId());
			
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
	public void update(Pais element) throws DAOException {
		log.debug("modificar");
		
		String query = "UPDATE COUNTRIES SET COUNTRY_NAME=?,"
				+     " REGION_ID=? WHERE COUNTRY_ID=?";
		
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{			
			ps.setString(1, element.getNombre());
			ps.setInt(2, element.getRegion().getId());
			ps.setString(3, element.getPaisId());;
			
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
	public void delete(String id) throws DAOException {
		log.debug("borrar");
		
		String query = "DELETE FROM COUNTRIES WHERE COUNTRY_ID=?";
		
		try(Connection con = driverManagerMySQL.getConexion();
			PreparedStatement ps = con.prepareStatement(query)) 
			{
			ps.setString(1, id);
			
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
