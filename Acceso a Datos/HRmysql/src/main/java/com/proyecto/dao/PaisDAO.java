package com.proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.proyecto.dao.exceptions.DAOException;
import com.proyecto.dao.exceptions.TipoException;
import com.proyecto.dao.interfaces.IDAO;
import com.proyecto.data.Pais;

public class PaisDAO implements IDAO<String, Pais> {

	DriverManagerMySQL driverManager;

	private static final Logger log = Logger.getLogger(DepartamentoDAO.class);

	public PaisDAO() {

		this.driverManager = DriverManagerMySQL.getInstance();
	}

	@Override
	public List<Pais> findAll() throws DAOException {
		log.debug("findAll");

		List<Pais> paises = new ArrayList<Pais>();

		try (Connection con = DriverManagerMySQL.getConnexion(); Statement st = con.createStatement();) {
			String query = "SELECT COUNTRY_ID,COUNTRY_NAME,REGION_ID FROM COUNTRIES ORDER BY COUNTRY_ID";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Pais pais = new Pais();
				pais.setId(rs.getString("COUNTRY_ID"));
				pais.setCountryName(rs.getString("COUNTRY_NAME"));
				pais.setRegionId(rs.getLong("REGION_ID"));

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
	public Pais findOne(String key) throws DAOException {
		log.debug("findOne");

		Pais pais = null;

		String query = "SELECT COUNTRY_ID,COUNTRY_NAME,REGION_ID FROM COUNTRIES WHERE COUNTRY_ID=?";

		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				pais = new Pais();
				pais.setId(rs.getString("COUNTRY_ID"));
				pais.setCountryName(rs.getString("COUNTRY_NAME"));
				pais.setRegionId(rs.getLong("REGION_ID"));
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
	public void create(Pais item) throws DAOException {
		log.debug("create");

		String query = "INSERT INTO COUNTRIES (COUNTRY_ID,COUNTRY_NAME,REGION_ID) VALUES(?,?,?)";

		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setString(1, item.getId());
			ps.setString(2, item.getCountryName());
			ps.setLong(3, item.getRegionId());

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
	public void update(Pais item) throws DAOException {
		log.debug("update");

		String query = "UPDATE COUNTRIES SET COUNTRY_NAME=?, REGION_ID=? WHERE COUNTRY_ID=?";

		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, item.getCountryName());

			ps.setLong(2, item.getRegionId());
			ps.setString(3, item.getId());

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
	public void delete(String key) throws DAOException {
		log.debug("delete");

		String query = "DELETE FROM COUNTRIES WHERE COUNTRY_ID=?";

		try (Connection con = DriverManagerMySQL.getConnexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, key);

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
