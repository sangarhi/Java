package com.front.rrhh_Au.bussines;

import java.util.List;

import org.apache.log4j.Logger;

import com.front.rrhh_Au.bussines.interfaces.IServicio;
import com.front.rrhh_Au.common.exceptions.DAOException;
import com.front.rrhh_Au.common.exceptions.ServicioException;
import com.front.rrhh_Au.common.exceptions.TipoException;
import com.front.rrhh_Au.dao.RegionDAO;
import com.front.rrhh_Au.dao.interfaces.IDAO;
import com.front.rrhh_Au.data.Region;

public class ServRegion implements IServicio<Integer,Region>{

	private static final Logger log = Logger.getLogger(ServRegion.class);

	IDAO<Integer,Region> iDao ;

	public ServRegion() {
		super();
		this.iDao = new RegionDAO();
	}
	
	@Override
	public List<Region> findAll() throws ServicioException{
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
	public Region findOne(Integer key) throws ServicioException{
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
	public void create(Region item) throws ServicioException {
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
	public void update(Region item) throws ServicioException{
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
	public void delete(Integer key) throws ServicioException{
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
