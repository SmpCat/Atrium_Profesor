package com.atrium.etiquetas;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.modelo.IGestion_Municipios;
import com.atrium.spring.Acceso_ApplicationContext;

/**
 * Proceso de creacion del contenido dinamico de la lista de municipios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 2-6-2018.
 *
 */
public class Lista_Municipios extends SimpleTagSupport {
	// PROPIEDAD DE CLASE
	private String provincia_seleccionado;

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer salida = new StringBuffer();
		if (!provincia_seleccionado.equals("")) {
			// TENEMOS CODIGO PROVINCIA, PETICION DE USUARIO
			// CONSULTA A LA BASE DE DATOS
			List<Municipios> lista_municipios = Acceso_ApplicationContext
					.getBean(IGestion_Municipios.class)
					.consultar_PorProviincia(new Byte(provincia_seleccionado));
			if (!lista_municipios.isEmpty()) {
				// GENERACION DEL HTML PARA LA PAGINA
				for (Municipios municipio : lista_municipios) {
					salida.append("\n<option value='"
							+ municipio.getId().getCodigoMunicipio() + "'>"
							+ municipio.getMunicipio() + "</option>");
				}
			}
		}
		if (salida.length() == 0) {
			// NO TENEMOS PROVINCIA SELECCIONADA, PRIMERA PETICION DE PAGINA
			salida.append("<option value=''>Seleccione una provincia</option>");
		}
		// ESCRIBIMOS EL HTML EN LA PAGINA
		this.getJspContext().getOut().write(salida.toString());
	}

	// ACCESORES PARA EL SERVIDOR
	public String getProvincia_seleccionado() {
		return provincia_seleccionado;
	}

	public void setProvincia_seleccionado(String provincia_seleccionado) {
		this.provincia_seleccionado = provincia_seleccionado;
	}

}
