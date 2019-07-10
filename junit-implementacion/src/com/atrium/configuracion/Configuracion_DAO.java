package com.atrium.configuracion;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.atrium.configuracion.Configuracion_DTO;

/**
 * Contiene la logica de tratamiento del fichero de configuracion.<br/>
 * Este fichero es de formato properties. Nombre configuracion y esta en el
 * mismo paquete que la clase.<br/>
 * Esta clase es el DAO de acceso a la fuente de datos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1
 * @serial 8-11-2016.
 */
public class Configuracion_DAO {
	// OBJETO PARA EL PROCESO LECTURA/ESCRITURA DEL PROPERTIES
	private Properties datos_configuracion;
	// DTO PARA EL TRANSPORTE DE LOS DATOS LEIDOS
	private Configuracion_DTO confi_dto;
	// RUTA Y NOMBRE DEL FICHERO PROPERTIES
	private String ruta_properties;

	/**
	 * Constructor en donde se instancian las propiedades de clase necesarias
	 * para el proceso a realizar.
	 */
	public Configuracion_DAO() {
		datos_configuracion = new Properties();
		confi_dto = new Configuracion_DTO();
	}

	public Configuracion_DAO(String ruta_nombreproperties) {
		this.ruta_properties = ruta_nombreproperties;
		datos_configuracion = new Properties();
		confi_dto = new Configuracion_DTO();
	}

	/**
	 * Proceso donde leemos del fichero de configuracion y a continuacion se
	 * pasan los valores leidos a propiedades de clase que seran visibles
	 * mediante accesores.
	 * 
	 */
	public Configuracion_DTO cargar_Configuracion() {
		// CARGAMOS LOS DATOS DEL FICHERO
		try {
			// LECTURA DEL FICHERO PROPERTIES
			datos_configuracion.load(this.getClass().getResourceAsStream(getRuta_properties()));
			// PASAMOS LA INFORMACION A LAS PROPIEDADES DEL DTO
			confi_dto.setAutor(datos_configuracion.getProperty("autor"));
			confi_dto.setRuta_depuracion(datos_configuracion.getProperty("ruta_depuracion"));
			confi_dto.setRuta_seguridad(datos_configuracion.getProperty("ruta_seguridad"));
			confi_dto.setRuta_bitacora(datos_configuracion.getProperty("ruta_bitacora"));
			confi_dto.setRuta_enginebirt(datos_configuracion.getProperty("ruta_enginebirt"));
			confi_dto.setRuta_logsbirt(datos_configuracion.getProperty("ruta_logsbirt"));
			confi_dto.setRuta_listados(datos_configuracion.getProperty("ruta_listados"));
			confi_dto.setRuta_serializacion(datos_configuracion.getProperty("ruta_serializacion"));
			confi_dto.setRuta_iconos(datos_configuracion.getProperty("ruta_iconos"));
			confi_dto.setRuta_imagenes(datos_configuracion.getProperty("ruta_imagenes"));
			confi_dto.setIdioma(datos_configuracion.getProperty("idioma"));
			confi_dto.setIdioma_preferido(datos_configuracion.getProperty("idioma.preferido"));
			confi_dto.setIdioma_defecto(datos_configuracion.getProperty("idioma.defecto"));
			confi_dto.setPermitir_idioma(datos_configuracion.getProperty("permitir_idioma"));
			confi_dto.setModo_ejecucion(datos_configuracion.getProperty("modo_ejecucion"));
			confi_dto.setRuta_ayuda(datos_configuracion.getProperty("ruta_ayuda"));
			confi_dto.setColor_fondo(datos_configuracion.getProperty("color_fondo"));
			// CONVERSION DE LA INFORMACION LEIDA
			confi_dto.setVersion(new Float(datos_configuracion.getProperty("version")));
			confi_dto.setFecha_actualizacion(
					new SimpleDateFormat("dd/MMMM/yyyy").parse(datos_configuracion.getProperty("fecha_actualizacion")));
		} catch (Exception e) {
			// TRATAMIENTO DE ERROR EN LA LECTURA
			confi_dto = null;
		}
		return confi_dto;
	}

