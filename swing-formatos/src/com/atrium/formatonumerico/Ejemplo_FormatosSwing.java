package com.atrium.formatonumerico;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 * Ejemplo de sintaxis de objetos para el control de formatos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 30-9-2016.
 *
 */
public class Ejemplo_FormatosSwing {
	// GESTORES DE FORMATOS
	private NumberFormat formato_numerico;
	private DateFormat formato_fecha;
	private SimpleDateFormat formato_fechacompleto;
	private MaskFormatter mascara_personalizada;
	// COMPONENTE DE SWING QUE PERMITE LA GESTION DE FORMATO
	private JFormattedTextField campo_textoconformato;

	public void prueba_ControlFormatos() throws ParseException {
		// OBJETO LOCALE PARA LAS OPCIONES POR DEFECTO
		Locale locale = Locale.getDefault();
		Locale otro_locale = new Locale("en", "GB");

		// OPCIONES DE FORMATOS NUMERICO
		// CONFIGURACION REGIONAL DEL ORDENADOR
		formato_numerico = NumberFormat.getInstance();
		// NUMERICO ENTERO
		formato_numerico = NumberFormat.getIntegerInstance();
		// SIN FORMATO ESPECIFICO
		formato_numerico = NumberFormat.getNumberInstance();
		// FORMATO MONETARIO
		formato_numerico = NumberFormat.getCurrencyInstance();
		// FORMATO PORCENTAJE
		formato_numerico = NumberFormat.getPercentInstance();
		// AJUSTES DE PROPIEDADES DEL FORMATO NUMERICO
		formato_numerico.setMaximumIntegerDigits(4);
		formato_numerico.setMinimumIntegerDigits(3);
		formato_numerico.setMaximumFractionDigits(2);
		formato_numerico.setMinimumFractionDigits(2);
		// PASO AL COMPONENTE DE SWING
		campo_textoconformato = new JFormattedTextField(formato_numerico);

		// OPCIONES DE FORMATO FECHA/HORA
		// SOLO FECHA
		formato_fecha = DateFormat.getDateInstance();
		// SOLO HORA
		formato_fecha = DateFormat.getTimeInstance();
		// AMBOS FECHA Y HORA
		formato_fecha = DateFormat.getDateInstance();
		// DEFICINICION DE FORMATO MAS COMPLETO PARA FECHA HORA VIA PATRONES DE
		// CARACTERES
		formato_fechacompleto = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss:SSS");

		// PASO AL COMPONENTE DE SWING
		campo_textoconformato = new JFormattedTextField(formato_fecha);
		campo_textoconformato = new JFormattedTextField(formato_fechacompleto);

		// OPCIONES DE MASCARA PROPIA
		mascara_personalizada = new MaskFormatter("########-L");
		// DESACTIVACION DEL PERMISO DE CARACTERES INVALIDOS
		mascara_personalizada.setAllowsInvalid(false);
		// CARACTER GUIA EN LA ESCRITURA
		mascara_personalizada.setPlaceholder("_");

		// PASO AL COMPONENTE DE SWING
		campo_textoconformato = new JFormattedTextField(mascara_personalizada);

		// USO DE CONVERSIONES DE TEXTO A OBJETO Y VICEVERSA SI SE CUMPLE EL
		// FORMATO -- NORMALMENTE DE USO FUERA DE SWING
		formato_fecha.parse("");
		formato_fecha.format(new Date());

		formato_numerico.parse("");
		formato_numerico.format(2525);

	}

}
