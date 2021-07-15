package com.front.pDireccion.bussines;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.front.pDireccion.bussiness.interfaces.IServicioDireccion;
import com.front.pDireccion.common.exceptions.DAOException;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.common.exceptions.TipoException;
import com.front.pDireccion.dao.DireccionDAO;
import com.front.pDireccion.dao.interfaces.IDAO;
import com.front.pDireccion.data.Direccion;
import com.google.protobuf.ServiceException;

public class ServDireccion implements IServicioDireccion {

	private static final Logger log = Logger.getLogger(ServDireccion.class);

	IDAO<Long, Direccion> iDao;

	public ServDireccion() {
		super();
		this.iDao = new DireccionDAO();
	}

	@Override
	public List<Direccion> findAll() throws ServicioException {
		log.debug("findAll");

		try {
			List<Direccion> direccion = this.iDao.findAll();

			return direccion;

		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public List<String> findAllCodPostales(List<Direccion> direcciones) throws ServicioException {
		log.debug("findAllCodPostales");

		try {
			return direcciones.stream()
					//.filter(s -> (s.getCodPostal()!=null && !"".equals(s.getCodPostal())))
					.map(s -> s.getCodPostal())
					//.filter(s -> (s!=null && !"".equals(s)))
					.distinct()
					.filter(s -> (s!=null && !"".equals(s)))
					.sorted()
					.collect(Collectors.toList());

		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}

	}

	@Override
	public Direccion findOne(Long key) throws ServicioException {
		log.debug("findOne");

		try {
			// return this.iDao.findOne(key);
			List<Direccion> direcciones = this.iDao.findAll();
			Optional<Direccion> direccion = direcciones.stream().filter(s -> s.getId() == key).findFirst();
			if (!direccion.isPresent())
				throw new ServicioException(TipoException.ELEMENTO_NO_ENCONTRADO);
			return direccion.get();
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (ServicioException se) {
			throw se;
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void create(Direccion item) throws ServicioException {
		// TODO Auto-generated method stub
		log.debug("Create");

		try {
			this.iDao.create(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void update(Direccion item) throws ServicioException {
		log.debug("update");

		try {
			this.iDao.update(item);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

	@Override
	public void delete(Long key) throws ServicioException {
		log.debug("delete");

		try {
			this.iDao.delete(key);
		} catch (DAOException daoe) {
			throw new ServicioException(daoe);
		} catch (Exception e) {
			throw new ServicioException(TipoException.EXCEPCION_GENERAL);
		}
	}

}
