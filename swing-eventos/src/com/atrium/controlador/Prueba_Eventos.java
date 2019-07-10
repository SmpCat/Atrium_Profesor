package com.atrium.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;

/**
 * Ejemplo de definicion de tratamiento de eventos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 27-9-2016.
 *
 */
public class Prueba_Eventos implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener {

	// ***** EVENTOS DE ACCION
	/**
	 * Evento de accion. Metodo unico
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		JButton boton = (JButton) evento.getSource();

	}

	// ***** EVENTOS DE RATON
	// ****************************** MOVIMIENTO
	/**
	 * Evento de raton. Proceso de entrada de cursor en el
	 * componente/contenedor.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mouseEntered(MouseEvent evento) {
		// TODO Auto-generated method stub

	}

	/**
	 * Evento de raton. Proceso de salida de cursor en el componente/contenedor.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mouseExited(MouseEvent evento) {
		// TODO Auto-generated method stub

	}

	// ****************************** BOTONES
	/**
	 * Evento de raton. Proceso de pulsacion de boton sobre el
	 * componente/contenedor.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mousePressed(MouseEvent evento) {
		// TODO Auto-generated method stub

	}

	/**
	 * Evento de raton. Proceso de soltar boton pulsado sobre el
	 * componente/contenedor.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mouseReleased(MouseEvent evento) {
		// TODO Auto-generated method stub

	}

	/**
	 * Evento de raton. Proceso completo de pulsacion de boton sobre el
	 * componente/contenedor.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mouseClicked(MouseEvent evento) {
		// POSICION DEL CURSOR EN LA PANTALLA RELATIVO AL COMPONENTE PULSADO
		evento.getY();
		evento.getX();
		// BOTON PULSADO EN EL RATON
		evento.getButton();
		// NUMERO DE VECES QUER SE PULSA EL BOTON
		evento.getClickCount();
	}

	// ******** ARRASTRAR Y SOLTAR
	/**
	 * Evento de movimiento de raton. Se suelta el componente arrastrado.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mouseDragged(MouseEvent evento) {
		// TODO Auto-generated method stub

	}

	/**
	 * Evento de movimiento de raton. Se mueve el componente arrastrado.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mouseMoved(MouseEvent evento) {
		// TODO Auto-generated method stub

	}

	// ************ RUEDA DE RATON
	/**
	 * Evento de movimiento de rueda de raton.
	 * 
	 * @param evento
	 *            Objeto evento producido por el componente/contenedor para ser
	 *            tratado en el metodo.
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent evento) {
		// CANTIDAD DE MOVIMIENTO DE LA RUEDA DEL RATON
		evento.getWheelRotation();
		evento.getPreciseWheelRotation();
		// RELACION ENTRE EL MOVIMIENTO DE LA RUEDA DEL RATON Y LA BARRA DE
		// SCROLL
		evento.getScrollAmount();
		// TIPO DE MOVIMIENTO DE LA BARRA DE SCROLL
		evento.getScrollType();
		// CANTIDA MOVIDA EN LA BARRA DE SCROLL
		evento.getUnitsToScroll();

	}

}
