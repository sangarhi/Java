package com.proyecto.data;

import com.proyecto.comun.Colores;
import com.proyecto.comun.TipoMaceta;

public class Maceta {

	private Long id;
	private String codigo;
	private int largo;
	private int ancho;
	private TipoMaceta tipoMaceta;
	private Colores color;
	
	public Maceta() {
		super();
	}
	

	public Maceta(Long id, String codigo, int largo, int ancho, TipoMaceta tipoMaceta, Colores color) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.largo = largo;
		this.ancho = ancho;
		this.tipoMaceta = tipoMaceta;
		this.color = color;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the largo
	 */
	public int getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the tipoMaceta
	 */
	public TipoMaceta getTipoMaceta() {
		return tipoMaceta;
	}

	/**
	 * @param tipoMaceta the tipoMaceta to set
	 */
	public void setTipoMaceta(TipoMaceta tipoMaceta) {
		this.tipoMaceta = tipoMaceta;
	}

	/**
	 * @return the color
	 */
	public Colores getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Colores color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Maceta [id=" + id + ", codigo=" + codigo + ", largo=" + largo + ", ancho=" + ancho + ", tipoMaceta="
				+ tipoMaceta + ", color=" + color + "]";
	}
	
	
	
	
}
