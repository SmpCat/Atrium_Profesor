package com.atrium.controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * Ejemplo de creacion de menu en una ventana.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 22-3-2016.
 * 
 */
public class Ventana extends JFrame implements ActionListener {
	// PROPIEDADES PARA EL MENU
	private JMenuBar barra_menu;

	private JMenu opcion1;
	private JMenu opcion2;
	private JMenu opcion3;

	private JMenuItem opcion11;
	private JMenuItem opcion12;
	private JMenuItem opcion13;
	private JMenuItem opcion21;
	private JMenuItem opcion22;
	private JMenuItem opcion31;
	private JMenuItem opcion32;

	// PROPIEDADES PARA EL SUBMENU
	private JMenu submenu;
	private JMenuItem submenu1;
	private JMenuItem submenu2;

	/**
	 * Constructor de la clase.
	 */
	public Ventana() {
		// POSICION Y TAMAÑO DE LA VENTANA
		setBounds(100, 100, 300, 300);
		// ACTIVAMOS EL CIERRE DEL PROGRAMA AL CERRAR LA VENTANA PRINCIPAL Y
		// UNICA
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// LLAMADA AL METODO QUE CREA EL CONTENIDO DE LA VENTANA
		crear_Interface();
		// ACTIVAMOS LA VISIBILIDAD DE LA VENTANA
		setVisible(true);
	}

	/**
	 * Proceso de creacion de los componentes de interface grafica.
	 */
	public void crear_Interface() {
		// CONTENEDOR DEL MENU
		barra_menu = new JMenuBar();
		// CREAMOS LAS OPCIONES DE LA BARRA DE MENU
		opcion1 = new JMenu("Archivo");
		opcion2 = new JMenu("Clientes");
		opcion3 = new JMenu("Ayuda");
		// CREAMOS EL CONTENIDO DE LAS OPCIONES DEL MENU
		opcion11 = new JMenuItem("Abrir");
		opcion12 = new JMenuItem("Cerrar");
		opcion13 = new JMenuItem("Salir");
		opcion21 = new JMenuItem("Gestion");
		opcion22 = new JMenuItem("Facturar");
		opcion31 = new JMenuItem("Ayuda");
		opcion32 = new JMenuItem("Acerca de...");
		// CREAMOS EL SUBMENU
		submenu = new JMenu("submenu");
		submenu1 = new JMenuItem("opcion 1 submenu");
		submenu2 = new JMenuItem("opcion 2 submenu");
		// PONEMOS EL CONTENEDOR DEL MENU EN LA VENTANA
		setJMenuBar(barra_menu);
		// AÑADIMOS LAS OPCIONES DEL MENU AL CONTENEDOR
		barra_menu.add(opcion1);
		barra_menu.add(opcion2);
		barra_menu.add(opcion3);
		// PONEMOS EL CONTENIDO DE CADA OPCION DE MENU
		opcion1.add(opcion11);
		opcion1.add(opcion12);
		opcion1.add(opcion13);
		opcion2.add(opcion21);
		opcion2.add(opcion22);
		opcion3.add(opcion31);
		opcion3.add(opcion32);
		// MONTAMOS EL SUBMENU DENTRO DEL MENU DE AYUDA
		opcion3.addSeparator();
		opcion3.add(submenu);
		submenu.add(submenu1);
		submenu.add(submenu2);

		// ASOCIAMOS EL ESCUCHADOR DE EVENTOS CON EL COMPONENTE
		opcion11.addActionListener(this);
		opcion12.addActionListener(this);
		opcion13.addActionListener(this);
		opcion21.addActionListener(this);
		opcion22.addActionListener(this);
		opcion31.addActionListener(this);
		opcion32.addActionListener(this);
		// ASOCIAMOS TAMBIEN EL SUBMENU AL MISMO RECEPTOR
		submenu1.addActionListener(this);
		submenu2.addActionListener(this);

		// DAMOS VALOR A LA PROPIEDAD NAME PARA IDENTIFICAR LOS OBJETOS EN EL
		// EVENTO
		opcion11.setName("opcion11");
		opcion12.setName("opcion12");
		opcion13.setName("opcion13");
		opcion21.setName("opcion21");
		opcion22.setName("opcion22");
		opcion31.setName("opcion31");
		opcion32.setName("opcion32");
		// TRATAMIENTO DEL SUBMENU
		submenu1.setName("submenu1");
		submenu2.setName("submenu2");

		// AÑADIMOS A LA OPCION SALIR UN ACELERADOR DE TECLADO
		opcion13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK + InputEvent.ALT_MASK));

		// ICONO PROPIO DEL PROGRAMA
		opcion11.setIcon(new ImageIcon(this.getClass().getResource(
				"/com/atrium/imagenes/abrir.png")));
		// CAMBIO DE FUENTE
		opcion32.setFont(new Font("Times New Roman", Font.BOLD, 20));
		// CAMBIO DE COLOR
		opcion32.setForeground(Color.MAGENTA);
	}

	/**
	 * Tratamiento del evento de los jmenuitem.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String opcion_seleccionada = ((JComponent) evento.getSource())
				.getName();
		// LOGICA PARA DETERMINAR EL JMENUITEM SELECCIONADO
		if (opcion_seleccionada.equals("opcion11")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion12")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion13")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion21")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion22")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion31")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("opcion32")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("submenu1")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
		if (opcion_seleccionada.equals("submenu2")) {
			System.out.println("Soy la opcion ... " + opcion_seleccionada);
		}
	}

}
