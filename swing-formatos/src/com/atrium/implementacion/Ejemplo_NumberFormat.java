package com.atrium.implementacion;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import java.text.*;

/**
 * Ejemplo de uso de numberformat con jformattedtextfield.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 3-10-2016.
 *
 */
public class Ejemplo_NumberFormat extends JPanel implements PropertyChangeListener {
	// PROPIEDADES DE CLASE
	// VARIABLES DE TRABAJO
	private double capital_hipoteca = 100000;
	private double interes = 7.5; // 7.5%
	private int numero_pagos = 30;
	// ETIQUETAS PARA LOS CAMPOS DE LA INTERFACE
	private JLabel etiqueta_capitalhipoteca;
	private JLabel etiqueta_interes;
	private JLabel etiqueta_numeropagos;
	private JLabel etiqueta_pagomensual;
	// TEXTOS PARA LAS ETIQUETAS
	private static String texto_capitalhipoteca = "Capital : ";
	private static String texto_interes = "Tasa (%): ";
	private static String texto_numeropagos = "Años: ";
	private static String texto_pagomensual = "Pago Mensual: ";
	// CAMPOS PARA LA ENTRADA DE DATOS
	private JFormattedTextField campo_capitalhipoteca;
	private JFormattedTextField campo_interes;
	private JFormattedTextField campo_numeropagos;
	private JFormattedTextField campo_pagomensual;
	// FORMATOS PARA LOS VALORES NUMERICOS
	private NumberFormat formato_capitalhipoteca;
	private NumberFormat formato_interes;
	private NumberFormat formato_pagomensual;
	// PANELES INTERNOS DE LA INTERFACE
	private JPanel panel_etiquetas;
	private JPanel panel_campos;

	/**
	 * Constructor de clase.
	 */
	public Ejemplo_NumberFormat() {
		super(new BorderLayout());
		crear_Formatos();
	}

	/**
	 * Creacion del contenido del la interface
	 */
	public void crear_Interface() {
		// CALCULO DEL PAGO MENSUAL DE LA HIPOTECA SEGUN LOS DATOS POR DEFECTO.
		double pago_inicial = calcular_Pagos(capital_hipoteca, interes, numero_pagos);
		// CREAMOS LAS ETIQUETAS
		etiqueta_capitalhipoteca = new JLabel(texto_capitalhipoteca);
		etiqueta_interes = new JLabel(texto_interes);
		etiqueta_numeropagos = new JLabel(texto_numeropagos);
		etiqueta_pagomensual = new JLabel(texto_pagomensual);
		// CREAMOS LOS CAMPOS PARA INTRODUCIR LOS VALORES
		campo_capitalhipoteca = new JFormattedTextField(formato_capitalhipoteca);
		campo_capitalhipoteca.setValue(new Double(capital_hipoteca));
		campo_capitalhipoteca.setColumns(10);
		campo_capitalhipoteca.addPropertyChangeListener("value", this);

		campo_interes = new JFormattedTextField(formato_interes);
		campo_interes.setValue(new Double(interes));
		campo_interes.setColumns(10);
		campo_interes.addPropertyChangeListener("value", this);

		campo_numeropagos = new JFormattedTextField();
		campo_numeropagos.setValue(new Integer(numero_pagos));
		campo_numeropagos.setColumns(10);
		campo_numeropagos.addPropertyChangeListener("value", this);

		campo_pagomensual = new JFormattedTextField(formato_pagomensual);
		campo_pagomensual.setValue(new Double(pago_inicial));
		campo_pagomensual.setColumns(10);
		campo_pagomensual.setEditable(false);
		campo_pagomensual.setForeground(Color.red);

		// CARGAMOS LOS TEXTOS EN LAS ETIQUETAS
		etiqueta_capitalhipoteca.setLabelFor(campo_capitalhipoteca);
		etiqueta_interes.setLabelFor(campo_interes);
		etiqueta_numeropagos.setLabelFor(campo_numeropagos);
		etiqueta_pagomensual.setLabelFor(campo_pagomensual);

		// COLOCAMOS LAS ETIQUETAS EN EL PANEL
		panel_etiquetas = new JPanel(new GridLayout(0, 1));
		panel_etiquetas.add(etiqueta_capitalhipoteca);
		panel_etiquetas.add(etiqueta_interes);
		panel_etiquetas.add(etiqueta_numeropagos);
		panel_etiquetas.add(etiqueta_pagomensual);

		// COLOCAMOS LOS CAMPOS DE TEXTO EN OTRO PANEL
		panel_campos = new JPanel(new GridLayout(0, 1));
		panel_campos.add(campo_capitalhipoteca);
		panel_campos.add(campo_interes);
		panel_campos.add(campo_numeropagos);
		panel_campos.add(campo_pagomensual);

	}

