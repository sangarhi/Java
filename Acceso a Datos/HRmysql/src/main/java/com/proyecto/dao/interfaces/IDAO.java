package com.proyecto.dao.interfaces;

import java.util.List;

import com.proyecto.dao.exceptions.DAOException;

public interface IDAO<K, T> {

	List<T> findAll() throws DAOException;

	T findOne(K key) throws DAOException;

	void create(T item) throws DAOException;

	void update(T item) throws DAOException;

	void delete(K key) throws DAOException;
}
