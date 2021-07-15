package com.javabasico.base.practicas;

import java.util.List;

public interface IGenerica<E, K> {

	List<E> selectAll();

	E selectById(K idPerfil);

	int insert(E perfil);

	void update(E perfil);

	int delete(K idPerfil);

}