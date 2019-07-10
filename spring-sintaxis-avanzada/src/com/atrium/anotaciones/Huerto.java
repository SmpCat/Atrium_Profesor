package com.atrium.anotaciones;

import org.springframework.beans.factory.annotation.Autowired;
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
public class Huerto {
	// @AUTOWIRE LO PODEMOS PONER EN LA PROPIEDAD, EN EL CONSTRUCTOR,
	// O EN LOS METODOS SET
	@Autowired
	private Remolacha remolacha;

	@Autowired
	// @Inject
	// @Qualifier("producto") // se utiliza para resolver ambiguedades
	// @Named("tomate2") // en este caso se pone el id del bean
	private Tomate tomate;

	@Autowired
	// @Inject
	private Zanahoria zanahoria;

	public Huerto() {
	}

	public Huerto(Remolacha remolacha, Tomate tomate, Zanahoria zanahoria) {
		this.remolacha = remolacha;
		this.tomate = tomate;
		this.zanahoria = zanahoria;
	}

	public Remolacha getRemolacha() {
		return remolacha;
	}

	public void setRemolacha(Remolacha remolacha) {
		this.remolacha = remolacha;
	}

	public Tomate getTomate() {
		return tomate;
	}

	public void setTomate(Tomate tomate) {
		this.tomate = tomate;
	}

	public Zanahoria getZanahoria() {
		return zanahoria;
	}

	public void setZanahoria(Zanahoria zanahoria) {
		this.zanahoria = zanahoria;
	}

	public void recolectar() {
		if ((remolacha != null) && (remolacha.maduro()))
			System.out.println("Recogiendo remolacha" + remolacha.toString());

		if ((tomate != null) && (tomate.maduro()))
			System.out.println("Recogiendo tomate" + tomate.toString());

		if ((zanahoria != null) && (zanahoria.maduro()))
			System.out.println("Recogiendo " + zanahoria.getNombreCientifico()
					+ " " + zanahoria + " ");
	}

}
