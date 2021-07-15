package com.front.pDireccion.bussines;

import java.util.List;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.DAOException;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.common.exceptions.TipoException;
import com.front.pDireccion.dao.RegionDAO;
import com.front.pDireccion.dao.interfaces.IDAO;
import com.front.pDireccion.data.Region;

public class ServRegion implements IServicio<Integer, Region> {

	private static final Logger log = Logger.getLogger(ServRegion.class);

	IDAO<Integer, Region> dao;

	public ServRegion() {
		super();
		this.dao = new RegionDAO();
	}

	@Override
	public List<Region> findAll() throws ServicioException {
		log.debug("findAll");

		try {
			return this.dao.findAll();
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}
	}

	@Override
	public Region findOne(Integer key) throws ServicioException {
		log.debug("findOne");

		try {
			return this.dao.findOne(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void create(Region item) throws ServicioException {
		log.debug("Create");

		try {
			this.dao.create(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public void update(Region item) throws ServicioException {
		try {
			this.dao.update(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public void delete(Integer key) throws ServicioException {
		log.debug("delete");

		try {
			this.dao.delete(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}

	}

}
