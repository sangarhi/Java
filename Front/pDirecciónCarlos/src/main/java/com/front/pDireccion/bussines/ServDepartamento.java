package com.front.pDireccion.bussines;

import java.util.List;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.DAOException;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.common.exceptions.TipoException;
import com.front.pDireccion.dao.DepartamentoDAO;
import com.front.pDireccion.dao.interfaces.IDAO;
import com.front.pDireccion.data.Departamento;

public class ServDepartamento implements IServicio<Long,Departamento>{

	private static final Logger log = Logger.getLogger(ServDepartamento.class);

	IDAO<Long,Departamento> iDao ;

	public ServDepartamento() {
		super();
		this.iDao = new DepartamentoDAO();
	}
	
	@Override
	public List<Departamento> findAll() throws ServicioException{
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
	public Departamento findOne(Long key) throws ServicioException{
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
	public void create(Departamento item) throws ServicioException {
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
	public void update(Departamento item) throws ServicioException{
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
	

}
