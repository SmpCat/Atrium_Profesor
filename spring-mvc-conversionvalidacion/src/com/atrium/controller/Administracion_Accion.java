package com.atrium.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atrium.dominio.Datos_Usuario;
import com.atrium.hibernate.Roles;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Roles;
import com.atrium.validadores.Validar_Usuario;

/**
 * Procesos de administracion de usuarios.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 10-11-2017.
 * 
 */
@Controller("administracion_accion")
@Scope("prototype")
public class Administracion_Accion {

	// PROPIEDADES PARA LOS PROCESOS DE ADMINISTRACION
	private Datos_Usuario datos_usuario;
	private ModelAndView navegacion;
	private Validar_Usuario validar_usuarios;

	public Administracion_Accion() {
		System.out.println("soy el controller de usuario");
	}

	/**
	 * Proceso de alta de usuario.
	 * 
	 * @param usuario_administracion
	 *            Objeto de dominio con la informacion de la peticion,
	 *            convertida y validada.
	 * @param errores
	 *            Posibles errores de la conversion o validacion.
	 * @return Navegacion segun logica.
	 */
	@RequestMapping(value = "/usuario.htm")
	public ModelAndView alta_Usuario(
			@Validated @ModelAttribute("usuario_peticion") Datos_Usuario usuario_administracion,
			BindingResult errores, HttpServletRequest peticion,
			HttpServletResponse respuesta) {
		// /RECARGA DE LA PAGINA DE PRUEBA
		navegacion = new ModelAndView("administracion", "usuario_peticion",
				usuario_administracion);
		return navegacion;
	}

	/**
	 * Carga del validador personalizado para el modelo datos_login.<br/>
	 * Para la version de validacion con jsr303 se retira la anotacion
	 * initbinder del metodo.<br/>
	 * 
	 * @InitBinder Indica la ejecucion de este metodo para la definicion de el
	 *             proceso de validacion, oblogatoria.
	 * 
	 * @param registro_validador
	 *            Objeto {@link WebDataBinder} de spring para el registras el
	 *            validador personalizado.
	 */
	@InitBinder
	public void cargar_Validacion(WebDataBinder registro_validadores) {
		registro_validadores.setValidator(validar_usuarios);
	}

	/**
	 * Gestion de la creacion del objeto de dominio.
	 * 
	 * @return
	 */
	@ModelAttribute("usuario_peticion")
	public Datos_Usuario crear_UsuarioPeticion() {
		this.iniciar_Dominio();
		return datos_usuario;
	}

	/**
	 * Proceso de iniciacion de valores para el objeto de dominio.
	 */
	private void iniciar_Dominio() {
		datos_usuario.setCarpetaDocumentacion("");
		datos_usuario.setFechaAlta(new Date());
		datos_usuario.setFechaBaja(null);
		datos_usuario.setNombreUsuario("");
		datos_usuario.setPassword("");
		datos_usuario.setIdioma("");
		datos_usuario.setRoles(null);
	}

	// ACCESORES PARA SPRING
	public void setNavegacion(ModelAndView navegacion) {
		this.navegacion = navegacion;
	}

	public void setValidar_usuarios(Validar_Usuario validar_usuarios) {
		this.validar_usuarios = validar_usuarios;
	}

	public void setDatos_usuario(Datos_Usuario datos_usuario) {
		this.datos_usuario = datos_usuario;
	}

}
