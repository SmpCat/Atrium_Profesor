package com.atrium.controller;

import java.io.File;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.atrium.dominio.Datos_Subida;
import com.atrium.hibernate.Usuarios;
import com.atrium.util.Acceso_ApplicationContext;
import com.atrium.util.ICrear_Ruta;
import com.atrium.util.ITratar_Ficheros;

/**
 * Controller de spring 4.x para la gestion de ficheros subidos al servidor.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0.
 * @since 9-2-2018.
 * 
 */
@Controller("subida_accion")
@Scope("prototype")
public class Subida_Accion {
	// OBJETO DE DOMINIO PARA LA PETICION
	private Datos_Subida datos_subida;
	// AUXILIARES DE PROCESO
	private ITratar_Ficheros tratar_ficheros;
	private ICrear_Ruta crear_rutas;
	private ModelAndView navegacion;

	/**
	 * Proceso de subida de fichero segun reglas definidas.
	 * 
	 * @param datos
	 *            Fichero temporal almacenado en el servidor a la espera de su
	 *            proceso.
	 * @param errores
	 *            Mensajes de error/confirmacion del proceso en el servidor.
	 * @param sesion
	 *            Acceso al perfil del usuario.
	 * @return Navegacion al portal.
	 */
	@RequestMapping("/subida.htm")
	public ModelAndView gestion_Fichero(
			@ModelAttribute("datos_subida") Datos_Subida datos,
			BindingResult errores, HttpSession sesion,
			HttpServletRequest peticion, HttpServletResponse respuesta) {
		// RECOGEMOS EL USUARIO DE LA SESION PARA PODER GUARDAR EL DOCUMENTO EN
		// SU CARPETA
		Usuarios usuario = ((Usuarios) sesion.getAttribute("usuario"));
		// COMPROBAMOS/CREAMOS LA CARPETA DEL USUARIO
		String carpeta = usuario.getCarpetaDocumentacion();
		if (carpeta == null) {
			carpeta = usuario.getNombreUsuario();
		}
		carpeta = crear_rutas.crear_Carpetas(carpeta);
		// DEFINIMOS EL FICHERO DE SALIDA DONDE SE GUARDARA LO SUBIDO
		// POR EL CLIENTE
		File fichero_entrada = new File(carpeta + "/"
				+ datos.getFichero_subido().getOriginalFilename());
		try {
			// COPIAMOS EL FILE CON LOS METODOS DE SPRING
			datos.getFichero_subido().transferTo(fichero_entrada);
			// FICHERO COPIADO CORRECTAMENTE
			errores.rejectValue("fichero_subido", "subida.confirmar.fichero",
					"Fichero subido correctamente");
		} catch (Exception e) {
			// FICHERO CON ERRORES EN LA COPIA
			errores.rejectValue("fichero_subido", "subida.error.fichero",
					"Error en la subida del fichero");
		}
		// BORRADO DEL FICHERO TEMPORAL
		((CommonsMultipartFile) datos.getFichero_subido()).getFileItem()
				.delete();
		// RECARGA DE LA PAGINA DE SUBIDA
		navegacion = new ModelAndView("subida", "datos_subida", datos);
		return navegacion;
	}

	@RequestMapping("/descarga.htm")
	public ModelAndView descargar_Fichero(
			@RequestParam("fichero") String fichero,
			HttpServletResponse respuesta, HttpSession sesion,
			HttpServletRequest peticion) {
		// PARAMETRO DE RESPUESTA INDICANDO EL TIPO MIME DE LA MISMA
		// EN ESTE CASO SE ABRE EN EL NAVEGADOR LA VENTANA DE ABRIR/GUARDAR
		respuesta.setContentType("application/force-download");
		// INDICAMOS EL NOMBRE DEL FICHERO ASOCIADO A LA REPUESTA
		respuesta.setHeader("Content-Disposition", "attachment;filename="
				+ fichero);
		// RECUPERAMOS EL USUARIO DE LA SESION
		Usuarios usuario = ((Usuarios) sesion.getAttribute("usuario"));
		// COMPROBAMOS/CREAMOS LA CARPETA DEL USUARIO
		String carpeta = crear_rutas.crear_Carpetas(usuario
				.getCarpetaDocumentacion());
		File fichero_aleer = new File(carpeta + "/" + fichero);
		// LEEMOS EL FICHERO A PARTIR DEL AUXILIAR
		try {
			// PEDIMOS AL SERVIDOR WEB EL FLUJO DE SALIDA
			ServletOutputStream flujo_salida = respuesta.getOutputStream();
			byte buffer[] = new byte[2048];
			int control_final = 0;
			while (true) {
				control_final = tratar_ficheros
						.leer_FicheroPorPaquetes(fichero_aleer);
				if (control_final == -1) {
					break;
				}
				// ESCRITURA EN EL FLUJO DE SALIDA
				flujo_salida.write(tratar_ficheros.getBuffer());
			}
		} catch (Exception e) {
			// ERROR EN EL PROCESO DE DESCARGA, SIN TRATAMIENTO
		}
		// RECARGA DE LA PAGINA DE SUBIDA
		navegacion = new ModelAndView("subida");
		return navegacion;
	}

	/**
	 * Proceso de borrado de fichero en el servidor segun demanda de cliente.
	 * 
	 * @param fichero
	 *            Nombre del fichero a borrar.
	 * @param sesion
	 *            Contexto de sesion para acceder al perfil del usuario.
	 * @return Navegacion al portal.
	 */
	@RequestMapping("/eliminar.htm")
	public ModelAndView borrar_Fichero(
			@ModelAttribute("datos_subida") Datos_Subida datos,
			BindingResult errores, HttpSession sesion,
			HttpServletRequest peticion, HttpServletResponse respuesta) {
		// RECUPERAMOS EL USUARIO DE LA SESION
		Usuarios usuario = ((Usuarios) sesion.getAttribute("usuario"));
		// COMPROBAMOS/CREAMOS LA CARPETA DEL USUARIO
		String carpeta = crear_rutas.crear_Carpetas(usuario
				.getCarpetaDocumentacion());
		// DEFINIMOS EL FICHERO A BORRAR
		File fichero_entrada = new File(carpeta + "/" + datos.getFichero());
		// BORRAMOS EL FICHERO DEL SERVIDOR
		boolean borrado = fichero_entrada.delete();
		if (borrado) {
			// CONFIRMACION DE LA ACCION
			errores.rejectValue("fichero", "borrado.confirmar.fichero",
					"Fichero eliminado correctamente");
		} else {
			// ERROR EN EL PROCESO DE BORRADO
			errores.rejectValue("fichero", "borrado.error.fichero",
					"Error en el borrado del fichero");
		}
		// RECARGA DE LA PAGINA DE SUBIDA
		navegacion = new ModelAndView("subida", "datos_subida", datos);
		return navegacion;
	}

	// ACCESORES PARA SPRING
	public ICrear_Ruta getCrear_rutas() {
		return crear_rutas;
	}

	public void setCrear_rutas(ICrear_Ruta crear_rutas) {
		this.crear_rutas = crear_rutas;
	}

	public ITratar_Ficheros getTratar_ficheros() {
		return tratar_ficheros;
	}

	public void setTratar_ficheros(ITratar_Ficheros tratar_ficheros) {
		this.tratar_ficheros = tratar_ficheros;
	}

}
