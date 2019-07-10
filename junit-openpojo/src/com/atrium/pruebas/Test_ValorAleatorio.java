package com.atrium.pruebas;

import org.junit.BeforeClass;

import com.openpojo.random.RandomFactory;

/**
 * Ejemplo de uso de generacion de valores aletorios. (SOLO USO DOCUMENTAL)
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 31-3-2017.
 *
 */
public class Test_ValorAleatorio {
	@BeforeClass
	public static void onlyOnce() {
		RandomFactory.addRandomGenerator(new Generador_Edades());
	}

	/// RESTO DE METODOS PARA LA PRUEBA

}