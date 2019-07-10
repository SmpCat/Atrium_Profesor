package com.atrium.anotaciones;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Ejemplo de uso de anotaciones de spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
@Component("zanahoria")
@Scope("prototype")
public class Zanahoria extends Vegetal {

	@Value("Daucus Carota")
	private String nombreCientifico;

	@Override
	@Value("naranja")
	public void setColor(String color) {
		super.setColor(color);
	}

	@Override
	@Value("70")
	public void setPeso(float peso) {
		super.setPeso(peso);
	}

	@Override
	public boolean maduro() {
		if ((getPeso() >= 40) && ("naranja".equals(getColor()))) {
			return true;
		} else {
			return false;
		}
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

}
