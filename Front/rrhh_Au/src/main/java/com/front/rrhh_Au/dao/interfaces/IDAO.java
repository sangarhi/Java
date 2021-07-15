package com.front.rrhh_Au.dao.interfaces;

import java.util.List;

import com.front.rrhh_Au.common.exceptions.DAOException;

/**
 * Interfaz que provee  CRUD para BBDD
 * @param <K>
 * @param <T>
 */
public interface IDAO<K,T> {
	
	List<T> findAll() throws DAOException;

	T findOne(K key) throws DAOException;

	void create(T item) throws DAOException;

	void update(T item) throws DAOException;

	void delete(K key) throws DAOException;

}
