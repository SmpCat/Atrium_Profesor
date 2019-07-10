package com.atrium.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 * Managedbean para el soporte del ejemplo de los menus.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 4-5-2017.
 * 
 */
@ManagedBean(name = "prueba_menu")
@ViewScoped
public class Menus_Bean implements Serializable {

	// ************ EVENTO ACE:MENUITEM
	/**
	 * Evento producido por el usuario al seleccionar un menuitem de cualquier
	 * menu.
	 * 
	 * @param evento
	 *            {@link ActionEvent}
	 */
	public void evento_Menu(ActionEvent evento) {
		String opcion_seleccionada = evento.getComponent().getId();
		System.out.println("LA OPCION PULSADA ES ... " + opcion_seleccionada);
	}

}
