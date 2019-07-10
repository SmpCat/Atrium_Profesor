package anotaciones;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import anotaciones.anotadas.Dulce;
import anotaciones.anotadas.FrutoSeco;

/**
 * Prueba del ejemplo de las anotaciones y su uso.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
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
		// CREACION DEL OBJETO
		BolsitaMarcaA bolsitaMarcaA = new BolsitaMarcaA();
		// LLAMADA AL METODO QUE NOS INTERESA
		int caloriasTotalesA = contarCaloriasTotalesFrutosSecos(bolsitaMarcaA);
		// TRAZA DEL RESULTADO
		System.out.println("Calorias totales de los frutos secos de una bolsita de la marca 'A': " + caloriasTotalesA);

		// CREACION DE OTRO OBJETO
		BolsitaMarcaB bolsitaMarcaB = new BolsitaMarcaB();
		// LLAMADA AL METODO QUE NOS INTERESA
		int caloriasTotalesB = contarCaloriasTotalesFrutosSecos(bolsitaMarcaB);
		// TRAZA DEL RESULTADO
		System.out.println("Calorias totales de los frutos secos de una bolsita de la marca 'B': " + caloriasTotalesB);

		// ACCESO DIRECTO AL VALOR CONSTANTE DE LA ANOTACION
		System.out.println(
				"Valor por defecto dentro de la declaración de la anotación Dulce: " + Dulce.VALOR_POR_DEFECTO);
	}

	/**
	 * Funcion que cuenta las calorías totales de cualquier variable anotadas
	 * con FrutoSeco mediante reflexion.
	 * 
	 * @param bolsita
	 *            objeto de la clase Bolsita del que extraer las calorías de
	 *            únicamente los FrutosSecos
	 * @return cantidad de calorías totales de únicamente los FrutosSecos
	 */
	public static int contarCaloriasTotalesFrutosSecos(final Object bolsita) {
		// OBTENEMOS EL CLASS DEL OBJETO A TRATAR
		Class<?> claseBolsita = bolsita.getClass();
		int caloriasTotales = 0;
		// ACCEDEMOS A LA PROPIEDADES DEL OBJETO, INCLUYE VARIABLES PRIVADAS
		final Field[] variables = claseBolsita.getDeclaredFields();
		// RECORREMOS TODAS LAS PROPIEDADES DEL OBJETO
		for (final Field variable : variables) {
			// ACCEDEMOS A LAS ANOTACIONES DE LA PROPIEDAD
			final Annotation anotacionObtenida = variable.getAnnotation(FrutoSeco.class);
			// COMPROBAMOS EL TIPO
			if (anotacionObtenida != null && anotacionObtenida instanceof FrutoSeco) {
				final FrutoSeco anotacionFrutoSeco = (FrutoSeco) anotacionObtenida;
				// LLAMAMOS AL VALOR DE LA ANNOTACION
				int calorias = anotacionFrutoSeco.calorias();
				int cantidad = 0;
				try {
					// PERMITIMOS EL ACESO A LA PROPIEDAD
					variable.setAccessible(true);
					cantidad = variable.getInt(bolsita);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				// CONOCEMOS EL NOMBRE LA PROPIEDAD
				String nombreFrutoSeco = variable.getName();
				// TRAZAMOS EL VALOR
				System.out.println("	-Hay " + cantidad + " de " + nombreFrutoSeco + ", y cada una tiene " + calorias
						+ " calorías");
				caloriasTotales += (cantidad * calorias);
			}
		}
		return caloriasTotales;
	}
}
