package com.atrium.controlador;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Programa ejemplo de interface grafica.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 11-7-2017.
 *
 */
public class Inicio {

	/**
	 * Arranque de programa.
	 * 
	 * @param args
	 *            Argumentos de la consola.
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
		Ventana ventana = new Ventana();
	}

}
