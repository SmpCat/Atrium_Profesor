package com.atrium.controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

/**
 * Ejemplo de definicion de tratamiento de eventos dos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 27-9-2016.
 *
 */
public class Prueba_EventosDos
		implements FocusListener, ItemListener, WindowListener, WindowStateListener, WindowFocusListener {

	// ***** EVENTOS DE FOCO
	/**
	 * Evento de foco. Proceso de ganancia de foco.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void focusGained(FocusEvent evento) {
		// IDENTIFICA SI LA GANANCIA DE FOCO ES PERMANENTE O TEMPORAL
		evento.isTemporary();
	}

	/**
	 * Evento de foco. Proceso de perdida de foco.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void focusLost(FocusEvent evento) {

	}

	// ***** EVENTOS DE SELECCION
	/**
	 * Evento de seleccion/deseleccion de componente. Metodo unico.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */

	@Override
	public void itemStateChanged(ItemEvent evento) {
		// RETORNA UN VALOR NUMERO ENTERO QUE NO INDICA SI SE SELECCIONA O SE
		// DESELECCIONA EL COMPONENTE.
		evento.getStateChange();

	}

	// ***** EVENTOS DE VENTANA
	// *********************** ACTIVACION/DESACTIVACION
	/**
	 * Evento de ventana. Activacion, paso a primer plano.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowActivated(WindowEvent evento) {
		// VENTANA QUE GENERA EL EVENTO
		evento.getWindow();
	}

	/**
	 * Evento de ventana. Desactivacion, paso a segundo plano.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowDeactivated(WindowEvent evento) {
		// LA OTRA VENTANA QUE ES ACTIVADA
		evento.getOppositeWindow();
	}

	// *********************** MINIMIZACION/MAXIMIZACION
	/**
	 * Evento de ventana. Maximizacion de la ventana y apertura en primer plano
	 * de la misma.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowDeiconified(WindowEvent evento) {

	}

	/**
	 * Evento de ventana. Minimizacion de la ventana y paso como icono a la
	 * barra de tareas.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowIconified(WindowEvent evento) {

	}

	// *********************** APERTURA/CIERRE
	/**
	 * Evento de ventana. Creacion y apertura de la ventana por primera vez.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowOpened(WindowEvent evento) {

	}

	/**
	 * Evento de ventana. Intercepcion del proceso de cierre de la ventana,
	 * siendo posible cancelar el cierre.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowClosing(WindowEvent evento) {

	}

	/**
	 * Evento de ventana. Proceso de cierre de ventana.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowClosed(WindowEvent evento) {

	}

	// *********************** ESTADO DE LA VENTANA
	/**
	 * Evento de ventana. Modificacion/conocimeinto del estado de la ventana,
	 * sobretodo de interes en multiples ventanas.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowStateChanged(WindowEvent evento) {
		// NUEVO ESTADO DE LA VENTANA
		evento.getNewState();
		// ESTADO ANTIGUO DE LA VENTANA
		evento.getOldState();

	}

	// *********************** GANANCIA PERDIDA DE FOCO
	/**
	 * Evento de ventana. Ganancia de foco por parte de la ventana.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowGainedFocus(WindowEvent evento) {

	}

	/**
	 * Evento de ventana. Perdida de foco por parte de la ventana.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void windowLostFocus(WindowEvent evento) {
		// LA OTRA VENTANA QUE ES ACTIVADA
		evento.getOppositeWindow();
	}

}
