package com.atrium.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JButton;

import com.atrium.modelo.Datos_DTO;
import com.atrium.modelo.Gestion_Datos;
import com.atrium.modelo.IGestion_Datos;
import java.awt.Font;

/**
 * Vista del ejemplo. Formulario simple y funcional.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-9-2016.
 *
 */
public class Formulario extends JPanel implements ActionListener {
	// COMPONENTES GRAFICOS
	private JLabel eti_nombre;
	// COMPONENTE DE TEXTO
	private JTextField nombre_usuario;
	private JLabel eti_apellido;
	private JTextField apellido_usuario;
	private JLabel eti_direccion;
	private JTextField direccion;
	private JLabel eti_ciudad;
	private JTextField ciudad;
	// CONTENEDOR/BARRA DE HERAMIENTAS
	private JToolBar barra_botones;
	private JButton boton_leer;
	private JButton boton_escribir;
	private JButton boton_salir;
	private JLabel resultado;

	/**
	 * Constructor de la clase
	 */
	public Formulario() {
		// PROPIEDADES DEL CONTENEDOR
		setLayout(null);
		setBounds(0, 0, 394, 278);
		// LLAMADA A LA CREACION DE LOS COMPONENTES DEL FORMULARIO
		crear_Interface();
	}

	/**
	 * Proceso de creacion de los componentes de interface grafica.
	 */
	public void crear_Interface() {
		// CREACION Y ADAPTACION DE LOS DISTINTOS COMPONENTES DEL FORMULARIO
		eti_nombre = new JLabel("Nombre:");
		eti_nombre.setBounds(26, 61, 64, 14);
		add(eti_nombre);
		// CAMPO DE TEXTO
		nombre_usuario = new JTextField();
		nombre_usuario.setBounds(111, 40, 133, 35);
		add(nombre_usuario);
		
		eti_apellido = new JLabel("Apellido:");
		eti_apellido.setBounds(26, 104, 63, 14);
		add(eti_apellido);

		apellido_usuario = new JTextField();
		apellido_usuario.setBounds(111, 87, 133, 35);
		add(apellido_usuario);
		
		eti_direccion = new JLabel("Direccion:");
		eti_direccion.setBounds(24, 150, 70, 14);
		add(eti_direccion);

		direccion = new JTextField();
		direccion.setBounds(109, 134, 224, 35);
		add(direccion);
		
		eti_ciudad = new JLabel("Ciudad:");
		eti_ciudad.setBounds(26, 194, 68, 14);
		add(eti_ciudad);

		ciudad = new JTextField();
		ciudad.setBounds(111, 179, 224, 35);
		add(ciudad);
		
		// BARRA DE HERRAMIENTAS
		barra_botones = new JToolBar();
		barra_botones.setFloatable(false);
		barra_botones.setBounds(125, 231, 133, 29);
		add(barra_botones);

		boton_leer = new JButton("Leer");
		barra_botones.add(boton_leer);

		boton_escribir = new JButton("Escribir");
		barra_botones.add(boton_escribir);

		boton_salir = new JButton("Salir");
		barra_botones.add(boton_salir);

		// ASOCIAMOS EL ESCUCHADOR DE EVENTOS CON EL COMPONENTE
		boton_escribir.addActionListener(this);
		boton_leer.addActionListener(this);
		boton_salir.addActionListener(this);
		// DAMOS VALOR A LA PROPIEDAD NAME PARA IDENTIFICAR LOS OBJETOS EN EL
		// EVENTO
		boton_escribir.setName("boton_escribir");
		boton_salir.setName("boton_salir");
		boton_leer.setName("boton_leer");

		resultado = new JLabel("");
		resultado.setFont(new Font("Times New Roman", Font.BOLD, 20));
		resultado.setBounds(70, 6, 264, 29);
		add(resultado);

	}

	/**
	 * Proceso independiente de lectura de informacion de la fuente de datos.
	 */
	public void leer_Datos() {
		// CREACION DE LA FACHADA
		IGestion_Datos gestion_datos = new Gestion_Datos();
		// CONSULTA DE INFORMACION
		Datos_DTO datos = gestion_datos.leer_Datos();
		// CARGA DE DATOS EN EL FORMULARIO
		nombre_usuario.setText(datos.getNombre());
		apellido_usuario.setText(datos.getApellido());
		direccion.setText(datos.getCalle());
		ciudad.setText(datos.getCiudad());
	}

	/**
	 * Proceso indepediente de escritura de informacion en la fuente de datos.
	 */
	public void escribir_Datos() {
		// CREACION DEL DTO
		Datos_DTO datos_nuevos = new Datos_DTO();
		// RECOGIDA DE INFORMACION DEL FORMULARIO Y PASO AL DTO
		datos_nuevos.setNombre(nombre_usuario.getText());
		datos_nuevos.setApellido(apellido_usuario.getText());
		datos_nuevos.setCalle(direccion.getText());
		datos_nuevos.setCiudad(ciudad.getText());
		// CREACION DE LA FACHADA
		IGestion_Datos gestion_datos = new Gestion_Datos();
		// LLAMADA AL PROCESO DE ESCRITURA EN LA FUENTE DE DATOS
		boolean valido = gestion_datos.escribir_Datos(datos_nuevos);
		// COMPROBACION DEL RESULTADO DE LA OPERACION DE ESCRITURA
		if (valido) {
			resultado.setText("Actualizacion correcta");
		} else {
			resultado.setText("Error escribiendo");
		}
	}

	/**
	 * Tratamiento del evento de los jmenubutton.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		// OBTENEMOS EL VALOR DE LA PROPIEDAD NAME PARA ESTABLECER LA LOGICA DE
		// TRATAMIENTO
		String boton_seleccion = ((JButton) evento.getSource()).getName();
		// LOGICA PARA DETERMINAR EL JBUTTON SELECCIONADO
		if (boton_seleccion.equals("boton_escribir")) {
			escribir_Datos();
		}
		if (boton_seleccion.equals("boton_leer")) {
			leer_Datos();
		}
		if (boton_seleccion.equals("boton_salir")) {
			System.exit(0);
		}
	}
}
