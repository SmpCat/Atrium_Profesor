package com.atrium.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pais entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PAIS")
public class Pais implements java.io.Serializable {

	// Fields

	private Long codigoPais;
	private Integer paisIsonum;
	private String paisIso2;
	private String paisIso3;
	private String paisNombre;

	// Constructors

	/** default constructor */
	public Pais() {
	}

	/** minimal constructor */
	public Pais(Long codigoPais) {
		this.codigoPais = codigoPais;
	}

	/** full constructor */
	public Pais(Long codigoPais, Integer paisIsonum, String paisIso2,
			String paisIso3, String paisNombre) {
		this.codigoPais = codigoPais;
		this.paisIsonum = paisIsonum;
		this.paisIso2 = paisIso2;
		this.paisIso3 = paisIso3;
		this.paisNombre = paisNombre;
	}

	// Property accessors
	@Id
	@Column(name = "CODIGO_PAIS", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(Long codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Column(name = "PAIS_ISONUM", precision = 6, scale = 0)
	public Integer getPaisIsonum() {
		return this.paisIsonum;
	}

	public void setPaisIsonum(Integer paisIsonum) {
		this.paisIsonum = paisIsonum;
	}

	@Column(name = "PAIS_ISO2", length = 2)
	public String getPaisIso2() {
		return this.paisIso2;
	}

	public void setPaisIso2(String paisIso2) {
		this.paisIso2 = paisIso2;
	}

	@Column(name = "PAIS_ISO3", length = 3)
	public String getPaisIso3() {
		return this.paisIso3;
	}

	public void setPaisIso3(String paisIso3) {
		this.paisIso3 = paisIso3;
	}

	@Column(name = "PAIS_NOMBRE", length = 80)
	public String getPaisNombre() {
		return this.paisNombre;
	}

	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}

}