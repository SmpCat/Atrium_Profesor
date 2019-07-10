package com.atrium.controlador;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ejemplo de definicion de tipos de datos en Java y el uso de los metodos de
 * conversion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 26-9-2016.
 *
 */
public class Tipos_Datos {
	// PROPIEDADES DE CLASE
	// TEXTO
	private String texto;
	private Character caracter;
	// NUMERICOS
	private Byte entero_pequeño;
	private Short entero_corto;
	private Integer entero;
	private Long entero_grande;
	private Float decimal;
	private Double decimal_grande;
	// NUMERICOS ESPECIALES
	private BigInteger especial_entero;
	private BigDecimal especial_decimal;
	// LOGICOS
	private Boolean boleano;
	// FECHA-HORA
	private Date fecha_hora;

	public static void main(String arg[]) {
		Tipos_Datos prueba_datos = new Tipos_Datos();

		prueba_datos.prueba_Datos();

		prueba_datos.prueba_Conversion();
	}

	public void prueba_Datos() {
		// CADENA VACIA
		texto = "";
		texto = "Hola Mundo";
		texto = new String("Hola Mundo");
		// CARACTER
		caracter = new Character('d');
		// NUMERICOS
		entero_pequeño = new Byte((byte) 24);
		entero = new Integer(24);
		// LOGICO
		boleano = true;
		// FECHA HORA
		fecha_hora = new Date();
	}

	public void prueba_Conversion() {
		texto = "25";
		// CONVERSION DE TEXTO A NUMERO
		Integer numero_convertido = Integer.valueOf(texto);
		entero = new Integer(999);
		// CONVERSION DE NUMERO A TEXTO
		String texto_convertido = String.valueOf(entero);
		String texto_convertido2 = String.valueOf(entero.intValue());
		// OBJETO ENCARGADO DE CONVERTIR FECHAS
		SimpleDateFormat formato = new SimpleDateFormat("");

	}

}
