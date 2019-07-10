package com.atrium.colecciones;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Ejemplo de uso de coleccion. Este ejemplo esta montado dentro de una
 * interface grafica.<br/>
 * Para entender el funcionamiento de la parte grafica es necesario el visionado
 * de las clases de swing.<br/>
 * el funcionamiento de las colecciones es independiente del entorno grafico que
 * se use.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 23-9-2016.
 *
 */
public class Inicio {

	/**
	 * Ejemplo de metodo de arranque de programa
	 * 
	 * @param args
	 *            Parametros de la consola del operativo.
	 */
	public static void main(String[] args) {
		// CARGAR EL NUEVO LOOK AND FEEL NIMBUR SI SE PUEDE EN FUNCION DE LA
		// VERSION DE JDK
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Nimbus")) {
				try {
					// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
					// USADA
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
					System.out.println("Cargando nimbus......");
				} catch (Exception ex) {
					System.out.println("error en la carga de nimbus");
				}
			}
		}
		// INICIO DE LA INTERFACE GRAFICA
		Ventana ventana = new Ventana();
	}

}
