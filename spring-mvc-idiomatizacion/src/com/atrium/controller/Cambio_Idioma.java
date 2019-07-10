package com.atrium.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.atrium.dominio.Datos_Login;

/**
 * Accion de cambio de idioma dimacamente por parte del usuario. Peticion por
 * hipervinculo, no hay formulario.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2017.
 * 
 */
@Controller("cambio_idioma")
@Scope("prototype")
public class Cambio_Idioma {
	// PROPIEDADES PARA LA GESTION DE LA INTERNACIONALIZACION
	private LocaleResolver gestor_locale;

	/**
	 * Proceso de tratamiento de la peticion via hipervinculo. Mas simple que la
	 * peticion de un formulario.
	 */
	@RequestMapping("/idioma.htm")
	public ModelAndView gestion_Idioma(HttpServletRequest peticion,
			HttpServletResponse respuesta,
			@RequestParam("idioma") String parametro_idioma) throws Exception {
		// RECOGEMOS EL OBJETO DE SPRING QUE GESTIONA LOS LOCALES
		gestor_locale = RequestContextUtils.getLocaleResolver(peticion);
		// SE CREA UN NUEVO OBJETO LOCALE PARA MODIFICAR EL IDIOMA
		Locale nuevo_idioma = new Locale(parametro_idioma);
		// MODIFICAMOS EL IDIOMA
		gestor_locale.setLocale(peticion, respuesta, nuevo_idioma);
		// INDICAMOS LA NAVEGACION MEDIANTE EL OBJETO MODELANDVIEW
		ModelAndView salida = new ModelAndView("login_mvc", "datos_login",
				new Datos_Login());
		return salida;
	}

}
