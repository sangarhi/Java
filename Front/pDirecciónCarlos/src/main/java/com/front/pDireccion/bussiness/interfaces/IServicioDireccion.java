package com.front.pDireccion.bussiness.interfaces;

import java.util.List;

import com.front.pDireccion.bussines.interfaces.IServicio;
import com.front.pDireccion.common.exceptions.ServicioException;
import com.front.pDireccion.data.Direccion;

public interface IServicioDireccion extends IServicio<Long,Direccion>{

	List<String> findAllCodPostales(List<Direccion> direcciones)throws ServicioException;
	
	

}