	/**
	 * Evento de cambio de valor.
	 * 
	 * @param PropertyChangeEvent
	 *            Evento producido.
	 */
	public void propertyChange(PropertyChangeEvent evento) {
		Object objeto = evento.getSource();
		if (objeto == campo_capitalhipoteca) {
			capital_hipoteca = ((Number) campo_capitalhipoteca.getValue()).doubleValue();
		} else if (objeto == campo_interes) {
			interes = ((Number) campo_interes.getValue()).doubleValue();
		} else if (objeto == campo_numeropagos) {
			numero_pagos = ((Number) campo_numeropagos.getValue()).intValue();
		}
		double pago = calcular_Pagos(capital_hipoteca, interes, numero_pagos);
		campo_pagomensual.setValue(new Double(pago));
	}

	/**
	 * Creacion de la ventana pricipal y carga del contenido del ejemplo dentro.
	 */
	private void crear_MostrarVentana() {
		// CREACION DE LA VENTANA
		JFrame ventana = new JFrame("FormattedTextFieldDemo");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// COLOCAMOS LOS PANELES DE ETIQUETAS Y CAMPOS EN EL PANEL PRINCIPAL
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(panel_etiquetas, BorderLayout.CENTER);
		add(panel_campos, BorderLayout.LINE_END);
		// AÑADIMOS CONTENIDO
		ventana.add(this);
		// MOSTRAMOS VENTANA
		ventana.pack();
		ventana.setVisible(true);
	}

	/**
	 * Arranque del ejemplo.
	 * 
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// CREAMOS OBJETO
				Ejemplo_NumberFormat ejemplo = new Ejemplo_NumberFormat();
				// PREPARAMOS Y CARGAMOS INTERFACE
				ejemplo.crear_Interface();
				ejemplo.crear_MostrarVentana();
			}
		});
	}

	/**
	 * Proceso de calculo de la mensualidad a pagar.
	 * 
	 * @param capital_hipotecario
	 *            double
	 * @param interes_hipoteca
	 *            double
	 * @param años_apagar
	 *            int
	 * 
	 * @return double
	 */
	public double calcular_Pagos(double capital_hipotecario, double interes_hipoteca, int años_apagar) {
		double I, partial1, denominator, mensualidad;
		años_apagar *= 12; // CALCULAR LOS MESES A PARTIR DE LOS AÑOS
		if (interes_hipoteca > 0.01) {
			// CALCULAR EL INTERES MENSUAL A PARTIR DEL ANUAL
			I = interes_hipoteca / 100.0 / 12.0;
			partial1 = Math.pow((1 + I), (0.0 - años_apagar));
			denominator = (1 - partial1) / I;
		} else { // rate ~= 0
			denominator = años_apagar;
		}
		mensualidad = (-1 * capital_hipotecario) / denominator;
		return mensualidad;
	}

	/**
	 * Creacion de los formatos.
	 */
	private void crear_Formatos() {
		formato_capitalhipoteca = NumberFormat.getNumberInstance();

		formato_interes = NumberFormat.getNumberInstance();
		formato_interes.setMinimumFractionDigits(3);

		formato_pagomensual = NumberFormat.getCurrencyInstance();
	}
}
