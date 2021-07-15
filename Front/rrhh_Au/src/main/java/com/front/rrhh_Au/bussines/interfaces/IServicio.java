package com.front.rrhh_Au.bussines.interfaces;

import java.util.List;

import com.front.rrhh_Au.common.exceptions.ServicioException;

public interface IServicio<K,T> {

	/**
	 * Se encuentran todos los elementos
	 * @return
	 * @throws ServicioException
	 */
	List<T> findAll() throws ServicioException;

	/**
	 * Se encuentra un elemento por su key
	 * @param id
	 * @return
	 * @throws ServicioException
	 */
	T findOne(Integer id) throws ServicioException;

	/**
	 * Se crea un elemento
	 * @param item
	 * @throws ServicioException
	 */
	void create(T item) throws ServicioException;

	/**
	 * Se modifica un elemento
	 * @param item
	 * @throws ServicioException
	 */
	void update(T item) throws ServicioException;

	/**
	 * Se elimina  un elemento
	 * @param key
	 * @throws ServicioException
	 */
	void delete(K key) throws ServicioException;
}