	/**
	 * Proceso de modificacion del fichero de configuracion.<br/>
	 * Se reescriben todas las propiedades de nuevo con los valores modificados
	 * por el usuario.
	 * 
	 * @return boolean Indica si el proceso de grabacion se ha realizado
	 *         correctamente o no.
	 */
	public boolean modificar_Configuracion(Configuracion_DTO confi_dto) {
		boolean correcto = true;
		FileWriter salida;
		try {
			// RUTA DEL FICHERO DONDE SE ESCRIBE LA INFORMACION
			salida = new FileWriter(Configuracion_DAO.class.getResource(getRuta_properties()).getFile());
			SimpleDateFormat fecha = new SimpleDateFormat("dd-MMMM-yyyy HH:mm");
			// PASAMOS LOS DATOS DEL DTO AL PROPERTIES PARA SU ESCRITURA EN EL
			// FICHERO
			datos_configuracion.setProperty("version", confi_dto.getVersion().toString());
			if (confi_dto.getFecha_actualizacion() != null) {
				datos_configuracion.getProperty("fecha_actualizacion",
						fecha.format(confi_dto.getFecha_actualizacion()));
			} else {
				datos_configuracion.getProperty("fecha_actualizacion", "");
			}
			datos_configuracion.setProperty("autor", confi_dto.getAutor());
			datos_configuracion.setProperty("ruta_ayuda", confi_dto.getRuta_ayuda());
			datos_configuracion.setProperty("ruta_depuracion", confi_dto.getRuta_depuracion());
			datos_configuracion.setProperty("ruta_seguridad", confi_dto.getRuta_seguridad());
			datos_configuracion.setProperty("ruta_bitacora", confi_dto.getRuta_iconos());
			datos_configuracion.setProperty("ruta_enginebirt", confi_dto.getRuta_enginebirt());
			datos_configuracion.setProperty("ruta_logsbirt", confi_dto.getRuta_logsbirt());
			datos_configuracion.setProperty("ruta_listados", confi_dto.getRuta_listados());
			datos_configuracion.setProperty("ruta_serializacion", confi_dto.getRuta_serializacion());
			datos_configuracion.setProperty("ruta_iconos", confi_dto.getRuta_iconos());
			datos_configuracion.setProperty("ruta_imagenes", confi_dto.getRuta_imagenes());
			datos_configuracion.setProperty("idioma", confi_dto.getIdioma());
			datos_configuracion.setProperty("idioma.preferido", confi_dto.getIdioma_preferido());
			datos_configuracion.setProperty("idioma.defecto", confi_dto.getIdioma_defecto());
			datos_configuracion.setProperty("permitir_idioma", confi_dto.getPermitir_idioma());
			datos_configuracion.setProperty("modo_ejecucion", confi_dto.getModo_ejecucion());
			datos_configuracion.setProperty("color_fondo", confi_dto.getColor_fondo());
			// GRABAMOS LOS DATOS NUEVOS EN EL FICHERO
			datos_configuracion.store(salida, "MODIFICADO EL " + fecha.format(new Date()));
		} catch (IOException e) {
			// TRATAMIENTO DE ERROR EN LA ESCRITURA
			correcto = false;
		}
		return correcto;
	}

	/**
	 * Creacion del fichero properties con una serie de opciones por defecto.
	 * 
	 * @return boolean Indica si el proceso de grabacion se ha realizado
	 *         correctamente o no.
	 */
	public boolean establecer_OpcionesDefecto() {
		boolean valido = true;
		// ESTABLECEMOS LAS OPCIONES POR DEFECTO
		confi_dto.setVersion(new Float("1.8"));
		confi_dto.setFecha_actualizacion(new Date());
		confi_dto.setAutor("Profesor - Juan Antonio Solves Garcia");
		confi_dto.setRuta_ayuda("/com/atrium/ayuda/ayuda_gestioncomercial.hs");
		confi_dto.setRuta_depuracion("d:/directorio_logs/seguimiento/j316/");
		confi_dto.setRuta_seguridad("d:/directorio_logs/seguridad/j316/");
		confi_dto.setRuta_bitacora("d:/otros-logs/j316/");
		confi_dto.setRuta_enginebirt("D:/j316/birt-runtime-3_7_2/ReportEngine");
		confi_dto.setRuta_logsbirt("d:/otros_logs/logs-j316/");
		confi_dto.setRuta_listados("d:/informes/j316/");
		confi_dto.setRuta_serializacion("d:/informes/j316/serializar");
		confi_dto.setRuta_iconos("/com/atrium/imagenes/iconos/");
		confi_dto.setRuta_imagenes("/com/atrium/imagenes/");
		confi_dto.setIdioma("es");
		confi_dto.setIdioma_preferido("es");
		confi_dto.setIdioma_defecto("es");
		confi_dto.setPermitir_idioma("si");
		confi_dto.setModo_ejecucion("p");
		confi_dto.setColor_fondo("153,255,204");
		// ESCRIBIMOS LOS DATOS EN EL PROPERTIES
		valido = modificar_Configuracion(confi_dto);
		return valido;
	}

	// ACCESORES PARA LAS PROPIEDADES DE CLASE
	public String getRuta_properties() {
		return ruta_properties;
	}

	public void setRuta_properties(String ruta_properties) {
		this.ruta_properties = ruta_properties;
	}

	// ACCESORES PARA PRUEBAS
	public Properties getDatos_configuracion() {
		return datos_configuracion;
	}

	public Configuracion_DTO getConfi_dto() {
		return confi_dto;
	}

}
