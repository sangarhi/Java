package com.front.rrhh_Au.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.front.rrhh_Au.common.exceptions.DAOException;
import com.front.rrhh_Au.common.exceptions.TipoException;
import com.front.rrhh_Au.dao.interfaces.IDAO;
import com.front.rrhh_Au.data.Region;


public class RegionDAO implements IDAO<Integer, Region> {

	private static final Logger log = Logger.getLogger(RegionDAO.class);
	
	DriverManagerMySQL driverManagerMySQL;
	
	public RegionDAO() {
		this.driverManagerMySQL = DriverManagerMySQL.getInstancia();
	}
	
	@Override
	public List<Region> findAll() throws DAOException {
		log.debug("listar");

		// Bloque de inicialización de variables locales
		List<Region> regiones = new ArrayList<Region>();
		try (Connection con = driverManagerMySQL.getConexion();
				 Statement st = con.createStatement();)
			{
				String query = "SELECT REGION_ID,REGION_NAME "							
							 + "FROM REGIONS ";
				ResultSet rs = st.executeQuery(query);
				while( rs.next()) {
					Region region = new Region();
					region.setId(rs.getInt("REGION_ID"));
					region.setNombre(rs.getString("REGION_NAME"));					
					
					regiones.add(region);				
				}
				rs.close();
			
				return regiones;
				
			} catch (SQLException sqle) {
				log.error(sqle.getMessage(), sqle);
				throw new DAOException(TipoException.EXCEPCION_SQL);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(TipoException.EXCEPCION_GENERAL);
			}

	}

	@Override
	public Region findOne(Integer id) throws DAOException {
		
		log.debug("buscar");
		Region region = null;
		String query = "SELECT REGION_ID,REGION_NAME "							
				 + "FROM REGIONS " +
				"WHERE REGION_ID=?";
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					region = new Region();
					region.setId(rs.getInt("REGION_ID"));
					region.setNombre(rs.getString("REGION_NAME"));	
				} else {
					throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
				}
				if (rs.next()) {
					throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
				}
				rs.close();
				return region;
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
	public void create(Region element) throws DAOException {
		log.debug("create");
		
		String query = "INSERT INTO REGIONS (REGION_ID,REGION_NAME )"
			     + "VALUES(?,?)";
		
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{
			ps.setInt(1, element.getId());
			ps.setString(2, element.getNombre());			
			
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
	public void update(Region element) throws DAOException {
		log.debug("modificar");
		
		String query = "UPDATE REGIONS SET REGION_NAME=?"
				+     " WHERE REGION_ID=?";
		
		try(Connection con = driverManagerMySQL.getConexion();
				PreparedStatement ps = con.prepareStatement(query)) 
			{	
			
			ps.setString(1, element.getNombre());
			ps.setInt(2, element.getId());
			
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
	public void delete(Integer id) throws DAOException {
		log.debug("borrar");
		
		String query = "DELETE FROM REGIONS WHERE REGION_ID=? ";
		
		try(Connection con = driverManagerMySQL.getConexion();
			PreparedStatement ps = con.prepareStatement(query)) 
			{
			ps.setInt(1, id);
			
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
