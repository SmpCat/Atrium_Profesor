package com.atrium.controlador;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

/**
 * Ejemplo de sintaxis de contenedores de swing.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 3-10-2016.
 *
 */
public class Ejemplo_SintaxisContenedores {
	// ********** CONTENEDORES DE ALTO NIVEL
	// CONTENEDOR PRINCIPAL
	private JFrame ventana;
	// CONTENEDORES AUXILIARES
	private JOptionPane ventana_auxiliarseleccion;
	private JDialog ventana_modal;
	// ********** CONTENEDORES DE BAJO NIVEL
	// CONTENEDOR BASICO
	private JPanel panel_basico;
	// CONTENDORES ESPECIALIZADOS
	// MENUS
	private JMenuBar contenedor_menu;
	private JPopupMenu contenedor_menucontextual;
	// BARRA HERAMIENTAS
	private JToolBar contenedor_barraherramientas;
	// BARRA SCROLL
	private JScrollPane contenedor_conscroll;
	// CONTENEDOR MULTIPLE DE PESTAÑAS
	private JTabbedPane contenedor_pestañas;

	public void contenedores_Swing() {
		// VENTANA PRINCIPAL
		ventana = new JFrame();
		// VENTANAS SECUNDARIAS REFERIDAS A UNA VENTANA PRINCIPAL
		ventana_auxiliarseleccion = new JOptionPane(ventana);
		ventana_modal = new JDialog(ventana, true);
		// PANEL BASICO GENERICO PARA TODO TIPO DE CONTENIDOS
		panel_basico = new JPanel();
		// CONTENEDORES PARA MENUS -- NO SE INDICA TAMAÑO O POSICION
		contenedor_menu = new JMenuBar();
		contenedor_menucontextual = new JPopupMenu();

		// CONTENEDOR PARA BARRA DE HERAMIENTAS
		contenedor_barraherramientas = new JToolBar();
		// CONTENEDOR PARA ACCIONES DE SCROLL -- HORIZONTAL Y VERTICAL
		contenedor_conscroll = new JScrollPane();
		// CONTENEDOR DE PESTAÑAS
		contenedor_pestañas = new JTabbedPane();

		// METODOS COMUNES PARA CASI TODOS LOS CONTENEDORES
		int x = 10;
		int y = 10;
		int ancho = 100;
		int alto = 100;
		// POSICION Y TAÑANO DEL CONTENEDOR
		ventana.setBounds(x, y, ancho, alto);
		// GESTOR DE CONTENIDO INTERNO -- PARA CAMBIARLO O ANULARLO
		panel_basico.setLayout(null);
		// AÑADIR CONTENIDO DENTRO DEL CONTENEDOR
		panel_basico.add(contenedor_conscroll);
		// EXCEPCION A LA REGLA GENERAL PARA AÑADIR CONTENIDO -- SUELEN SER
		// OTROS CONTENEDORES
		contenedor_pestañas.addTab("Texto pestaña", panel_basico);
		
		//MUCHOS DE ESTOS METODOS SON VALIDOS TANTO EN CONTENEDORES COMO EN COMPONENTES
		
	}

}
