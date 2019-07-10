package com.atrium.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.atrium.formbean.Login_Bean;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.modelo.IGestion_Usuario;
import com.atrium.spring.Acceso_ApplicationContext;

public class Login_Accion extends Action {

	@Override
	public ActionForward execute(ActionMapping mapa_navegacion,
			ActionForm datos_peticion, HttpServletRequest peticion,
			HttpServletResponse respuesta) throws Exception {
		// **** PROCESOS PARA STRUT
		Login_Bean datos = (Login_Bean) datos_peticion;
		ActionForward salida = mapa_navegacion.findForward("incorrecto");
		// CONSULTA A LA BD.
		Usuarios usuario = Acceso_ApplicationContext.getBean(
				IGestion_Usuario.class).consultar_PorNombre(datos.getNombre());
		if (usuario != null) {
			if (usuario.getPassword().equals(datos.getClave())) {
				// CREDENCIALES CORRECTAS
				salida = mapa_navegacion.findForward("correcto");
				peticion.getSession().setAttribute("usuario", usuario);
			} else {
				// ERROR EN LA CLAVE
			}
		} else {
			// ERROR EN EL NOMBRE
		}
		return salida;
	}

}
