package com.atrium.aop;

/**
 * Ejemplo de uso de AOP en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 29-3-2017.
 *
 */
public class Aspecto {
    public void antes3(String nombre, int edad, String dato){
        System.out.println("Antes====> nombre: "+nombre+ " edad: "+ edad+" dato: "+dato+"\n");
    }
    public void antes2(String nombre, int edad){
        System.out.println("Antes====> nombre: "+nombre+ " edad: "+ edad+"\n");
    } 
     public void antes22(String nombre, String dato){
        System.out.println("Antes====> nombre: "+" dato: "+dato+"\n");
    }
     public void antes0(){
        System.out.println("Antes====> Sin parametros"+"\n");
    }
    public void despues3(String nombre, int edad, String dato){
        System.out.println("Despues====> nombre: "+nombre+ " edad: "+ edad+" dato: "+dato+"\n");
        separa();
    }
    public void despues2(String nombre, int edad){
        System.out.println("Despues====> nombre: "+nombre+ " edad: "+ edad+"\n");
        separa();
    } 
     public void despues22(String nombre, String dato){
        System.out.println("Despues====> nombre: "+" dato: "+dato+"\n");
        separa();
    }
     public void despues0(){
        System.out.println("Despues====> Sin parametros"+"\n");
        separa();
    }
    public void separa(){
        System.out.println("============================================================");
    }
}
