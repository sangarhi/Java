package com.front.pDireccion.bussines;

import java.util.List;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.DAOException;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.common.exceptions.TipoException;
import com.front.pDireccion.dao.PaisDAO;
import com.front.pDireccion.dao.interfaces.IDAO;
import com.front.pDireccion.data.Pais;

public class ServPais implements IServicio<String,Pais>{

	private static final Logger log = Logger.getLogger(ServPais.class);

	IDAO<String,Pais> iDao ;

	public ServPais() {
		super();
		this.iDao = new PaisDAO();
	}
	
	@Override
	public List<Pais> findAll() throws ServicioException{
		log.debug("findAll");

		try {
			return this.iDao.findAll();
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public Pais findOne(String key) throws ServicioException{
		log.debug("findOne");

		try {
			return this.iDao.findOne(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}
	

	@Override
	public void create(Pais item) throws ServicioException {
		// TODO Auto-generated method stub
		log.debug("Create");
		
		try {
			this.iDao.create(item);
		}catch(DAOException daoe ) {
			throw new ServicioException(daoe);
		}catch(Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void update(Pais item) throws ServicioException{
		log.debug("update");

		try {
			this.iDao.update(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void delete(String key) throws ServicioException{
		log.debug("delete");

		try {
			this.iDao.delete(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}
	

}
