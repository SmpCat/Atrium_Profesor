package com.atrium.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atrium.dominio.Datos_Login;

/**
 * Ejemplo de tratamiento de formulario. Tan solo es para soporte de la
 * internacionalizacion de las vistas.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2017.
 * 
 */
@Controller("login_accion")
@Scope("prototype")
public class Login_Accion {
	// PROPIEDADES PARA EL PROCESO
	// OBJETO DE DOMINIO DEL PROCESO
	private Datos_Login datos_login;

	public Login_Accion() {
		System.out.println("Soy login_accion");
	}

	// ************* PROCESOS DEL CONTROLLER

	/**
	 * Metodo de logica para resolver la peticion. Se establece la URL como
	 * forma de identificar el metod a ejecutar.</br> Otras formas validas
	 * son:@RequestMapping(method="",params=[],headers=[]) para definir las
	 * peticiones a atender.</br>
	 * 
	 * @ModelAttribute ("datos_login") Define que objeto se va a inyectar por el
	 *                 controlador para la realizacion del proceso.<br/>
	 * 
	 * @Validated anotacion que dispara el proceso de validacion.<br/>
	 * 
	 * @param datos_formulario
	 *            Objeto recibido de parte del controlador con la informacion de
	 *            la peticion del usuario (objeto de dominio).
	 * @param errores
	 *            Objeto {@link BindingResult} que contendra los posibles
	 *            errores registrados en los procesos de conversion y validacion
	 *            previos, si es que existen.
	 * @param peticion
	 *            Objeto peticion {@link HttpServletRequest} que inyectado
	 *            automaticamente por el controlado en funcion de su tipo.
	 * @param respuesta
	 *            Objeto respuesta {@link HttpServletResponse} que inyectado
	 *            automaticamente por el controlado en funcion de su tipo.
	 * @return Objeto que le dira al controlador la navegacion a partir de la
	 *         accion.
	 */
	@RequestMapping(value = "/login_accion.htm")
	public ModelAndView comprobar_CredencialesDefinitivo(
			@ModelAttribute("datos_login") Datos_Login datos_formulario,
			BindingResult errores, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		// NAVEGACION DE RESPUESTA
		ModelAndView salida = new ModelAndView("login_mvc");
		return salida;
	}

	/**
	 * Creacion y definicion del modelo/command a usar el proceso. La anotacion
	 * le define al controlador que objeto usar como dominio.
	 * 
	 * @return Objeto de dominio creado para la pagina y el proceso posterior.
	 */
	@ModelAttribute("datos_login")
	public Datos_Login crear_Modelo() {
		datos_login = new Datos_Login();
		return datos_login;
	}

}
