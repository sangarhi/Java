package com.proyecto.comun;

public enum TipoMaceta {REDONDA(10), RECTANGULAR(20), HEXAGONAL(30);
	
	private  long volumen;
	

	private TipoMaceta(long volumen) {
		this.volumen = volumen;
	}

	/**
	 * @return the volumen
	 */
	public long getVolumen() {
		return volumen;
	}

	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(long volumen) {
		this.volumen = volumen;
	}
	
	

}
