package com.atrium.conversores;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.atrium.hibernate.Roles;

/**
 * Conversion personalizada en spring mvc 3.X.<br/>
 * Establece como comportamiento por defecto el no convertir campos vacios como
 * JSF.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 17-11-2017.
 * 
 */
public class Convertir_Roles implements Formatter<Roles> {

	/**
	 * Conversion de salida de rol a texto.
	 */
	@Override
	public String print(Roles rol_aconvertir, Locale locale) {
		String texto_salida = null;
		if (rol_aconvertir != null && rol_aconvertir.getCodigoRol() != null) {
			texto_salida = String.valueOf(rol_aconvertir.getCodigoRol());
		}
		return texto_salida;
	}

	/**
	 * Conversion de entrada de texto a rol.
	 */
	@Override
	public Roles parse(String texto_aconvertir, Locale locale)
			throws ParseException {
		Roles rol_nuevo = null;
		if (texto_aconvertir != null && texto_aconvertir != "") {
			try {
				Byte numero = new Byte(texto_aconvertir);
				rol_nuevo = new Roles(numero);
			} catch (Exception e) {
				// NO ES VALOR QUE SE PUEDA CONVERTIR A NUMERO
				throw new ParseException("Error el valor enviado no se puede convertir a Rol", 0);
			}
		}
		return rol_nuevo;
	}

}
