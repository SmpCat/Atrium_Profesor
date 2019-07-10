package com.atrium.controlador;

import javax.swing.JFrame;

import com.atrium.vista.Formulario;
import javax.swing.JPanel;

/**
 * Ejemplo de creacion de una ventana que llama a un formulario externo, otra
 * vista.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-9-2016.
 * 
 */
public class Ventana extends JFrame {

	public Ventana() {
		// POSICION Y TAMAÑO DE LA VENTANA
		setBounds(100, 100, 400, 350);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
		// LLAMADA AL METODO QUE CREA EL CONTENIDO DE LA VENTANA
		crear_Interface();
		// ACTIVAMOS LA VISIBILIDAD DE LA VENTANA
		setVisible(true);
	}

	/**
	 * Proceso de creacion de los componentes de interface grafica.
	 */
	void crear_Interface() {
		// LLAMADA/CREACION DEL CONTENEDOR DE BAJO NIVEL DEL FORMULARIO
		Formulario formulario = new Formulario();
		// CARGA EN LA VENTANA
		getContentPane().add(formulario);
	}
}
