package com.atrium.controlador;

import javax.swing.JFrame;

import com.atrium.editor.Editor;

/**
 * Ejemplo de creacion de un componente porpio para swing. Un editor de texto
 * plano.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 30-9-2016.
 *
 */
public class Inicio {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CREACION DEL COMPONENTE
		Editor editor = new Editor(480, 450);
		// MODIFICACION DE PARAMETRO PARA SU CONFIGURACION
		editor.setActivar_menu(true);
		// CREACION DEL CONTENEDOR DE ALTO NIVEL PARA SU PRUEBA EN EL ENTORNO
		// GRAFICO
		JFrame ventana = new JFrame();
		ventana.setBounds(100, 100, 500, 500);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// AÑADIMOS COMPONENTE AL CONTENEDOR
		ventana.add(editor);
		// HACEMOS VISIBLE LA VENTANA
		ventana.setVisible(true);
	}

}
