package com.proyecto.data;

public class Direccion {
	private Long id;
	private String streetAddress;
	private String PostalCode;
	private String city;
	private String stateProvince;
	private String idCountry;

	public Direccion() {
		super();
	}

	public Direccion(Long id, String streetAddress, String postalCode, String city, String stateProvince,
			String idCountry) {
		super();
		this.id = id;
		this.streetAddress = streetAddress;
		PostalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.idCountry = idCountry;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", streetAddress=" + streetAddress + ", PostalCode=" + PostalCode + ", city="
				+ city + ", stateProvince=" + stateProvince + ", idCountry=" + idCountry + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		if (PostalCode == null) {
			if (other.PostalCode != null)
				return false;
		} else if (!PostalCode.equals(other.PostalCode))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCountry == null) {
			if (other.idCountry != null)
				return false;
		} else if (!idCountry.equals(other.idCountry))
			return false;
		if (stateProvince == null) {
			if (other.stateProvince != null)
				return false;
		} else if (!stateProvince.equals(other.stateProvince))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		return true;
	}

}
