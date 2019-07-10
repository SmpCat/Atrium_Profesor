package com.atrium.modelo;

public interface IGestion_Configuracion {

	public Configuracion_DTO leer_Configuracion();

	public boolean modificar_Configuracion(
			Configuracion_DTO configuracion_modificada);

	public boolean reestablecer_OpcionesPorDefecto();

}