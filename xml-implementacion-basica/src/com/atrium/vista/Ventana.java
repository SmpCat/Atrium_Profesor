package com.atrium.vista;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.atrium.XML.Tratar_XML;

/**
 * Interface grafica basica para el ejemplo.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.1.
 * @since 7-10-2016.
 * 
 */
public class Ventana extends JFrame {
	// COMPONENTE A TRATAR
	private JComboBox comboBox;

	/**
	 * Constructor del contenedor principal.
	 */
	public Ventana() {
		// AJUSTES DE LA VENTANA
		getContentPane().setLayout(null);
		this.setBounds(0, 0, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// LLAMADA AL OBJETO QUE LEE EL FICHRO
		Tratar_XML txml = new Tratar_XML();
		txml.setNombre_XML("src/coches.xml");
		txml.leer_Coches_XML();
		// CARGA DEL COMPONENTE CON LA INFORMACION LEIDA
		comboBox = new JComboBox(txml.getEv().getTabla());
		comboBox.setBounds(143, 143, 97, 25);
		getContentPane().add(comboBox);

		this.setVisible(true);
	}

}
