package com.atrium.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.atrium.util.Imagen;
import com.atrium.util.Obtener_Imagenes;
import java.util.ResourceBundle;

/**
 * Controlador/vista del ejemplo
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class Ventana extends JFrame implements ActionListener {
	// DEFINICION DEL RESOURCEBUNDLE PARA LA LECTURA DEL PROPERTIES
	private ResourceBundle rb = ResourceBundle.getBundle("com.atrium.controlador.textos"); //$NON-NLS-1$

	// PROPIEDADES PARA EL MENU DE VENTANA
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

	private JMenu submenu;
	private JMenuItem submenu1;
	private JMenuItem submenu2;

	/**
	 * Constructor de la clase.
	 */
	public Ventana() {
		// MODIFICAMOS PROPIEDADES
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(rb.getString("Ventana.this.title")); //$NON-NLS-1$
		// CREAMOS LA INTERFACE GRAFICA
		crear_Interface();
		// HACEMOS VISIBLE LA PANTALLA
		setVisible(true);
	}

	/**
	 * Proceso de creacion de los componentes de interface grafica.
	 */
	public void crear_Interface() {
		// ********** MENU DE VENTANA ************
		// CONTENEDOR DEL MENU
		barra_menu = new JMenuBar();
		// POSICIONAMOS LA BARRA DE MENU EN LA VENTANA
		setJMenuBar(barra_menu);
		// CREAMOS LAS OPCIONES DE LA BARRA DE MENU
		opcion1 = new JMenu(rb.getString("Ventana.opcion1.text")); //$NON-NLS-1$
		opcion2 = new JMenu(rb.getString("Ventana.opcion2.text")); //$NON-NLS-1$
		opcion3 = new JMenu(rb.getString("Ventana.opcion3.text")); //$NON-NLS-1$

		// CREAMOS EL CONTENIDO DE LAS OPCIONES DEL MENU
		opcion11 = new JMenuItem(rb.getString("Ventana.opcion11.text")); //$NON-NLS-1$
		opcion12 = new JMenuItem(rb.getString("Ventana.opcion12.text")); //$NON-NLS-1$
		opcion13 = new JMenuItem(rb.getString("Ventana.opcion13.text")); //$NON-NLS-1$
		opcion21 = new JMenuItem(rb.getString("Ventana.opcion21.text")); //$NON-NLS-1$
		opcion22 = new JMenuItem(rb.getString("Ventana.opcion22.text")); //$NON-NLS-1$
		opcion31 = new JMenuItem(rb.getString("Ventana.opcion31.text")); //$NON-NLS-1$
		opcion32 = new JMenuItem(rb.getString("Ventana.opcion32.text")); //$NON-NLS-1$

		// CREAMOS EL SUBMENU
		submenu = new JMenu(rb.getString("Ventana.submenu.text")); //$NON-NLS-1$
		submenu1 = new JMenuItem(rb.getString("Ventana.submenu1.text")); //$NON-NLS-1$
		submenu2 = new JMenuItem(rb.getString("Ventana.submenu2.text")); //$NON-NLS-1$

		// AÑADIMOS LAS OPCIONES DEL MENU AL CONTENEDOR
		barra_menu.add(opcion1);
		barra_menu.add(opcion2);
		barra_menu.add(opcion3);

		// PONEMOS EL CONTENIDO DE CADA OPCION DE MENU
		opcion1.add(opcion11);
		opcion1.add(opcion12);
		opcion1.addSeparator();
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
		opcion13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

		// AÑADIDO ICONOS AL MENU CON GESTION DE TAMAÑO A PARTIR DE UN AUXILIAR
		opcion11.setIcon(Obtener_Imagenes.escalar_Imagen("/com/atrium/iconos/abrir.png", Imagen._32X32));
		opcion13.setIcon(Obtener_Imagenes.escalar_Imagen("/com/atrium/iconos/salir.png", Imagen._32X32));
	}

	/**
	 * Tratamiento de el evento de seleccion en los JMENUITEM
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String opcion_elegida = ((JComponent) evento.getSource()).getName();
		System.out.println("EL USUARIO SELECCIONO LA OPCION ..... " + opcion_elegida);
		if (opcion_elegida.equals("opcion11")) {
			// ACCION A REALIZAR
		}
		if (opcion_elegida.equals("opcion12")) {
			// ACCION A REALIZAR
		}
		if (opcion_elegida.equals("opcion13")) {
			// ACCION A REALIZAR
		}
		if (opcion_elegida.equals("opcion21")) {
			// ACCION A REALIZAR
		}
		if (opcion_elegida.equals("opcion22")) {
			// ACCION A REALIZAR
		}
		if (opcion_elegida.equals("opcion31")) {
			// ACCION A REALIZAR
		}
		if (opcion_elegida.equals("opcion32")) {
			// ACCION A REALIZAR
		}
	}
}
