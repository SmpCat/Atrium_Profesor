package com.atrium.controlador;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;

/**
 * Ejemplo de sintaxis de componentes de swing.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 3-10-2016.
 *
 */
public class Ejemplo_SintaxisComponentes {

	// ********** COMPONENTES DE TEXTO
	private JTextField campo_textobasico;
	private JFormattedTextField campo_textoformato;
	private JPasswordField campo_textocontenidooculto;

	private JTextArea area_textosplano;

	private JEditorPane area_textovariosformatos;
	private JTextPane area_textovariosformatos2;
	// ********** ETIQUETA DE TEXTO
	private JLabel etiqueta_texto;
	// ********** COMPONENTES DE SELECCION
	private JButton boton;
	private JToggleButton boton_pulsable;
	private JRadioButton selector_radio;
	private JCheckBox selector_casilla;
	private JComboBox<String> selector_combo;
	private JList<String> selector_lista;

	private ButtonGroup agrupacion_selectores;
	// ********** COMPONENTES DE MENU
	private JMenu menu_primernivel;
	private JMenuItem menu_seleccionableusuario;
	private JRadioButtonMenuItem menu_seleccionableradio;
	private JCheckBoxMenuItem menu_seleccionablechekbox;
	// ********** SELECTORES ESPECIALES
	private JColorChooser selector_color;
	private JFileChooser selector_archivos;

	// ********** COMPONENTES COMPLEJOS
	private JTable componente_tabla;
	private JTree componente_arbol;

	public void componentes_Swing() {
		// CAMPOS DE UNA SOLO LINEA
		campo_textobasico = new JTextField();
		campo_textoformato = new JFormattedTextField();
		campo_textocontenidooculto = new JPasswordField();
		// TAMAÑO PARA LAS AREAS DE TEXTO
		int filas = 10;
		int columnas = 25;
		// AREAS DE TEXTO
		area_textosplano = new JTextArea(filas, columnas);

		area_textovariosformatos = new JEditorPane();
		// ETIQUETA SIMPLE
		etiqueta_texto = new JLabel("Primera etiqueta");
		// SELECTORES
		boton = new JButton("Soy un boton");

		selector_radio = new JRadioButton("Soy un radiobuton");
		JRadioButton otro_selectorradio = new JRadioButton("Soy otro radiobutton");
		// AGRUPAMIENTO DE SELECTORES
		// CREACION DEL CONTROL DE GRUPO
		agrupacion_selectores = new ButtonGroup();
		// SE AÑADE SELECTORES AL GRUPO
		agrupacion_selectores.add(selector_radio);
		agrupacion_selectores.add(otro_selectorradio);
		// CREACION COMPONENTES DEL MENU
		menu_primernivel = new JMenu("Soy el primer nivel");
		menu_seleccionableusuario = new JMenuItem("Soy el segundo nivel");
		// SE MONTAN LOS COMPONENTES
		menu_primernivel.add(menu_seleccionableusuario);

		// CREACION DEL SELECTOR DE FICHEROS
		selector_archivos = new JFileChooser();
		// APERTURA PARA ABRIR/GUARDAR ARCHIVOS -- COMENTADA POR FALTA DE
		// CONTENEDORES
		// selector_archivos.showOpenDialog(this);
		// selector_archivos.showSaveDialog(this);

		// CREACION DEL COMPONENTE JTABLE -- VACIO SIN INFORMACION Y CON EL
		// MODELO BASICO POR DEFECTO
		componente_tabla = new JTable();

		// METODOS -- PROPIEDADES COMUNES A PODER MODIFICAR
		// TIPO DE LETRA
		etiqueta_texto.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
		// IMAGEN A MOSTRAR DENTRO DEL COMPONENTE
		etiqueta_texto.setIcon(new ImageIcon("ruta nombre imagen"));
		// COLOR DE FONDO DEL COMPONENTE
		etiqueta_texto.setBackground(Color.DARK_GRAY);
		// COLOR DE FRENTE -- TEXTO CONTENIDO EN EL COMPONENTE
		etiqueta_texto.setForeground(Color.RED);
		// TEXTO DE AYUDA CONTEXTUAL -- AL PONER EL CURSO SOBRE EL COMPONENTE
		etiqueta_texto.setToolTipText("texto de ayuda");
		// BORDE QUE RODEA AL COMPONENTE
		etiqueta_texto.setBorder(new TitledBorder("Texto titulo"));
		//POSICION TAMAÑO DEL COMPONENTE
		int x = 10;
		int y = 10;
		int ancho = 100;
		int alto = 100;
		etiqueta_texto.setBounds(x, y, ancho, alto);
		//MUCHOS DE ESTOS METODOS SON VALIDOS TANTO EN CONTENEDORES COMO EN COMPONENTES
	}
}
