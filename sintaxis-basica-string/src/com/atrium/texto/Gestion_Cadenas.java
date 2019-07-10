package com.atrium.texto;

import java.util.Locale;

/**
 * Ejemplos de tratamiento de cadenas mediante la clase string. De uso frecuente
 * dentro del los programas en JAVA.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 11-10-2016.
 */
public class Gestion_Cadenas {

	/**
	 * Metodo que engloba todas las llamadas a los metodos. Solo con caracter
	 * documentativo.
	 */
	public void tratamiento_Cadenas() {
		String cadena_atratar = "SOY LA CADENA DE TEXTO QUE USAREMOS EN LA PRACTICA";

		// **** COMPARACION DE CADENAS
		// COMPARA LAS DOS CADENAS INDICANDO SI SON EXACTAMENTE IGUALES
		boolean cadenas_iguales = cadena_atratar.equals("CADENA A COMPARAR");
		// COMPARA LAS DOS CADENAS INDICANDO SI SON IGUALES OBVIANDO LAS
		// DIFERENCIAS ENTRE MAYUSCUALS Y MINUSCULAS
		cadenas_iguales = cadena_atratar
				.equalsIgnoreCase("soy la cadena de texto que usaremos en la practica");

		// **** BUSQUEDAS DE TEXTO
		// INDICA SI UN TEXTO ESTA CONTENIDO EN EL OTRO
		boolean encontrado = cadena_atratar.contains("cadena a buscar");
		// INDICA SI TEXTO TERMINA POR EL OTRO
		encontrado = cadena_atratar.endsWith("final cadena");
		// INDICA SI TEXTO EMPIEZA POR EL OTRO
		encontrado = cadena_atratar.startsWith("inicio cadena");
		// INDICA SI TEXTO ESTA CONTENIDO DENTRO DE OTRO -- EMPIEZA LA BUSQUEDA
		// POR LA IZQUIERDA
		int posicion = cadena_atratar.indexOf("cadena a buscar");
		// INDICA SI TEXTO ESTA CONTENIDO DENTRO DE OTRO -- EMPIEZA LA BUSQUEDA
		// POR LA DERECHA
		posicion = cadena_atratar.lastIndexOf("cadena a buscar");

		// BUSQUEDA DE TODAS LAS OCURRENCIAS DE UN TEXTO DENTRO DE OTRO
		// INICIAMOS LA PRIMERA POSICION 0
		posicion = 0;
		// BUSCAMOS DENTRO DE LA CADENA TANTAS VECES COMO SEA NECESARIO
		while (posicion != -1) {
			// ENCONTRAMOS LA POSICION DENTRO DE LA CADENA
			posicion = cadena_atratar.indexOf("cadena a buscar", posicion);
			// REALIZAMOS LA ACCION NECESARIA
			// NOS MOVEMOS A LA SIGUIENTE POSICION PARA SEGUIR BUSCANDO
			posicion++;
		}

		// **** TRATAMIENTO DEL TEXTO
		// SUSTITUCION DE UN TEXTO POR OTRO DENTRO DE LA CADENA
		cadena_atratar.replace("texto a reemplazar", "texto nuevo");
		// PARTICION DE UNA CADENA EN UNA SERIE DE ELEMENTOS DE UNA TABLA
		String tabla[] = cadena_atratar.split("texto por el que dividir");

		// **** INFORMACION DE LA CADENA
		// NUMERO DE CARACTERES DE LA CADENA
		int numero_caracteres = cadena_atratar.length();
		// INFORMACION DE SI ES UNA CADENA VACIA
		boolean cadena_vacia = cadena_atratar.isEmpty();

		// **** CONVERSION DE CADENAS
		// TODOS LOS CARACTERES PASAN A MINUSCULAS
		String cadena_minusculas = cadena_atratar.toLowerCase();
		// TODOS LOS CARACTERES PASAN A MAYUSCULAS
		String cadena_mayusculas = cadena_atratar.toUpperCase();
		// LAS CONVERSIONES DE TEXTO SE HACEN SIGUIENDO LAS REGLAS DEL IDIOMA
		// DADO
		cadena_minusculas = cadena_atratar.toLowerCase(new Locale("es"));
		cadena_mayusculas = cadena_atratar.toUpperCase(new Locale("es"));

		// ***** EXTRACCION DE CADENAS
		int posicion_inicial = 0;
		int posicion_final = 5;
		// EXTRACCION DESDE LA POSICION DADA INCLUSIVE -- POSICION INICIAL 0
		String cadena_extraida = cadena_atratar.substring(posicion_inicial);
		// EXTRACCION DESDE LA POSICION DADA INCLUSIVE HASTA LA POSICION DADA NO
		// INCLUIDA
		cadena_extraida = cadena_atratar.substring(posicion_inicial,
				posicion_final);
		// ELIMINA LOS ESPACIOS EN BLANCO POR DELANTE Y POR DETRAS DEL TEXTO
		cadena_extraida = cadena_atratar.trim();
	}
}
