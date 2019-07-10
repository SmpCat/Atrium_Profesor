package com.atrium.temas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.theme.AbstractThemeResolver;

/**
 * Definicion de tema propio. Establecimiento de nombre de tema y resto de
 * metodos que estimemos necesarios.<br/>
 * Añadido metodo para el proceso dinamico.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.5.
 * @since 10-11-2017.
 */
public class Resolutor_TemasSpring extends AbstractThemeResolver {
	// PROPIEDAD PARA CONTROLAR EL TEMA DE LA PAGINA
	private String tema_pedido;

	/**
	 * La cadena devuelta sera el nombre del properties junto con la ruta de
	 * paquetes cuya informacion defina los recursos estaticos (css, imagenes,
	 * textos, etc..) que defina el tema.<br/>
	 * Estos properties estaran en los paquetes de clases y los recursos
	 * llamados donde me interese.<br/>
	 * El codigo contempla que cada usuario tenga su propio estilo y por lo
	 * tanto establece y comprueba un atributo de sesion que controla el tema de
	 * cada usuario.
	 */
	@Override
	public String resolveThemeName(HttpServletRequest peticion) {
		// VERSION CARGANDA DEL TEMA SEGUN TIPO NAVEGADOR Y SESION
		if (peticion.getSession().getAttribute("tema_usuario") != null
				&& peticion.getSession().getAttribute("tema_usuario")
						.equals(tema_pedido)) {
			return tema_pedido;
		}
		// ESTABLECEMOS EL TEMA POR DEFECTO PARA EL CASO DE NAVEGADORES NO
		// PREVISTOS
		String tema_defecto = peticion.getSession().getServletContext()
				.getInitParameter("tema_pordefecto");
		boolean seleccionado = false;
		// VERSION CARGANDO TEMA SEGUN TIPO NAVEGADOR
		// RECOGEMOS EL NAVEGADOR USADO POR EL CLIENTE EN LA PETICION
		String navegador_cliente = peticion.getHeader("user-agent");
		if (navegador_cliente.contains("MSIE")
				|| navegador_cliente.contains("Windows")) {
			tema_pedido = "com.atrium.temas.tema_explorer";
			seleccionado = true;
		}
		if (navegador_cliente.contains("Chrome")) {
			tema_pedido = "com.atrium.temas.tema_chrome";
			seleccionado = true;
		}
		// SI NO ES NINGUN NAVEGADOR DE LOS PREVISTOS SE DA EL VALOR POR DEFECTO
		if (!seleccionado) {
			if (tema_defecto.equals("chrome")) {
				tema_pedido = "com.atrium.temas.tema_chrome";
			} else if (tema_defecto.equals("explorer")) {
				tema_pedido = "com.atrium.temas.tema_explorer";
			}
		}
		// GUARDAMOS EN LA SESION EL TEMA SELECCIONADO PARA EL USUARIO
		peticion.getSession().setAttribute("tema_usuario", tema_pedido);
		return tema_pedido;
	}

	/**
	 * Segun el valor de la peticion del usuario se cambia el tema de la pagina.
	 */
	@Override
	public void setThemeName(HttpServletRequest peticion,
			HttpServletResponse respuesta, String tema) {
		if (tema.equals("explorer")) {
			tema_pedido = "com.atrium.temas.tema_explorer";
		}
		if (tema.equals("chrome")) {
			tema_pedido = "com.atrium.temas.tema_chrome";
		}
		// GUARDAMOS EN LA SESION EL TEMA SELECCIONADO PARA EL USUARIO
		peticion.getSession().setAttribute("tema_usuario", tema_pedido);
	}

}
