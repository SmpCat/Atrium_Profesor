package com.atrium.util.foco;

import java.util.Locale;

/**
 * Conjunto de procesos de normalizacion del texto para establecer en las partes
 * de la informacion que lo necesiten.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2016.
 */
public class Aplicar_Normalizacion {

	/**
	 * Proceso interno en donde capitalizamos el texto recibido.
	 * 
	 * @param texto_recibido
	 *            Texto a capitalizar
	 * @return Testo capitalizado
	 */
	public static String capitalizar_texto(String texto_recibido) {
		if (texto_recibido == null) {
			return "";
		}
		StringBuffer texto_atratar = new StringBuffer(texto_recibido.trim()
				.toLowerCase());
		if (texto_atratar.length() == 0) {
			return texto_atratar.toString();
		}
		Character siguiente_caracter;
		int i = 0;
		siguiente_caracter = texto_atratar.charAt(i);
		while (i < texto_atratar.length()) {
			texto_atratar.setCharAt(i++,
					Character.toUpperCase(siguiente_caracter.charValue()));
			if (i == texto_atratar.length()) {
				return texto_atratar.toString();
			}
			// MIRAMOS LOS ESPACIOS EN BLANCO
			siguiente_caracter = texto_atratar.charAt(i);
			while (i < texto_atratar.length() - 2
					&& !Character.isWhitespace(siguiente_caracter.charValue())) {
				siguiente_caracter = texto_atratar.charAt(++i);
			}
			if (!Character.isWhitespace(siguiente_caracter.charValue())) {
				// SI NO HAY ESPACIO EN BLANCO ES EL FINAL DEL TEXTO
				return texto_atratar.toString();
			}
			// QUITAMOS TODOS LOS ESPACIOS EN BLANCO
			siguiente_caracter = texto_atratar.charAt(++i);
			while (i < texto_atratar.length()
					&& Character.isWhitespace(siguiente_caracter.charValue())) {
				texto_atratar.deleteCharAt(i);
				siguiente_caracter = texto_atratar.charAt(i);
			}
		}
		return texto_atratar.toString();
	}

	/**
	 * Damos el formato de parrafo al texto recibido.
	 * 
	 * @param texto
	 *            Texto a formatear.
	 * @return Texto ya formateado.
	 */
	public static String fraseado_Texto(String texto) {
		StringBuilder frasemayuscula = new StringBuilder();
		texto = texto.toLowerCase();
		String[] parrafos = texto.split("\\n");
		for (int i = 0, l = parrafos.length; i < l; ++i) {
			if (i > 0) {
				frasemayuscula.append(" ");
			}
			frasemayuscula.append(Character.toUpperCase(parrafos[i].charAt(0)))
					.append(parrafos[i].substring(1));
		}
		return texto;
	}

	/**
	 * Conversion de texto a mayusculas segun las normas definicadas en el
	 * locale por defecto.
	 * 
	 * @param texto_aconvertir
	 *            String a convertir
	 * @return Texto convertido.
	 */
	public static String texto_Mayuscula(String texto_aconvertir) {
		return texto_aconvertir.toUpperCase(Locale.getDefault());
	}

	/**
	 * Conversion de texto a minusculas segun las normas definicadas en el
	 * locale por defecto.
	 * 
	 * @param texto_aconvertir
	 *            String a convertir
	 * @return Texto convertido.
	 */
	public static String texto_Minuscula(String texto_aconvertir) {
		return texto_aconvertir.toLowerCase(Locale.getDefault());
	}
}
