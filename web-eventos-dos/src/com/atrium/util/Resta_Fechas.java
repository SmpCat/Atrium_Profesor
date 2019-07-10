package com.atrium.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Utilidad de calculo de la diferencia entre dos fechas. Hay dos tipos de
 * calculo distintos. Calcular la diferencia en dias o dias,horas minutos y
 * segundos para una mayor precision.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0.
 * @since 20-10-2015
 */

public class Resta_Fechas {
	public static final String DIAS = "dias";
	public static final String HORAS = "horas";
	public static final String MINUTOS = "minutos";
	public static final String SEGUNDOS = "segundos";

	/**
	 * Calcula la diferencia entre dos fechas en horas minutos y segundos
	 * 
	 * @param fecha1
	 *            primera fecha
	 * @param fecha2
	 *            segunda fecha
	 * @return mapa que contiene separado los diferentes valores que son la
	 *         diferencia entre las fechas dadas. Las claves del mapa son horas,
	 *         minutos,segundos,dias
	 */
	public static Map<String, String> getDiferencia(Date fecha1, Date fecha2) {
		Date fechaMayor = null;
		Date fechaMenor = null;
		Map<String, String> resultadoMap = new HashMap<String, String>();

		// VERIFICAMOS CUAL ES LA MAYOR DE LAS DOS FECHAS, PARA NO TENER
		// SORPRESAS AL MOMENTO DE REALIZAR LA RESTA.
		if (fecha1.compareTo(fecha2) > 0) {
			fechaMayor = fecha1;
			fechaMenor = fecha2;
		} else {
			fechaMayor = fecha2;
			fechaMenor = fecha1;
		}
		// LOS MILISEGUNDOS DIFERENCIA ENTRE FECHAS
		long diferenciaMils = fechaMayor.getTime() - fechaMenor.getTime();

		// CALCULAMOS LOS SGUNDOS PARA LAS OPERACIONES
		long segundos = diferenciaMils / 1000;

		// CALCULAMOS LOS DIAS COMPLETOS
		long dias = segundos / (3600 * 24);
		// RECIBIMOS LOS SEGUNDOS SOBRANTES
		segundos = segundos % (3600 * 24);

		// OBTENEMOS LAS HORAS
		long horas = segundos / 3600;

		// RESTAMOS LAS HORAS PARA CONTINUAR CON MINUTOS
		segundos -= horas * 3600;

		// IGUAL QUE EL PASO ANTERIOR
		long minutos = segundos / 60;
		segundos -= minutos * 60;

		// PONEMOS LOS RESULTADOS EN UN MAPA
		resultadoMap.put("horas", Long.toString(horas));
		resultadoMap.put("minutos", Long.toString(minutos));
		resultadoMap.put("segundos", Long.toString(segundos));
		resultadoMap.put("dias", Long.toString(dias));
		return resultadoMap;
	}

	/**
	 * Devuelve la difencia entre dos fechas en dias
	 * 
	 * @param fechaInicial
	 *            primera fecha
	 * @param fechaFinal
	 *            segunda fecha
	 * @return valor que representa la diferencia entra las dos fechas dadas en
	 *         dias.
	 */
	public static int fechasDiferenciaEnDias(Date fechaInicial, Date fechaFinal) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String fechaInicioString = df.format(fechaInicial);
		try {
			fechaInicial = df.parse(fechaInicioString);
		} catch (java.text.ParseException ex) {
		}

		String fechaFinalString = df.format(fechaFinal);
		try {
			fechaFinal = df.parse(fechaFinalString);
		} catch (java.text.ParseException ex) {
		}

		long fechaInicialMs = fechaInicial.getTime();
		long fechaFinalMs = fechaFinal.getTime();
		long diferencia = fechaFinalMs - fechaInicialMs;
		double dias = Math.round(diferencia / (1000 * 60 * 60 * 24));
		return ((int) dias);
	}
}
