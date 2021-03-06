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
import com.proyecto.data.Departamento;

public class DepartamentoDAO implements IDAO<Departamento, Long> {

	private static final Logger log = Logger.getLogger(DepartamentoDAO.class);

	DriverManagerMySQL driverManager;

	public DepartamentoDAO() {

		this.driverManager = DriverManagerMySQL.getInstance();
	}

	public boolean exist(Long id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public void createOrUpdate(Departamento element) throws DAOException {
		Departamento aux = findOne(element.getId());
		if (aux == null)
			create(element);
		else
			update(element);
	}

	public List<Departamento> findAll() throws DAOException {
		log.debug("findAll");

		// Bloque de inicialización de variables locales
		List<Departamento> departamentos = new ArrayList<Departamento>();

		// Bloque try-catch. El último bloque catch recoge Exception
		try (Connection con = DriverManagerMySQL.getConexion(); Statement st = con.createStatement()) {
			String query = "SELECT DEPARTMENT_ID,DEPARTMENT_NAME,LOCATION_ID,MANAGER_ID FROM DEPARTMENTS ORDER BY DEPARTMENT_ID";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(rs.getLong("DEPARTMENT_ID"));
				departamento.setNombre(rs.getString("DEPARTMENT_NAME"));
				if (rs.getObject("MANAGER_ID") != null)
					departamento.setIdManager(rs.getLong("MANAGER_ID"));
				if (rs.getObject("LOCATION_ID") != null)
					departamento.setIdDireccion(rs.getLong("LOCATION_ID"));

				departamentos.add(departamento);
			}
			rs.close();
			return departamentos;

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	public Departamento findOne(Long id) throws DAOException {
		log.debug("findOne");

		Departamento departamento = null;
		String query = "SELECT DEPARTMENT_ID,DEPARTMENT_NAME,LOCATION_ID,MANAGER_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";

		try (Connection con = DriverManagerMySQL.getConexion(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				departamento = new Departamento();
				departamento.setId(rs.getLong("DEPARTMENT_ID"));
				departamento.setNombre(rs.getString("DEPARTMENT_NAME"));
				if (rs.getObject("MANAGER_ID") != null)
					departamento.setIdManager(rs.getLong("MANAGER_ID"));
				if (rs.getObject("LOCATION_ID") != null)
					departamento.setIdDireccion(rs.getLong("LOCATION_ID"));
			} else {
				throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
			}
			if (rs.next()) {
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}

			rs.close();

			return departamento;

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

	public void create(Departamento element) throws DAOException {
		log.debug("create");
		
		String query = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME,LOCATION_ID,MANAGER_ID) VALUES(?,?,?,?)";

		try (Connection con = DriverManagerMySQL.getConexion(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setLong(1, element.getId());
			ps.setString(2, element.getNombre());
			ps.setLong(3, element.getIdDireccion());

			if (element.getIdManager() != null) {
				ps.setLong(4, element.getIdManager());
			} else {
				ps.setNull(4, Types.INTEGER);
			}

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

	public void update(Departamento element) throws DAOException {
		log.debug("update");

		String query = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, LOCATION_ID=?, MANAGER_ID=? WHERE DEPARTMENT_ID=?";

		try (Connection con = DriverManagerMySQL.getConexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, element.getNombre());
			ps.setLong(2, element.getIdDireccion());

			if (element.getIdManager() != null) {
				ps.setLong(3, element.getIdManager());
			} else {
				ps.setNull(3, Types.INTEGER);
			}
			ps.setLong(4, element.getId());

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

	public void delete(Long id) throws DAOException {
		log.debug("delete");

		String query = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";

		try (Connection con = DriverManagerMySQL.getConexion(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setLong(1, id);

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
