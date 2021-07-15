package com.examen.mf0227_3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.examen.mf0227_3.common.exceptions.DAOException;
import com.examen.mf0227_3.common.exceptions.TipoException;
import com.examen.mf0227_3.dao.interfaces.IDAO;
import com.examen.mf0227_3.data.Bean;

public class EjemploDAO implements IDAO<Long, Bean> {

	DriverManagerMySQL driverManager;

	private static final Logger log = Logger.getLogger(EjemploDAO.class);

	public EjemploDAO() {

		this.driverManager = DriverManagerMySQL.getInstancia();
	}

	@Override
	public List<Bean> findAll() throws DAOException {
		log.debug("findAll");

		Connection con;
		Statement stm;
		ResultSet rs;

		List<Bean> beans = new ArrayList<Bean>();

		String sql = "SELECT ID,NOMBRE,TIPO,FECHACREACION,FECHAMODIFICACION FROM T_BEAN ORDER BY ID";

		try {
			con = driverManager.getConexion();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				Bean bean = new Bean();
				bean.setId(rs.getLong("ID"));
				bean.setNombre(rs.getString("NOMBRE"));
				bean.setTipo(rs.getLong("TIPO"));
				bean.setFechaCreacion(rs.getDate("FECHACREACION").toLocalDate());
				bean.setFechaModificacion(rs.getDate("FECHAMODIFICACION").toLocalDate());
				beans.add(bean);
			}

			return beans;

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public Bean findOne(Long id) throws DAOException {
		log.debug("findOne");
		log.info("id:" + id);

		Connection con;
		PreparedStatement pstm;
		ResultSet rs;

		Bean bean = null;

		String sql = "SELECT ID,NOMBRE,TIPO,FECHACREACION,FECHAMODIFICACION FROM T_BEAN WHERE ID=?";

		try {
			con = driverManager.getConexion();
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				bean = new Bean();
				bean.setId(rs.getLong("ID"));
				bean.setNombre(rs.getString("NOMBRE"));
				bean.setTipo(rs.getLong("TIPO"));
				bean.setFechaCreacion(rs.getDate("FECHACREACION").toLocalDate());
				bean.setFechaModificacion(rs.getDate("FECHAMODIFICACION").toLocalDate());
			} else {
				log.error(TipoException.ELEMENTO_NO_ENCONTRADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_ENCONTRADO);
			}
			if (rs.next()) {
				log.fatal(TipoException.ELEMENTO_DUPLICADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}
			rs.close();
			pstm.close();
			con.close();

			return bean;

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			throw daoe;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void update(Bean item) throws DAOException {
		log.debug("update");

		Connection con;
		PreparedStatement pstm;

		String sql = "UPDATE T_BEAN SET NOMBRE=?, TIPO=?, FECHAMODIFICACION=NOW() WHERE ID=?";

		try {
			con = driverManager.getConexion();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, item.getNombre());
			pstm.setLong(2, item.getTipo());
			pstm.setLong(3, item.getId());

			int i = pstm.executeUpdate();

			if (i == 0) {
				log.error(TipoException.ELEMENTO_NO_ACTUALIZADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_ACTUALIZADO);
			} else if (i > 1) {
				log.error(TipoException.ELEMENTO_DUPLICADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}

			pstm.close();
			con.close();

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			throw daoe;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public void delete(Long key) throws DAOException {
		log.debug("delete");

		Connection con;
		PreparedStatement pstm;

		String sql = "DELETE FROM T_BEAN WHERE ID=?";

		con = driverManager.getConexion();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, key);
			int i = pstm.executeUpdate();

			if (i == 0) {
				log.error(TipoException.ELEMENTO_NO_ELIMINADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_ELIMINADO);
			} else if (i > 1) {
				log.error(TipoException.ELEMENTO_DUPLICADO.getMensaje());
				con.rollback();
				throw new DAOException(TipoException.ELEMENTO_DUPLICADO);
			}
			pstm.close();
			con.close();

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			throw daoe;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public void create(Bean item) throws DAOException {
		log.debug("Create");

		Connection con;
		PreparedStatement pstm;

		String sql = "INSERT INTO T_BEAN (NOMBRE,TIPO) VALUES(?,?)";

		try {
			con = driverManager.getConexion();
			pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, item.getNombre());
			pstm.setLong(2, item.getTipo());

			pstm.execute();

			ResultSet rs = pstm.getGeneratedKeys();

			if (rs.next()) {
				log.info("Elemento creado:" + rs.getLong(1));
				item.setId(rs.getLong(1));
			} else {
				log.error(TipoException.ELEMENTO_NO_CREADO.getMensaje());
				throw new DAOException(TipoException.ELEMENTO_NO_CREADO);
			}

			rs.close();
			pstm.close();
			con.close();

		} catch (SQLException sqle) {
			log.error(sqle.getMessage(), sqle);
			throw new DAOException(TipoException.EXCEPCION_SQL);

		} catch (DAOException daoe) {
			log.error(daoe.getMessage(), daoe);
			throw new DAOException(daoe.getTipoExcepcion());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(TipoException.EXCEPCION_GENERAL);
		}

	}

	/*
	 * @Override public void create(Bean element) throws DAOException {
	 * log.debug("create");
	 * 
	 * String query = "INSERT INTO T_BEAN (NOMBRE,TIPO )" + "VALUES(?,?)";
	 * 
	 * try(Connection con = driverManager.getConexion(); PreparedStatement ps =
	 * con.prepareStatement(query)) {
	 * 
	 * ps.setString(1, element.getNombre()); ps.setLong(2, element.getTipo());
	 * 
	 * int numFilas = ps.executeUpdate();
	 * 
	 * if (numFilas == 0) { throw new
	 * DAOException(TipoException.ELEMENTO_NO_CREADO); } else if (numFilas > 1) {
	 * throw new DAOException(TipoException.ELEMENTO_DUPLICADO); }
	 * 
	 * }catch (SQLException sqle) { log.error(sqle.getMessage(), sqle); throw new
	 * DAOException(TipoException.EXCEPCION_SQL); } catch (DAOException daoe){ if
	 * (daoe.getTipoExcepcion() == TipoException.ELEMENTO_DUPLICADO) {
	 * log.fatal(daoe.getMessage(), daoe); } else { log.error(daoe.getMessage(),
	 * daoe); } throw daoe; } catch (Exception e) { log.error(e.getMessage(), e);
	 * throw new DAOException(TipoException.EXCEPCION_GENERAL); } }
	 */

}
