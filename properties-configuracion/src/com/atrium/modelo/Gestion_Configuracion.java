package com.atrium.modelo;

/**
 * Fachada del dao correspondiente a configuracion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-6-2015.
 * 
 */
public class Gestion_Configuracion implements IGestion_Configuracion {

	private Configuracion_DAO configuracion_dao;

	public Gestion_Configuracion() {
		configuracion_dao = new Configuracion_DAO();
		configuracion_dao.setRuta_properties("/com/atrium/configuracion/configuracion.properties");
	}

	// METODOS DE ACCION CON LA FUENTE DE DATOS
	@Override
	public Configuracion_DTO leer_Configuracion() {
		return configuracion_dao.cargar_Configuracion();
	}

	@Override
	public boolean modificar_Configuracion(
			Configuracion_DTO configuracion_modificada) {
		return configuracion_dao
				.modificar_Configuracion(configuracion_modificada);
	}

	@Override
	public boolean reestablecer_OpcionesPorDefecto() {
		return configuracion_dao.establecer_OpcionesDefecto();
	}

}
