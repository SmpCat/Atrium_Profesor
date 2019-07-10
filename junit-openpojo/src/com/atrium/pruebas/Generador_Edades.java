package com.atrium.pruebas;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import com.atrium.clases.Edad_Usuario;
import com.openpojo.random.RandomGenerator;

/**
 * Utilidad para la generacion de valores aleatorios para su suo en las pruebas.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 31-3-2017.
 *
 */
public class Generador_Edades implements RandomGenerator {
	// PROPIEDADES PARA LA IMPLEMNTACION DEL PROCESO ALEATORIO
	private static final Class<?>[] TYPES = new Class<?>[] { Edad_Usuario.class };
	private static final Random RANDOM = new Random(System.currentTimeMillis());

	// ESTABLECEMOS UN LIMITE DE EDAD
	private static final int MAX_AGE = 130;

	/**
	 * Metodo llamado para obtener el valor aleatorio.
	 */
	@Override
	public Object doGenerate(Class<?> type) {
		return new Edad_Usuario(RANDOM.nextInt(MAX_AGE));
	}

	/**
	 * Metodo llamado para la comprobacion de tipo.
	 */
	@Override
	public Collection<Class<?>> getTypes() {
		return Arrays.asList(TYPES);
	}

}