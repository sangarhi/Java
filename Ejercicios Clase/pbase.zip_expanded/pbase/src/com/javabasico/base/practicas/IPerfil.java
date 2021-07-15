package com.javabasico.base.practicas;

import java.util.List;

public interface IPerfil {

	List<Perfil> selectAll();

	Perfil selectById(Integer idPerfil);

	int insert(Perfil perfil);

	void update(Perfil perfil);

	int delete(Integer idPerfil);

}