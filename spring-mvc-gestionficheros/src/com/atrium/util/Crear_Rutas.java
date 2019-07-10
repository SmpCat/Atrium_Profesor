package com.atrium.util;

import java.io.File;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuarios;


/**
 * Procesos de creacion/comprobacion de carpetas en el repositorio documental de
 * la aplicacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 9-2-2017.
 * 
 */
@Component("crear_rutas")
@Scope("prototype")
public class Crear_Rutas implements ICrear_Ruta {

	/**
	 * Creacion de la carpeta general para el repositorio documental. Estrategia
	 * de creacion, dentro de la aplicacion WEB.
	 * 
	 * @param repositorio
	 *            Nombre de la carpeta.
	 * @return Ruta absoluta de la carpeta creada/comprobada.
	 */
	@Override
	public String crear_CarpetaRepositorio(String repositorio) {
		File carpeta = new File(Acceso_ApplicationContext.getServletContext()
				.getRealPath(repositorio));
		if (!carpeta.exists()) {
			carpeta.mkdirs();
		}
		return carpeta.getAbsolutePath();
	}

	/**
	 * Proceso mediante el cual creamos la primera carpeta de cada usuario, sino
	 * existe. Ademas comprobamos que sea un usuario valido. A continuacion en
	 * caso de que tenga alguna preferecia en su perfil creamos una nueva
	 * carpeta para la documentacion. Se establece un sistema para
	 * autoconfigurar en nombre y ruta de la carpeta general (repositorio
	 * documental)
	 * 
	 * @param clave_usuario
	 */
	@Override
	public String crear_Carpetas(String nombre_usuario, String clave_usuario) {
		// LEO USUARIO Y COMPRUEBO QUE EXISTA
		IGestion_Usuarios ges_usu = Acceso_ApplicationContext
				.getBean(IGestion_Usuarios.class);
		Usuarios usuario = ges_usu.consultar_PorNombre(nombre_usuario);
		String ruta_salida = null;
		if (usuario != null) {
			String carpeta_principal_usuario = Acceso_ApplicationContext
					.getServletContext()
					.getRealPath(
							Acceso_ApplicationContext.getServletContext()
									.getInitParameter("repositorio_documental"));
			File carpeta = new File(carpeta_principal_usuario);
			// CREO SU CARPETA SINO EXISTE EN LA CARPETA GENERAL PARA LA
			// DOCUMENTACION
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}
			ruta_salida = carpeta.getAbsolutePath();
			// A CONTINUACION COMPRUEBA LA CARPETA PROPIA DE USUARIO
			if (usuario.getCarpetaDocumentacion() != null) {
				// SI EXISTE SERA EL NOMBRE DEL CAMPO EN LA BASE DE DATOS
				File carpeta_personalizada = new File(carpeta.getPath() + "/"
						+ usuario.getCarpetaDocumentacion());
				if (!carpeta_personalizada.exists()) {
					carpeta_personalizada.mkdirs();
				}
				ruta_salida = carpeta_personalizada.getAbsolutePath();
			} else {
				// SINO EXISTE SERA EL NOMBRE DE USUARIO COMO NOMBRE DE CARPETA
				File carpeta_personalizada = new File(carpeta.getPath() + "/"
						+ usuario.getNombreUsuario());
				if (!carpeta_personalizada.exists()) {
					carpeta_personalizada.mkdirs();
				}
				ruta_salida = carpeta_personalizada.getAbsolutePath();
			}
		}
		return ruta_salida;
	}

	/**
	 * Creacion en dos pasos.<br/>
	 * 1º Creacion/comprobacion de la carpeta general a partir de un parametro
	 * del web.xml <br/>
	 * 2º Creacion/comprobacion de la carpeta del usurio a partir de la cadena
	 * dada.<br/>
	 * Una vez echo lo anterior se devuelve la ruta de la carpeta del usuario
	 * com un string
	 * 
	 * @param Carpeta_usuario
	 * 
	 * @return Ruta de la carpeta del usuario una vez comprobada/creada.
	 */
	@Override
	public String crear_Carpetas(String carpeta_usuario) {
		String ruta_salida = null;
		// ACCEDEMOS AL FICHERO DE CONFIGURACION Y LEEMOS EL PARAMETRO NECESARIO
		String carpeta_principal_usuario = Acceso_ApplicationContext
				.getServletContext().getRealPath(
						Acceso_ApplicationContext.getServletContext()
								.getInitParameter("repositorio_documental"));
		File carpeta = new File(carpeta_principal_usuario);
		// CREO SU CARPETA SINO EXISTE EN LA CARPETA GENERAL PARA LA
		// DOCUMENTACION
		if (!carpeta.exists()) {
			carpeta.mkdirs();
		}
		// A CONTINUACION COMPRUEBA LA CARPETA PROPIA DE USUARIO
		File carpeta_personalizada = new File(carpeta.getPath() + "/"
				+ carpeta_usuario);
		if (!carpeta_personalizada.exists()) {
			carpeta_personalizada.mkdirs();
		}
		ruta_salida = carpeta_personalizada.getAbsolutePath();
		return ruta_salida;
	}
}
