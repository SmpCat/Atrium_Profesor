package com.atrium.util;

/**
 * Parametrizacion de tipos de error en la base de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 6-6-2017.
 *
 */
public interface ITipos_Incidencias {
	// INCIDENCIAS JDBC
	public static int JDBC = 1;
	// INCIDENCIAS HIBERNATE
	public static int HIBERNATE = 100;
	public static int HIBERNATE_CONEXION = 110;
	public static int HIBERNATE_SQL = 115;
	public static int HIBERNATE_CONSTRAINT = 120;
	public static int HIBERNATE_BLOQUEO = 125;
	public static int HIBERNATE_GENERICO = 130;
	public static int HIBERNATE_TIMEOUT = 135;
	public static int HIBERNATE_DATA = 140;
	// INCIDENCIAS SPRING
	public static int SPRING = 200;
	public static int SPRING_CONSTRAINT = 210;
	public static int SPRING_DATASOURCE = 215;
	public static int SPRING_TRANSACCION = 220;
	public static int SPRING_PK = 225;
	public static int SPRING_OPTIMISTA = 230;
	public static int SPRING_PESIMISTA = 235;
}
