package com.atrium.controlador;

import com.atrium.modelo.Configuracion_DAO;
import com.atrium.modelo.Configuracion_DTO;
import com.atrium.modelo.Gestion_Configuracion;
import com.atrium.modelo.IGestion_Configuracion;

/**
 * Ejemplo de uso de properties como fichero de configuracion y su tratamiento
 * como tal.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class Inicio {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// PRUEBAS DEL DAO (UNITARIA)
		Configuracion_DAO confi_dao = new Configuracion_DAO();
		confi_dao.setRuta_properties("/com/atrium/configuracion/configuracion.properties");
		// LECTURA DE SU CONTENIDO
		Configuracion_DTO datos = confi_dao.cargar_Configuracion();
		// MODIFICAMOS VALOR
		datos.setAutor("ninguno.....");
		// ESCRIBIMOS LOS CAMBIOS EN EL FICHERO
		boolean ff = confi_dao.modificar_Configuracion(datos);
		// REESTABLECEMOS LAS OPCIONES POR DEFECTO
		boolean ss = confi_dao.establecer_OpcionesDefecto();
		// PRUEBAS DE LA FACHADA (INTEGRACION)
		IGestion_Configuracion gestion_configuracion = new Gestion_Configuracion();
		// LECTURA DE SU CONTENIDO
		Configuracion_DTO configuracion = gestion_configuracion.leer_Configuracion();
		// MODIFICAMOS VALOR
		configuracion.setAutor("otro autor");
		// ESCRIBIMOS LOS CAMBIOS EN EL FICHERO
		boolean modificado = gestion_configuracion.modificar_Configuracion(configuracion);
		// COMPROBAMOS CAMBIO MEDIANTE UNA NUEVA LECTURA
		Configuracion_DTO otro = gestion_configuracion.leer_Configuracion();
		// REESTABLECEMOS LAS OPCIONES POR DEFECTO
		gestion_configuracion.reestablecer_OpcionesPorDefecto();
		// COMPROBAMOS LA RECARGA MEDIANTE UNA NUEVA LECTURA.
		Configuracion_DTO otro_mas = gestion_configuracion.leer_Configuracion();
	}

}
