package com.atrium.clases;

import java.io.Serializable;
import java.sql.Timestamp;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

/**
 * Ejemplo de clase donde se usan las opciones de OPENPOJO para la comprobacion
 * de la identidad del objeto, ademas de usar las capacidades dinamicas del
 * mismo.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 31-3-2017.
 *
 */
public final class Person implements Serializable {
	// IDENTIFICADOR PARA LA SERIALIZACION
	private static final long serialVersionUID = 1L;
	// PROPIEDADES DE CLASE
	@BusinessKey(caseSensitive = false, required = true)
	private String firstName;

	@BusinessKey
	private String socialSecurityNumber;

	@BusinessKey(caseSensitive = false, required = false)
	private String lastName;

	private Timestamp created;
	private Timestamp lastUpdated;
	private String id;

	// ***** CONSTRUCTORES
	/**
	 * Constructor por defecto.
	 */
	public Person() {
	}

	/**
	 * Constructor con datos minimos.
	 * 
	 * @param socialSecurityNumber
	 * @param firstName
	 * @param lastName
	 */
	public Person(String socialSecurityNumber, String firstName, String lastName) {
		this.socialSecurityNumber = socialSecurityNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Constrcutor completo.
	 * 
	 * @param id
	 * @param socialSecurityNumber
	 * @param firstName
	 * @param lastName
	 * @param created
	 * @param lastUpdated
	 */
	public Person(String id, String socialSecurityNumber, String firstName, String lastName, Timestamp created,
			Timestamp lastUpdated) {
		this(socialSecurityNumber, firstName, lastName);
		this.id = id;
		this.created = created;
		this.lastUpdated = lastUpdated;
	}

	// ACCESORES PARA LAS PROPIEDADES DE CLASE
	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	// SOBRE ESCRITURA DE METODOS PARA LA IDENTIFICACION DEL OBJETO
	@Override
	public int hashCode() {
		// REGLAS DE IDENTIDAD DE OPENPOJO
		return BusinessIdentity.getHashCode(this);
	}

	@Override
	public boolean equals(final Object obj) {
		// REGLAS DE IDENTIDAD DE OPENPOJO
		return BusinessIdentity.areEqual(this, obj);
	}

	@Override
	public String toString() {
		// REGLAS DE IDENTIDAD DE OPENPOJO
		return BusinessIdentity.toString(this);
	}
}