package com.front.pDireccion.bussines.interfaces;

import java.util.List;

import com.front.pDireccion.common.exceptions.ServicioException;

public interface IServicio<K, T> {
	
	List<T> findAll() throws ServicioException;
	T findOne(K key) throws ServicioException;
	void create(T item) throws ServicioException;
	void update(T item) throws ServicioException;
	void delete(K key) throws ServicioException;

}
