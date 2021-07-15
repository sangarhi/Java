package com.examen.mf0227_3.bussines.interfaces;

import java.util.List;

import com.examen.mf0227_3.common.exceptions.ServicioException;
import com.examen.mf0227_3.data.Bean;

public interface IServicio<K,T> {

	List<T> findAll() throws ServicioException;

	T findOne(K key) throws ServicioException;

	void create(T item) throws ServicioException;

	void update(T item) throws ServicioException;

	void delete(K key) throws ServicioException;
	
	public List<Bean> findByTipo () throws ServicioException;
}
