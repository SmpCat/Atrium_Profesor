
package com.atrium.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso de AOP en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-11-2016.
 *
 */
public class Inicio {

	/**
	 * Arranque del ejemplo.
	 */
    public static void main(String[] args) {
        ApplicationContext contenedor =
                new ClassPathXmlApplicationContext("com/atrium/aop/springconfig.xml");

        Negocio negocio = contenedor.getBean("aplicacion", Negocio.class);
        negocio.HazAlgo("Pepito", 34, "Yo soy asi");
        negocio.HazAlgo("Manolito", 43);
        negocio.HazAlgo("Rosendo", "Maneras de vivir");
        negocio.HazAlgo();
       
    }
}
