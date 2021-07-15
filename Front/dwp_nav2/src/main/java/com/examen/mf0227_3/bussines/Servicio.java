package com.examen.mf0227_3.bussines;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.examen.mf0227_3.bussines.interfaces.IServicio;
import com.examen.mf0227_3.common.exceptions.DAOException;
import com.examen.mf0227_3.common.exceptions.ServicioException;
import com.examen.mf0227_3.common.exceptions.TipoException;
import com.examen.mf0227_3.dao.EjemploDAO;
import com.examen.mf0227_3.dao.interfaces.IDAO;
import com.examen.mf0227_3.data.Bean;

public class Servicio implements IServicio<Long,Bean>{

	private static final Logger log = Logger.getLogger(Servicio.class);

	IDAO<Long,Bean> iDao ;

	public Servicio() {
		super();
		this.iDao = new EjemploDAO();
	}
	@Override
	public List<Bean> findAll() throws ServicioException{
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
	public Bean findOne(Long key) throws ServicioException{
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
	public void update(Bean item) throws ServicioException{
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
	public void delete(Long key) throws ServicioException{
		log.debug("delete");

		try {
			this.iDao.delete(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		}catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}
	@Override
	public void create(Bean item) throws ServicioException {
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
	public List<Bean> findByTipo () throws ServicioException {
		log.debug("findByTipo");
		
		try {

		List<Bean> beans=this.iDao.findAll();
		
		return beans.stream().filter(p -> p.getTipo()==1L).collect(Collectors.toList());
		
		
		}catch(DAOException daoe ) {
			throw new ServicioException(daoe);
		}catch(Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
		
	}

}
