package com.atrium.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atrium.hibernate.Provincias;
import com.atrium.hibernate.modelo.IGestion_Provincia;
import com.atrium.spring.Acceso_ApplicationContext;

/**
 * Proceso de creacion dinamica del contenido del combo de provincias con
 * control de ordenacion mediante atributos de la etiqueta.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 2-6-2018.
 * 
 */
public class Lista_Provincias extends SimpleTagSupport {
	// PROPIEDADES DE CLASE
	private String pais_seleccionado;
	private String provincia_seleccionado;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer salida = new StringBuffer();
		if (!pais_seleccionado.equals("") && pais_seleccionado.equals("73")) {
			// MARCA PARA SELECCIONAR EL PAIS ELEGIDO POR EL USUARIO
			String seleccionado = null;
			// TENEMOS CODIGO PAIS, PETICION DE USUARIO
			// CONSULTA A LA BASE DE DATOS
			List<Provincias> lista_provincias = Acceso_ApplicationContext
					.getBean(IGestion_Provincia.class).consultar_todas();
			// GENERACION DEL HTML PARA LA PAGINA
			for (Provincias provincia : lista_provincias) {
				if (!provincia_seleccionado.equals("")
						&& provincia_seleccionado.equals(provincia
								.getCodigoProvincia().toString())) {
					seleccionado = "selected";
				} else {
					seleccionado = "";
				}
				salida.append("\n<option value='"
						+ provincia.getCodigoProvincia() + "' " + seleccionado
						+ " >" + provincia.getProvincia() + "</option>");
			}
		} else {
			// NO TENEMOS CODIGO PAIS, PRIMERA PETICION DE PAGINA
			salida.append("<option value=''>Seleccione un pais</option>");
		}
		// ESCRIBIMOS EL HTML EN LA PAGINA
		this.getJspContext().getOut().write(salida.toString());
	}

	public void setPais_seleccionado(String pais_seleccionado) {
		this.pais_seleccionado = pais_seleccionado;
	}

	public void setProvincia_seleccionado(String provincia_seleccionado) {
		this.provincia_seleccionado = provincia_seleccionado;
	}

}
