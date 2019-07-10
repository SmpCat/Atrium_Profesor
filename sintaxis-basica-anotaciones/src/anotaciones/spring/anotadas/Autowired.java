package anotaciones.spring.anotadas;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Ejemplo de anotacion para realizar proceso a partir de la anotacion.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {

}