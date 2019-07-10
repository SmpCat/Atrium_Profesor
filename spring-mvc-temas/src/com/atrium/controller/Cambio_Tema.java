package com.atrium.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.atrium.dominio.Datos_Login;
import com.atrium.dominio.Datos_Temas;

/**
 * Resolucion de la peticion de cambio de tema por el usuario,
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2017.
 * 
 */
@Controller("cambio_temas")
@Scope("prototype")
public class Cambio_Tema {

	/**
	 * Peticion del combo en la pagina para cambiar dinamicamente el tema.
	 */
	@RequestMapping("/formu_cambiotema")
	protected ModelAndView cambiar_Tema(HttpServletRequest peticion,
			HttpServletResponse respuesta,
			@ModelAttribute Datos_Temas datos_formulario) throws Exception {
		// RECOGEMOS EL VALOR SELECCIONADO POR EL USUARIO
		String tema_pedido = datos_formulario.getTema();
		// RECOGEMOS EL OBJETO DE SPRING QUE GESTIONA LOS TEMAS
		ThemeResolver gestor_temas = RequestContextUtils
				.getThemeResolver(peticion);
		// PASAMOS EL VALOR DE LA PETICION AL RESOLUTOR PARA QUE LA PROCESE
		gestor_temas.setThemeName(peticion, respuesta, tema_pedido);
		// INDICAMOS LA NAVEGACION MEDIANTE EL OBJETO MODELANDVIEW
		ModelAndView salida = new ModelAndView("login_mvc", "datos_login",
				new Datos_Login());
		return salida;
	}

}
