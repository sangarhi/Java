package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.exceptions.TipoException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Direccion;

public class DireccionDAO implements IDAO<Long, Direccion> {

	DriverManagerMySQL driverManager;

	private static final Logger log = Logger.getLogger(DireccionDAO.class);

	public DireccionDAO() {
		this.driverManager = DriverManagerMySQL.getInstance();
	}

	@Override
	public List<Direccion> findAll() throws DAOException {
		log.debug("findAll");

		List<Direccion> direcciones = new ArrayList<Direccion>();

		try (Connection con = DriverManagerMySQL.getConnexion(); Statement st = con.createStatement();) {
			String query = "SELECT LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE, COUNTRY_ID FROM LOCATIONS ORDER BY LOCATION_ID";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Direccion direccion = new Direccion();
				direccion.setId(rs.getLong("LOCATION_ID"));
				direccion.setStreetAddress(rs.getString("STREET_ADDRESS"));
				if (rs.getObject("POSTAL_CODE") != null)
					direccion.setPostalCode(rs.getString("POSTAL_CODE"));
				direccion.setCity(rs.getString("CITY"));
				if (rs.getObject("STATE_PROVINCE") != null)
					direccion.setStateProvince("STATE_PROVINCE");
				direccion.setIdCountry(rs.getString("COUNTRY_ID"));

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
	public Direccion findOne(Long key) throws DAOException {
		log.debug("findOne");

		Direccion direccion = null;

		String query = "SELECT LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE, COUNTRY_ID FROM LOCATIONS WHERE LOCATION_ID=?";

		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setLong(1, key);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				direccion = new Direccion();
				direccion.setId(rs.getLong("LOCATION_ID"));
				direccion.setStreetAddress(rs.getString("STREET_ADDRESS"));
				if (rs.getObject("POSTAL_CODE") != null)
					direccion.setPostalCode(rs.getString("POSTAL_CODE"));
				direccion.setCity(rs.getString("CITY"));
				if (rs.getObject("STATE_PROVINCE") != null)
					direccion.setStateProvince("STATE_PROVINCE");
				direccion.setIdCountry(rs.getString("COUNTRY_ID"));
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
		} catch (DAOException daoe) {
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
	public void create(Direccion item) throws DAOException {
		log.debug("create");

		String query = "INSERT INTO LOCATIONS (LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE, COUNTRY_ID) VALUES(?,?,?,?,?,?)";

		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setLong(1, item.getId());
			ps.setString(2, item.getStreetAddress());
			if (item.getPostalCode() != null) {
				ps.setString(3, item.getPostalCode());
			} else {
				ps.setNull(3, Types.VARCHAR);
			}
			ps.setString(4, item.getCity());
			if (item.getStateProvince() != null) {
				ps.setString(5, item.getStateProvince());
			} else {
				ps.setNull(5, Types.VARCHAR);
			}
			ps.setString(6, item.getIdCountry());
			

			int numFilas = ps.executeUpdate();

			if (numFilas == 0) {
				throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
			} else if (numFilas > 1) {
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);
		} catch (DAOException daoe) {
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
	public void update(Direccion item) throws DAOException {
		log.debug("update");

		String query = "UPDATE LOCATIONS SET STREET_ADDRESS=?, POSTAL_CODE=?, CITY=?, STATE_PROVINCE=?, COUNTRY_ID=? WHERE LOCATION_ID=?";

		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, item.getStreetAddress());
			if (item.getPostalCode() != null) {
				ps.setString(2, item.getPostalCode());
			} else {
				ps.setNull(2, Types.VARCHAR);
			}
			ps.setString(3, item.getCity());
			if (item.getStateProvince() != null) {
				ps.setString(4, item.getStateProvince());
			} else {
				ps.setNull(4, Types.VARCHAR);
			}
			ps.setString(5, item.getIdCountry());
			ps.setLong(6, item.getId());

			int numFilas = ps.executeUpdate();

			if (numFilas == 0) {
				throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
			} else if (numFilas > 1) {
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);
		} catch (DAOException daoe) {
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
	public void delete(Long key) throws DAOException {
		log.debug("delete");

		String query = "DELETE FROM LOCATIONS WHERE LOCATION_ID=?";
		
		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setLong(1, key);

			int numFilas = ps.executeUpdate();

			if (numFilas == 0) {
				throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			} else if (numFilas > 1) {
				throw new DAOException(TipoException.EXCEPCION_DAO);
			}

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);
		} catch (DAOException daoe) {
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
