package com.atrium.controller;

import java.util.Locale;

import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.atrium.dominio.Datos_Subida;
import com.atrium.hibernate.Usuarios;

/**
 * Accion de arranque de aplicacion para la creacion del objeto de dominio
 * vacio.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 21-6-2017.
 * 
 */
@Controller("inicio_accion")
@Scope("prototype")
public class Inicio_Accion {

	public Inicio_Accion() {
		System.out.println("SOY EL CONTROLLER DE LA ACCION DE INICIO");
	}

	@PreDestroy
	public void fin_Inicio() {
		System.out.println("ELIMINAMOS INICIO SESION");
	}

	/**
	 * Peticion inicial de arranque de aplicacion.<br/>
	 * Añadido gestion propia de idioma preferido por el usuario.
	 * 
	 * @return
	 */
	@RequestMapping("/inicio_accion.htm")
	public ModelAndView inicio(HttpServletRequest peticion, HttpServletResponse respuesta, HttpSession sesion) {
		// GENERACION DE UN USUARIO PARA LA EJECUCION DE LA PRUEBA. SUSTITUYE AL
		// PROCESO DE LOGIN
		Usuarios usuario_ficticio = new Usuarios();
		usuario_ficticio.setNombreUsuario("Juan");
		usuario_ficticio.setPassword("admin");
		usuario_ficticio.setCarpetaDocumentacion("LA MIA");
		peticion.getSession().setAttribute("usuario", usuario_ficticio);
		// PROCESO DE IDIOMATIZACION SEGUN REGLAS PROPIAS
		boolean no_elegido = true;
		// ESTABLECEMOS EL IDIOMA POR DEFECTO DEFINIDO EN EL WEB.XML
		String idioma_elegido_peticion = peticion.getSession(false).getServletContext()
				.getInitParameter("idioma_por_defecto");
		// RECOGEMOS EL PARAMETRO QUE NOS DICE EL IDIOMA PREFERIDO EN EL
		// NAVEGADOR DEL USUARIO
		String idioma_preferido = peticion.getHeader("accept-language");
		// DIVIDIMOS LA CADENA EN PARTES PARA EL CASO DE TENER MAS DE UN IDIOMA
		// ELEGIDO
		String lista_idiomas[] = idioma_preferido.split(",");
		// BUSCAMOS DENTRO DE LOS IDIOMAS ACCESIBLES EL QUE CORRESPONDA A LA
		// PREFERANCIA DEL USUARIO
		for (int i = 0; i < lista_idiomas.length; i++) {
			if (lista_idiomas[i].substring(0, 2).equals("es") && no_elegido) {
				idioma_elegido_peticion = "es";
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals("en") && no_elegido) {
				idioma_elegido_peticion = "en";
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals("fr") && no_elegido) {
				idioma_elegido_peticion = "fr";
				no_elegido = false;
			}
			if (lista_idiomas[i].substring(0, 2).equals("de") && no_elegido) {
				idioma_elegido_peticion = "de";
				no_elegido = false;
			}
		}
		// RECOGEMOS EL OBJETO DE SPRING QUE GESTIONA LOS LOCALES
		LocaleResolver gestor_locale = RequestContextUtils.getLocaleResolver(peticion);
		// SE CREA UN NUEVO OBJETO LOCALE PARA MODIFICAR EL IDIOMA
		Locale nuevo_idioma = new Locale(idioma_elegido_peticion);
		// MODIFICAMOS EL IDIOMA
		gestor_locale.setLocale(peticion, respuesta, nuevo_idioma);
		// MODELO PARA LA VISTA INICIAL
		Datos_Subida command_inicial = new Datos_Subida();
		// NAVEGACION A LA PANTALLA PRINCIPAL DE LA APLICACION
		return new ModelAndView("subida", "datos_subida", command_inicial);
	}
}
