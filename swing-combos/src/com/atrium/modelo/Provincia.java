package com.atrium.modelo;

/**
 * DTO -- Persistencia de Provincias.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class Provincia {
	// PROPIEDADES DE CLASE
	private Byte codigoProvincia;
	private String provincia;

	// ACCESORES DE LAS PROPIEDADES
	public Byte getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(Byte codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	// SOBREESCRITURA DE METODOS PARA LA GESTION DE PRUEBAS.
	@Override
	public String toString() {
		return "Provincia [codigoProvincia=" + codigoProvincia + ", provincia=" + provincia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProvincia == null) ? 0 : codigoProvincia.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Provincia))
			return false;
		Provincia other = (Provincia) obj;
		if (codigoProvincia == null) {
			if (other.codigoProvincia != null)
				return false;
		} else if (!codigoProvincia.equals(other.codigoProvincia))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}
}
