package com.javabasico.base.practicas;

import java.util.List;

public interface ICrud<E,K> {
	
	public abstract List<E> selectAll();

	public  E selectById(K id);

	abstract int insert(E element);

	void update(E element);

	int delete(K id);
}
