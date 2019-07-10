package com.atrium.controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Ejemplo de uso de properties como recurso idiomatico y si tratamiento como tal.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 28-9-2016.
 *
 */
public class Inicio {

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		// CARGAR EL LOOK DE NIMBUS SI LA VERSION DE JDK LO PERMITE
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Nimbus")) {
				try {
					// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
					// USADA
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
				} catch (Exception ex) {
				}
			}
		}
		//CREACION DEL CONTROLADOR
		Ventana ventana = new Ventana();
	}

}
