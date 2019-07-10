package com.atrium.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.atrium.dominio.Datos_Login;
import com.atrium.validadores.Validar_CredencialesLogin;

/**
 * Ejemplo con distintas opciones de tratamiento de peticiones en spring MVC con
 * anotaciones.<br/>
 * La anotacion que establece que metodo atiende la peticion se debe de cambiar
 * segun cual sea de las posibles opciones la que queramos usar.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 8-11-2017.
 * 
 */
@Controller("login_accion")
@Scope("prototype")
public class Login_Accion {

	public Login_Accion() {
		System.out.println("Soy login_accion");
	}

	// ************* METODOS DE EJEMPLO DE USO DE REQUESTMAPPING
	/**
	 * 1º Opcion.</br> Metodo de logica para resolver la peticion. Se establece
	 * la URL como forma de identificar el metodo a ejecutar.</br> Otras formas
	 * validas son:@RequestMapping(method="",params=[],headers=[]) para definir
	 * las peticiones a atender.</br>
	 * 
	 * @param peticion
	 *            Objeto peticion {@link HttpServletRequest} que inyectado
	 *            automaticamente por el controlado en funcion de su tipo.
	 * @param respuesta
	 *            Objeto respuesta {@link HttpServletResponse} que inyectado
	 *            automaticamente por el controlado en funcion de su tipo.
	 * 
	 * @return Objeto del tipo {@link ModelAndView} que le dira al controlador
	 *         la navegacion a partir de la accion.
	 */
	@RequestMapping(value = "/login_accion1.htm")
	public ModelAndView comprobar_Credenciales(HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		System.out.println("");
		return null;
	}

	/**
	 * 2º Opcion.</br> Metodo de logica para resolver la peticion. Se establece
	 * la URL como forma de identificar el metod a ejecutar.</br> Otras formas
	 * validas son:@RequestMapping(method="",params=[],headers=[]) para definir
	 * las peticiones a atender.</br>
	 * 
	 * @ModelAttribute("datos_login") Define que objeto se va a inyectar por el
	 *                                controlador para la realizacion del
	 *                                proceso.
	 * @param datos_formulario
	 *            Objeto recibido de parte del controlador con la informacion de
	 *            la peticion del usuario (objeto de dominio).
	 * @param errores
	 *            Objeto propio de Spring MVC {@link BindingResult} para el
	 *            registro de mensajes de error durante el proceso de peticion.
	 * @param peticion
	 *            Objeto peticion {@link HttpServletRequest} que inyectado
	 *            automaticamente por el controlado en funcion de su tipo.
	 * @param respuesta
	 *            Objeto respuesta {@link HttpServletResponse} que inyectado
	 *            automaticamente por el controlado en funcion de su tipo.
	 * @return Objeto del tipo {@link ModelAndView} que le dira al controlador
	 *         la navegacion a partir de la accion.
	 */
	@RequestMapping("/login_accion2.htm")
	public ModelAndView comprobar_Credenciales(
			@ModelAttribute("datos_login") Datos_Login datos_formulario,
			BindingResult errores, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		System.out.println("");
		return null;
	}

	/**
	 * 3º Opcion.</br> Los parametros reciben la informacion de la peticion.
	 * 
	 * @ModelAttribute("nombre_usuario") Define la propiedad del objeto de
	 *                                   dominio que se va a inyectar por el
	 *                                   controlador en el parametro del metodo.
	 * @param nombre_usuario
	 *            Parametro que recibira el valor del parametro de la peticion.
	 * @param clave_usuario
	 *            Parametro que recibira el valor del parametro de la peticion.
	 */
	@RequestMapping("/login_accion3.htm")
	public ModelAndView comprobar_Credenciales(
			@ModelAttribute("nombre_usuario") String nombre_usuario,
			@ModelAttribute("clave") String clave_usuario) {
		System.out.println("");
		return null;
	}

	// ************* FIN METODOS DE EJEMPLO DE USO DE REQUESTMAPPING

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
			@Validated @ModelAttribute("datos_login") Datos_Login datos_formulario,
			BindingResult errores, HttpServletRequest peticion,
			HttpServletResponse respuesta) {

		return null;
	}

	/**
	 * Carga del validador personalizado para el modelo datos_login.<br/>
	 * Para la version de validacion con jsr303 se retira la anotacion
	 * initbinder del metodo.<br/>
	 * 
	 * @InitBinder Indica la ejecucion de este metodo para la definicion de el
	 *             proceso de validacion, obligatoria.
	 * 
	 * @param registro_validador
	 *            Objeto {@link WebDataBinder} de spring para registrar el
	 *            validador personalizado.
	 */
	@InitBinder
	public void validar_Usuario(WebDataBinder registro_validador) {
		registro_validador.setValidator(new Validar_CredencialesLogin());
	}

	/**
	 * Creacion y definicion del modelo/command a usar el proceso. La anotacion
	 * le define al controlador que objeto usar como dominio.
	 * 
	 * @return Objeto de dominio creado para la pagina y el proceso posterior.
	 */
	@ModelAttribute("datos_login")
	public Datos_Login crear_Modelo() {
		Datos_Login datos_login = new Datos_Login();
		return datos_login;
	}

}
