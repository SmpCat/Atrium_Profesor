package anotaciones.anotadas;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Ejemplo de anotacion para añadir metadatos a los objetos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dulce {
	//DEFINIMOS EL CONTENIDO DE LA ANOTACION
	//SERA COMO EN LAS INTERFACES PROPIEDADES O CONSTANTES, JUNTO CON METODOS ACCESORES   
	public static final int VALOR_POR_DEFECTO = 0;

	int value() default VALOR_POR_DEFECTO;
}