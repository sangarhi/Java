package com.examen.mf0227_3.common;

public enum Tipo {TIPO1(1l), TIPO2(2l), TIPO3(3l);
	
	Long tipo;

	private Tipo(Long tipo) {
		this.tipo = tipo;
	}
	
	public Long getTipo() {
		return this.tipo;
	}
	

}
