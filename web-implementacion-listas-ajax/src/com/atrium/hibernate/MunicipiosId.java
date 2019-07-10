package com.atrium.hibernate;

/**
 * MunicipiosId entity. @author MyEclipse Persistence Tools
 */

public class MunicipiosId implements java.io.Serializable {

	// Fields

	private Long codigoMunicipio;
	private Byte provincia;

	// Constructors

	/** default constructor */
	public MunicipiosId() {
	}

	/** full constructor */
	public MunicipiosId(Long codigoMunicipio, Byte provincia) {
		this.codigoMunicipio = codigoMunicipio;
		this.provincia = provincia;
	}

	// Property accessors

	public Long getCodigoMunicipio() {
		return this.codigoMunicipio;
	}

	public void setCodigoMunicipio(Long codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public Byte getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Byte provincia) {
		this.provincia = provincia;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MunicipiosId))
			return false;
		MunicipiosId castOther = (MunicipiosId) other;

		return ((this.getCodigoMunicipio() == castOther.getCodigoMunicipio()) || (this
				.getCodigoMunicipio() != null
				&& castOther.getCodigoMunicipio() != null && this
				.getCodigoMunicipio().equals(castOther.getCodigoMunicipio())))
				&& ((this.getProvincia() == castOther.getProvincia()) || (this
						.getProvincia() != null
						&& castOther.getProvincia() != null && this
						.getProvincia().equals(castOther.getProvincia())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoMunicipio() == null ? 0 : this.getCodigoMunicipio()
						.hashCode());
		result = 37 * result
				+ (getProvincia() == null ? 0 : this.getProvincia().hashCode());
		return result;
	}

}