package com.atrium.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Controlador/vista del ejemplo
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class Ventana extends JFrame implements ActionListener {

	private JLabel etiqueta;

	/**
	 * Constructor de la clase.
	 */
	public Ventana() {
		// POSICION Y TAMAÑO DE LA VENTANA
		setBounds(100, 100, 300, 450);
		// TITULO DE LA VENTANA
		setTitle("Primera ventana");
		// IMPEDIMOS EL CAMBIO DE DE TAMAÑO
		setResizable(false);
		// MATAMOS EL PROGRAMA AL CERRAR LA VENTANA
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ANULAMOS EL GESTOR DE CONTENIDOS (BORDERLAYOUT)
		// POSICIONAMIENTO MANUAL
		setLayout(null);
		// LLAMADA A LA CONSTRUCCION DEL CONTENIDO
		crear_Interface();
		// HACER VISIBLE LA VENTANA Y SU CONTENIDO
		setVisible(true);
	}

	/**
	 * Proceso de creacion de los componentes de interface grafica.
	 */
	public void crear_Interface() {
		// CREACION DEL COMPONENTE
		etiqueta = new JLabel("Etiqueta de prueba");
		etiqueta.setBackground(Color.PINK);
		etiqueta.setForeground(new Color(100, 135, 189));
		etiqueta.setFont(new Font("TimesNewRoman", Font.BOLD + Font.ITALIC, 15));
		etiqueta.setBounds(25, 150, 200, 20);
		etiqueta.setOpaque(true);
		// AÑADIR COMPONENTE AL CONTENEDOR
		add(etiqueta);
		// CREACION DEL COMPONENTE
		JButton boton = new JButton("Boton de prueba");
		boton.setBounds(50, 200, 180, 20);
		add(boton);
		//ASOCIACION DE EMISOR (BOTON) CON RECEPTOR (VENTANA)
		boton.addActionListener(this);
	}

	/**
	 * Tratamiento de eventos de boton.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		etiqueta.setText("Texto cambiado");
	}
}
