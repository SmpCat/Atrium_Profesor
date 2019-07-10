package com.atrium.object;

/**
 * Ejemplo de uso de los metodos sobrecargados de una clase propia.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0
 * @since 24-10-2016.
 */
public class Inicio {
	// PROPIEDADES DE CLASE
	private Gestion_Object modelo1;
	private Gestion_Object modelo2;

	/**
	 * Arranque del programa.
	 * 
	 * @param args
	 *            Argumentos pasados via consola.
	 */
	public static void main(String[] args) {
		Inicio prueba = new Inicio();
		prueba.prueba_Equals();
	}

	/**
	 * Proceso de uso de los metodos sobrecargados.
	 */
	public void prueba_Equals() {
		// CREACION DE LOS OBJETOS
		modelo1 = new Gestion_Object();
		modelo2 = new Gestion_Object();
		// PASO DE VALORES
		modelo1.setOpe1(1);
		modelo2.setOpe1(1);
		// COMPARACION DEL ESTADO DE LOS OBJETOS
		if (modelo1.equals(modelo2)) {
			System.out.println("Los objetos modelo son iguales");
		}
		// PASO DE VALORES
		modelo2.setOpe2(2);
		// COMPARACION DEL ESTADO DE LOS OBJETOS
		if (modelo1.equals(modelo2)) {
			System.out.println("Los objetos modelo son iguales");
		} else {
			System.out.println("Los objetos modelo ya no son iguales");
		}
		// USO DEL TOSTRING
		System.out.println(modelo1.toString());
	}

}
