package com.atrium.controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Ejemplo basico de creacion de un formulario de datos con swing.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 29-9-2016.
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
		// CARGAR EL NUEVO LOOK AND FEEL SI SE PUEDE
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Nimbus")) {
				// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
				// USADA
				try {
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
					System.out.println("Cargando nimbus......");
				} catch (Exception e) {
					System.out.println("error en la carga de nimbus");
				}
			}
		}
		// CREACION DEL CONTROLADOR DELEGADO
		Ventana ventana = new Ventana();
	}

}
