 package com.atrium.anotaciones;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Ejemplo de uso de anotaciones de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
@Component
public class Remolacha extends Vegetal{

    public Remolacha() {
    }

    @Override
    @Value("morado")
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    @Value("100")
    public void setPeso(float peso) {
        super.setPeso(peso);
    }



    @Override
    public boolean maduro() {
        if ((getPeso() >= 80) && ("morado".equals(getColor()))){
            return true;
        }else{
            return false;
        }
    }

}
