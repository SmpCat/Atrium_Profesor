package com.atrium.etiquetas;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atrium.util.Acceso_ApplicationContext;
import com.atrium.util.Crear_Rutas;
import com.atrium.util.ICrear_Ruta;

/**
 * Creacion dinamica del contenido de una tabla que muestra todos los ficheros
 * de un usuario concreto.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 2.0.
 * @since 26-6-2017.
 * 
 */
public class Ficheros_Subidos extends SimpleTagSupport {

	// PROPIEDADES PARA LOS ATRIBUTOS DE LA ETIQUETA
	private String nombre_usuario;
	private String clave_usuario;

	@Override
	public void doTag() throws JspException, IOException {
		// COMPROBAMOS/CREAMOS LA CARPETA DEL USUARIO
		String carpeta = Acceso_ApplicationContext.getBean(ICrear_Ruta.class)
				.crear_Carpetas(getNombre_usuario(), getClave_usuario());
		// RECOGER EL CONTENIDO DE LA CARPETA
		File carpeta_usuario = new File(carpeta);
		File tabla_ficheros[] = carpeta_usuario.listFiles();
		int cuantos = tabla_ficheros.length;
		StringBuilder salida = new StringBuilder();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MMMM/yyyy HH:mm");
		// PROCESO DE LOS FICHEROS ENCONTRADOS EN LA CARPETA
		for (int i = 0; i < cuantos; i++) {
			double peso_fichero = (tabla_ficheros[i].length() / (1024.0 * 1024.0));
			salida.append("\n<tr><td>"
					+ tabla_ficheros[i].getName()
					+ "</td><td>"
					+ formato.format(new Date(tabla_ficheros[i].lastModified()))
					+ " </td><td style='text-align: right;'>"
					+ Math.rint(peso_fichero * 100) / 100 + " </td><td>"
					+ "<a href='descarga.htm?fichero="
					+ tabla_ficheros[i].getName() + "'> Bajar fichero</a>"
					+ "</td>" + "<td>" + "<a href='eliminar.htm?fichero="
					+ tabla_ficheros[i].getName()
					+ "'> Borrar fichero</a></td></tr>\n");
		}
		// MENSAJE EN CASO DE NO TENER NINGUN FICHERO EN EL SERVIDOR
		if (cuantos == 0) {
			salida.append("\n<tr><td  colspan='5' class='text-center text-uppercase'>No hay ningun fichero en el servidor para este usuario</td></tr>");
		}
		// ESCRIBIMOS EN LA PAGINA EL CODIGO HTML GENERADO
		this.getJspContext().getOut().write(salida.toString());
	}

	// ACCESORES PARA LOS ATRIBUTOS DE LA ETIQUETA
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getClave_usuario() {
		return clave_usuario;
	}

	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}
}
