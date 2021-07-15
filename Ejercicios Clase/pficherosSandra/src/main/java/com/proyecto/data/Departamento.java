package com.proyecto.data;

/**
 * Bean Departamento
 * 
 * @author Sandra
 *
 */
public class Departamento {

	private Long id;
	private String nombre;
	private Long idManager;
	private Long idDireccion;

	public Departamento() {
		super();
		nombre = "sin_asignar";
		idManager = null;
		idDireccion = null;
	}

	public Departamento(Long id, String nombre, Long idManager, Long idLocalizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idManager = idManager;
		this.idDireccion = idLocalizacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdManager() {
		return idManager;
	}

	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", idManager=" + idManager + ", idDireccion="
				+ idDireccion + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDireccion == null) {
			if (other.idDireccion != null)
				return false;
		} else if (!idDireccion.equals(other.idDireccion))
			return false;
		if (idManager == null) {
			if (other.idManager != null)
				return false;
		} else if (!idManager.equals(other.idManager))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
