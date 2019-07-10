package com.atrium.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_usuario;
import com.atrium.util.Acceso_Contextos;
import com.atrium.util.Ejecucion_Expresiones;

@ManagedBean(name = "login_bean")
@ViewScoped
public class Login_Bean implements Serializable {
	// PROPIEDADES PARA RECIBIR LOS VALORES DE LOS COMPONENTES
	private String nombre;
	private String clave;
	// FACHADA DE LA CAPA MODELO
	// @ManagedProperty("#{gestion_usuario}")
	private IGestion_usuario gestion_usuarios;
	// CONTROL DE NAVEGACION
	private String salida;

	public Login_Bean() {
		System.out.println("soy login bean");
		salida = "incorrecto";
	}

	/**
	 * Metodo de logica/accion.
	 * 
	 * @return
	 */
	public String comprobar_Credenciales() {
		if (salida.equals("correcto")) {
			return salida;
		} else {
			return "";
		}
	}

	/**
	 * Metodo de evento.
	 */
	public void evento_ComprobarCredenciales(ActionEvent evento) {
		// Usuarios usuario = gestion_usuarios.consultar_PorNombre(getNombre());
		Usuarios usuario = Ejecucion_Expresiones.tratar_Expresion(
				"#{gestion_usuario}", IGestion_usuario.class)
				.consultar_PorNombre(getNombre());

		if (usuario != null) {
			if (usuario.getPassword().equals(getClave())) {
				// CREDENCIALES CORRECTAS
				// NAVEGACION A LA SIGUIENTE VISTA
				salida = "correcto";
				// GUARDAMOS EL PERFIL DE USUARIO EN LA SESION
				Acceso_Contextos.setAtributo("usuario", usuario);
			} else {
				// ERROR EN LA CLAVE -- OPCION IDIOMATIZADA
				// RECORDAR QUE EL IDENTIFICADOR DEBE IR CUALIFICADO CON EL ID
				// DEL FORMULARIO SIEMPRE Y CUANDO EL COMPONENTE ESTE DENTRO DEL
				// FORMULARIO
				Acceso_Contextos.addMensaje_Idioma("error.login.clave", null,
						Acceso_Contextos.INFO, "formu_login:clave_login");
			}
		} else {
			// ERROR EN EL NOMBRE
			Acceso_Contextos.addMensaje_Idioma("error.login.nombre", null,
					Acceso_Contextos.WARN, "formu_login:nombre_login");
		}
	}

	// ACCESORES PARA JSF
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	// ACCESORES PARA SPRING
	public void setGestion_usuarios(IGestion_usuario gestion_usuarios) {
		this.gestion_usuarios = gestion_usuarios;
	}

}
