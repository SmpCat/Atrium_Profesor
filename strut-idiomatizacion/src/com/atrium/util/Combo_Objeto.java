package com.atrium.util;

/**
 * Objeto auxiliar para el rellenado dinamico de cualquier combo de la
 * aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 3-9-2015.
 * 
 */
public class Combo_Objeto {
	// NOMBRE DE LAS PROPIEDADES QUE BUSCA STRUT
	private String valor_combo;
	private String texto_combo;

	// ACESORES PARA LA CARGA EN LA PAGINA
	public String getValor_combo() {
		return valor_combo;
	}

	public void setValor_combo(String valor_combo) {
		this.valor_combo = valor_combo;
	}

	public String getTexto_combo() {
		return texto_combo;
	}

	public void setTexto_combo(String texto_combo) {
		this.texto_combo = texto_combo;
	}

}
