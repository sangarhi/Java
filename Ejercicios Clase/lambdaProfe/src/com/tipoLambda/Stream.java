package com.tipoLambda;

import com.tipoLambda.data.Casa;
import com.tipoLambda.interfaces.IConsumidora;
import com.tipoLambda.interfaces.IFiltro;
import com.tipoLambda.interfaces.IFuncion;
import com.tipoLambda.interfaces.ISupplier;

public class Stream {
    private String cadena;
    private Casa casa;
    
    public Stream() {
		super();
	}

	public Stream(String cadena) {
		super();
		this.cadena = cadena;
	}
	
	public Stream(Casa casa) {
		super();
		this.casa = casa;
		
	}
	
    
	public void forEach(IConsumidora consumidora) {
   	 consumidora.accept(this.cadena);
   }
	public Object generate(ISupplier proveedor) {
		 return proveedor.get();
	}
	public boolean filter(IFiltro filtro) {
		return filtro.test(cadena);
	}
	
	public Integer map(IFuncion funcion) {
		return funcion.apply(casa);
	}
    
}
