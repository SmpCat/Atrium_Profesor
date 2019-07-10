package com.atrium.anotaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//PARA SER USADA EN EL JAVADOC
@Documented
// CUANDO USAR LA ANOTACION
@Retention(RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.SOURCE)
@Retention(RetentionPolicy.CLASS)
// OBJETIVO/DONDE USAR LA ANOTACION
@Target(ElementType.TYPE)
@Target(ElementType.TYPE_USE)
@Target(ElementType.TYPE_PARAMETER)
@Target(ElementType.CONSTRUCTOR)
@Target(ElementType.METHOD)
@Target(ElementType.PACKAGE)
@Target(ElementType.PARAMETER)
@Target(ElementType.FIELD)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Prueba_Anotacion {
	// SE PUEDEN DEFINIR CONSTANTES DE CLASE
	public static final String NOMBRE = "";
	public final long NUMERO = 0;

	// SE DEFINEN METODOS QUE ACCEDAN A LOS VALORES DE LAS PROPIEDADES
	String getNombre() default NOMBRE;
	long getNumero() default NUMERO;

}
