package com.front.pDireccion.bussines;

import java.util.List;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.DAOException;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.common.exceptions.TipoException;
import com.front.pDireccion.dao.DireccionDAO;
import com.front.pDireccion.dao.interfaces.IDAO;
import com.front.pDireccion.data.Direccion;

public class ServDireccion implements IServicio<Long, Direccion> {
	
	private static final Logger log = Logger.getLogger(ServDireccion.class);
	
	IDAO<Long,Direccion> dao ;
	
	public ServDireccion() {
		super();
		this.dao = new DireccionDAO();
	}

	@Override
	public List<Direccion> findAll() throws ServicioException {
		log.debug("findAll");
		
		try {
			return this.dao.findAll();
		} catch(DAOException daoe) {
			throw new ServicioException(daoe);
		}
	}

	@Override
	public Direccion findOne(Long key) throws ServicioException {
		log.debug("findOne");

		try {
			return this.dao.findOne(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void create(Direccion item) throws ServicioException {
log.debug("Create");
		
		try {
			this.dao.create(item);
		}catch(DAOException daoe ) {
			throw new ServicioException(daoe);
		}catch(Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
		
	}

	@Override
	public void update(Direccion item) throws ServicioException {
		try {
			this.dao.update(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
		
	}

	@Override
	public void delete(Long key) throws ServicioException {
		log.debug("delete");

		try {
			this.dao.delete(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	

}
