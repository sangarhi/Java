package com.proyecto.dao.interfaces;

import java.util.List;

import com.proyecto.dao.exceptions.DAOException;



/**
 * Interfaz que provee  CRUD para BBDD
 * @author MARIA
 *
 * @param <K>
 * @param <T>
 */
public interface IDAO<T,K> {
	
	boolean exist(K id)throws DAOException;
	
	List<T> findAll() throws DAOException;

	T findOne(K id) throws DAOException;
	
	//void createOrUpdate(T element) throws DAOException;

	void create(T element) throws DAOException;

	void update(T element) throws DAOException;

	void delete(K id) throws DAOException;

}
