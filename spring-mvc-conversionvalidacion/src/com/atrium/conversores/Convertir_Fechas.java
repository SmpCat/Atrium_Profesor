package com.atrium.conversores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * Procesos de conversion de fechas segun pais elegido.<br/>
 * Establece como comportamiento por defecto al no convertir campos vacios como
 * JSF.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 17-11-2017.
 * 
 */
public class Convertir_Fechas implements Formatter<Date> {
	// PROPIEDADES PARA EL PROCESO
	private DateFormat formato_fecha;
	private int tipo_formato;

	// ********** ZONA DE CONSTRUCTORES
	public Convertir_Fechas() {
		tipo_formato = DateFormat.SHORT;
	}

	public Convertir_Fechas(int tipo_fecha) {
		tipo_formato = tipo_fecha;
	}

	// ********** FIN ZONA DE CONSTRUCTORES

	/**
	 * Conversion de salida. Se recibe el objeto y se transforma a String para
	 * la pagina html.
	 */
	@Override
	public String print(Date fecha, Locale pais) {
		formato_fecha = SimpleDateFormat.getDateInstance(tipo_formato, pais);
		String resultado = null;
		if (fecha != null) {
			resultado = formato_fecha.format(fecha);
		}
		return resultado;
	}

	/**
	 * Conversion de entrada. Se recibe el texto de la peticion y se crea el
	 * objeto correspondiente para el objeto de dominio.<br/>
	 * En este caso Date.
	 */
	@Override
	public Date parse(String fecha, Locale pais) throws ParseException {
		formato_fecha = SimpleDateFormat.getDateInstance(tipo_formato, pais);
		Date resultado = null;
		if (fecha != null && fecha != "") {
			try {
				resultado = formato_fecha.parse(fecha);
			} catch (ParseException e) {
				throw new ParseException("Error de formato de texto", 0);
			}
		}
		return resultado;
	}

}
