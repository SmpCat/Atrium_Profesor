package com.atrium.modelo;

/**
 * Fachada de la capa de modelo para el DTO Datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-3-2016.
 * 
 */
public class Gestion_Datos implements IGestion_Datos {
	// DAO DE DATOS
	private Datos_DAO datos_dao;

	/**
	 * Constructor de la clase donde se instancia el DAO.
	 */
	public Gestion_Datos() {
		datos_dao = new Datos_DAO();
	}

	/**
	 * Proceso de lectura real de la fuente de datos.
	 * 
	 * @return Datos_DTO Objeto dto con la informacion obtenida en la lectura.
	 */
	@Override
	public Datos_DTO leer_Datos() {
		return datos_dao.leer_Datos();
	}

	/**
	 * Proceso de escritura real en la fuente de datos.
	 * 
	 * @param Datos_DTO
	 *            Objeto con la informacion que se escribira en la fuente de
	 *            datos.
	 * @return boolean Valor logico que indicara si el proceso de actuzlizacion
	 *         en la fuente de datos es correcta o no.
	 */
	@Override
	public boolean escribir_Datos(Datos_DTO datos) {
		return datos_dao.escribir_Datos(datos);
	}

}
