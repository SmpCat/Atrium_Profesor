package com.atrium.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.atrium.modelo.Provincia;

/**
 * DAO simulado para el uso de colecciones.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 30-3-2016.
 * 
 * 
 */
public class Provincias_DAO {

	/**
	 * Proceso de consulta (simulado) de todas las provincias.
	 * 
	 * @return Coleccion de provincias.
	 */
	public List<Provincia> consultar_Todas() {
		List<Provincia> lista = new ArrayList<>();
		Provincia provincia = new Provincia();
		provincia.setCodigoProvincia(new Byte((byte) 1));
		provincia.setProvincia("Provincia 1");
		lista.add(provincia);
		provincia = new Provincia();
		provincia.setCodigoProvincia(new Byte((byte) 2));
		provincia.setProvincia("Provincia 2");
		lista.add(provincia);
		provincia = new Provincia();
		provincia.setCodigoProvincia(new Byte((byte) 3));
		provincia.setProvincia("Provincia 3");
		lista.add(provincia);
		provincia = new Provincia();
		provincia.setCodigoProvincia(new Byte((byte) 28));
		provincia.setProvincia("Madrid");
		lista.add(provincia);

		return lista;
	}
}
