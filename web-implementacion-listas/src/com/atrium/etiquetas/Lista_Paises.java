package com.atrium.etiquetas;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.modelo.IGestion_Pais;
import com.atrium.spring.Acceso_ApplicationContext;

/**
 * Proceso de creacion dinamica del contenido del combo de paises con control de
 * ordenacion mediante atributos de la etiqueta.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 2-6-2018.
 * 
 */
public class Lista_Paises extends SimpleTagSupport implements Comparator<Pais> {
	// PROPIEDADES DE CLASE PARA RECIBIR LOS ATRIBUTOS DE LA PAGINA
	private String campo;
	private String sentido;
	private String pais_seleccionado;

	@Override
	public void doTag() throws JspException, IOException {
		// MARCA PARA SELECCIONAR EL PAIS ELEGIDO POR EL USUARIO
		String seleccionado = null;
		// ACCESO A LA INFORMACION NECESARIO PARA EL PROCESO
		List<Pais> lista_paises = Acceso_ApplicationContext.getBean(
				IGestion_Pais.class).consultar_Todos();
		// ORDENAMOS COLECCION SEGUN VALORES DE ATRIBUTO
		Collections.sort(lista_paises, this);
		// OBJETO PARA IR ALMACENANDO LA INFORMACION DE SALIDA
		StringBuffer salida = new StringBuffer();
		// RECORRIDO DE LA COLECCION DE PAISES
		for (Pais pais : lista_paises) {
			if (!pais_seleccionado.equals("")
					&& pais_seleccionado
							.equals(pais.getCodigoPais().toString())) {
				seleccionado = "selected";
			} else {
				seleccionado = "";
			}
			salida.append("\n<option value='" + pais.getCodigoPais().toString()
					+ "' " + seleccionado + " >" + pais.getPaisNombre()
					+ "</option>");
		}
		// ESCRIBIMOS EL CODIGO HTML EN LA PAGINA
		this.getJspContext().getOut().write(salida.toString());
	}

	@Override
	public int compare(Pais pais1, Pais pais2) {
		int orden = 0;
		if (campo.equals("c") && sentido.equals("a")) {
			orden = pais1.getCodigoPais().compareTo(pais2.getCodigoPais());
		}
		if (campo.equals("c") && sentido.equals("d")) {
			orden = pais2.getCodigoPais().compareTo(pais1.getCodigoPais());
		}
		if (campo.equals("n") && sentido.equals("a")) {
			orden = pais1.getPaisNombre().compareTo(pais2.getPaisNombre());
		}
		if (campo.equals("n") && sentido.equals("d")) {
			orden = pais2.getPaisNombre().compareTo(pais1.getPaisNombre());
		}
		return orden;
	}

	// ACCESORES PARA LA INYECCION DE ATRIBUTOS POR PARTE DEL SERVIDOR
	public void setCampo(String campo) {
		this.campo = campo;
	}

	public void setSentido(String sentido) {
		this.sentido = sentido;
	}

	public void setPais_seleccionado(String pais_seleccionado) {
		this.pais_seleccionado = pais_seleccionado;
	}

}
