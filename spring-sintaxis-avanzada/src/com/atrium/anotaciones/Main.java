package com.atrium.anotaciones;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ejemplo de uso de anotaciones de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-11-2016.
 *
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	//INICIAMOS SPRING
        ApplicationContext contenedor =
                new ClassPathXmlApplicationContext("com/atrium/anotaciones/spring.xml");
        //RECIBIMOS LA LISTA DE NOMBRES DE LOS BEANS DEFINIDOS
        String nombres []=contenedor.getBeanDefinitionNames();
        System.out.println("==========  BEANS CREADOS =============");
        for(int i=0; i<nombres.length; i++){
            System.out.println("bean ["+i+"]: "+nombres[i]);
        }        
        System.out.println("==========  BEANS CREADOS =============");
        ((Huerto)contenedor.getBean("huerto")).recolectar();
    }

}
