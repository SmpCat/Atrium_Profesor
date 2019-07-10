package com.atrium.controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import com.atrium.modelo.Municipio;
import com.atrium.modelo.Provincia;
import com.atrium.modelo.fachada.Gestion_Municipios;
import com.atrium.modelo.fachada.Gestion_Provincias;
import com.atrium.modelo.fachada.IGestion_Municipios;
import com.atrium.modelo.fachada.IGestion_Provincias;

/**
 * Controlador/vista del ejemplo. Arreglado el error en reinicio del combo.
 * Codigo actualizado respecto de la clase.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 28-9-2016.
 *
 */
public class Ventana extends JFrame implements ItemListener {
	// COMPONENTES GRAFICOS
	private JLabel eti_municipios;
	private JComboBox combo_municipios;
	private JLabel eti_provincia;
	private JComboBox combo_provincias;

	private List<Provincia> lista_provincia;

	/**
	 * Constructor de la clase.
	 */
	public Ventana() {
		// MODIFICAMOS PROPIEDADES
		setBounds(200, 200, 350, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		// CREAMOS LA INTERFACE GRAFICA
		crear_Interface();
		// HACEMOS VISIBLE LA PANTALLA
		setVisible(true);
	}

	/**
	 * Proceso de creacion de los componentes de interface grafica.
	 */
	public void crear_Interface() {
		eti_provincia = new JLabel("Provincias");
		eti_provincia.setBounds(12, 105, 71, 16);
		getContentPane().add(eti_provincia);
		// OBTENEMOS LA INFORMACION DE LA CAPA MODELO
		IGestion_Provincias gestion_provincias = new Gestion_Provincias();
		lista_provincia = gestion_provincias.consultar_Todas();
		// CARGAMOS LA INFORMACION PARA EL JCOMBOBOX EN UNA TABLA
		String tabla_provincias[] = new String[lista_provincia.size() + 1];
		tabla_provincias[0] = "Seleccione una provincia";
		int posicion = 1;
		for (Provincia provi : lista_provincia) {
			tabla_provincias[posicion] = provi.getProvincia();
			posicion++;
		}
		combo_provincias = new JComboBox(tabla_provincias);
		combo_provincias.setBounds(110, 102, 210, 22);
		// AÑADIMOS TRATAMIENTO DE EVENTO
		combo_provincias.addItemListener(this);
		// ASIGNAMOS VALOR A NAME
		combo_provincias.setName("combo_provincias");
		add(combo_provincias);

		eti_municipios = new JLabel("Municipios");
		eti_municipios.setBounds(12, 173, 71, 16);
		getContentPane().add(eti_municipios);

		// CARGAMOS LA INFORMACION PARA EL JCOMBOBOX EN UNA TABLA
		String tabla_municipios[] = { "Seleccione primero una provincia" };

		combo_municipios = new JComboBox(tabla_municipios);
		combo_municipios.setBounds(110, 170, 210, 22);
		getContentPane().add(combo_municipios);
	}

	/**
	 * Proceso de carga dinamica del combo de municipios segun provincia
	 * seleccionada.
	 */
	public void cargar_Municipios() {
		// CAPTURAMOS LA SELECCION EN COMBO
		int posicion = combo_provincias.getSelectedIndex();
		String tabla_municipios[];
		// SEGUN VALOR SELECCCIONADO SE CARGA/REINICIA EL CONTENIDO DEL COMBO
		if (posicion > 0) {
			// ELIMINAMOS LA DIFERENCIA DE POSICIONES ENTRE LA TABLA Y LA
			// COLECCION
			posicion--;
			// CONSULTAMOS AL MODELO LA INFORMACION DE LOS MUNICIPIO
			Byte codigo_provincia = lista_provincia.get(posicion).getCodigoProvincia();
			IGestion_Municipios gestion_municipios = new Gestion_Municipios();
			List<Municipio> lista_municipios = gestion_municipios.consultar_PorProvincia(codigo_provincia);
			// CARGAMOS LA INFORMACION PARA EL JCOMBOBOX EN UNA TABLA
			tabla_municipios = new String[lista_municipios.size() + 1];
			tabla_municipios[0] = "Seleccione un municipio";
			int posicion_muni = 1;
			for (Municipio muni : lista_municipios) {
				tabla_municipios[posicion_muni] = muni.getMunicipio();
				posicion_muni++;
			}
		} else {
			// REINICIAMOS LA TABLA A VALORES ORIGINALES
			tabla_municipios = new String[1];
			tabla_municipios[0] = "Seleccione primero una provincia";
		}
		// ELIMINAMOS EL JCOMBOBOX ANTERIOR
		getContentPane().remove(combo_municipios);
		// CREAMOS DE NUEVO EL COMBO DE MUNICIPIOS
		combo_municipios = new JComboBox(tabla_municipios);
		combo_municipios.setBounds(110, 170, 210, 22);
		getContentPane().add(combo_municipios);
		// NOTIFICAMOS AL HILO GRAFICO DEL CAMBIO
		validate();
		// REPINTAMOS LA VENTANA
		repaint();
	}

	/**
	 * Tratamiento de el evento de seleccion en los combos.
	 */
	@Override
	public void itemStateChanged(ItemEvent evento) {
		String combo_pulsado = ((JComboBox) evento.getSource()).getName();
		if (combo_pulsado.equals("combo_provincias")) {
			// CARGA DE MUNICIPIOS
			cargar_Municipios();
		}
	}
}
