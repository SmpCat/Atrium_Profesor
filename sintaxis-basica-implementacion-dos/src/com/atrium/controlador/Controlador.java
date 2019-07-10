package com.atrium.controlador;

import com.atrium.modelo.Modelo;
import com.atrium.vista.Vista;

/**
 * Procesos de control de la calculadora via consola.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 27-9-2016.
 * 
 */
public class Controlador {
	// PROPIEDADES DE CLASE
	private Modelo modelo;
	private Vista vista;

	/**
	 * Constructor sin argumentos.
	 */
	public Controlador() {
		// INSTANCIA DE PROPIEDADES DE CLASE
		modelo = new Modelo();
		vista = new Vista();
		// LLAMADA A METODO DE ACCION
		menu_Opciones();
	}

	/**
	 * Proceso de control de flujo en el programa.
	 */
	public void menu_Opciones() {
		// DEFINICION DE VARIABLE PARA EL CONTROL DEL FLUJO DE PROGRAMA
		int opcion = 0;
		this.proceso_Numerico();
		// ESTRUCTURA DE CONTROL DE FLUJO DEL PROGRAMA
		do {
			// SE ENSEÑA EL MENU
			vista.mostrar_Menu();
			// SE PIDE LA OPCION AL USUARIO
			opcion = vista.convertir_Texto(vista.teclear_Texto());
			// EN FUNCION DEL VALOR ELEGIDO SE REALIZA ALGUNA OPCION U OTRA
			switch (opcion) {
			case 1:
				// SUMAR
				modelo.setResultado(modelo.getOpe1() + modelo.getOpe2());
				vista.mostrar_Texto("El resultado de la suma es " + String.valueOf(modelo.getResultado()));
				break;
			case 2:
				// RESTAR
				modelo.setResultado(modelo.getOpe1() - modelo.getOpe2());
				vista.mostrar_Texto("El resultado de la resta es " + String.valueOf(modelo.getResultado()));
				break;
			case 3:
				// MULTIPLICAR
				modelo.setResultado(modelo.getOpe1() * modelo.getOpe2());
				vista.mostrar_Texto("El resultado de la suma es " + String.valueOf(modelo.getResultado()));
				break;
			case 4:
				// DIVIDIR
				modelo.setResultado(modelo.getOpe1() / modelo.getOpe2());
				vista.mostrar_Texto("El resultado de la suma es " + String.valueOf(modelo.getResultado()));
				break;
			case 5:
				// PETICION DE NUEVOS VALORES NUMERICOS
				proceso_Numerico();
				break;
			}
		} while (opcion != 6);
	}

	/**
	 * Proceso de peticion de numeros. Se puede repetir cuantas veces quiera el
	 * usuario.
	 */
	public void proceso_Numerico() {
		// PEDIMOS UN NUMERO
		vista.mostrar_Texto("Teclee un numero");
		// PASAMOS EL NUMERO AL MODELO DESPUES DE PEDIRLO Y TRANSFORMARLO A
		// NUMERO
		modelo.setOpe1(vista.convertir_Texto(vista.teclear_Texto()));
		// PEDIMOS EL SIGUIENTE NUMERO
		vista.mostrar_Texto("Teclee otro numero");
		// PASAMOS EL OTRO NUMERO AL MODELO DESPUES DE PEDIRLO Y TRANSFORMARLO A
		// NUMERO
		modelo.setOpe2(vista.convertir_Texto(vista.teclear_Texto()));
	}
}
