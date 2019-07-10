package com.atrium.hibernate;

/**
 * Pais entity. @author MyEclipse Persistence Tools
 */

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

	public Long getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(Long codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Integer getPaisIsonum() {
		return this.paisIsonum;
	}

	public void setPaisIsonum(Integer paisIsonum) {
		this.paisIsonum = paisIsonum;
	}

	public String getPaisIso2() {
		return this.paisIso2;
	}

	public void setPaisIso2(String paisIso2) {
		this.paisIso2 = paisIso2;
	}

	public String getPaisIso3() {
		return this.paisIso3;
	}

	public void setPaisIso3(String paisIso3) {
		this.paisIso3 = paisIso3;
	}

	public String getPaisNombre() {
		return this.paisNombre;
	}

	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}

}