package com.atrium.autoenlazado;

/**
 * Ejemplo de uso de AUTOWIRED autoenlazado en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 15-3-2017.
 *
 */
public class Orquesta {

	private Guitarra guitarra;
	private Piano piano;
	private Violin violin;

	public Orquesta() {
	}

	public Orquesta(Guitarra guitarra, Piano piano, Violin violin) {
		this.guitarra = guitarra;
		this.piano = piano;
		this.violin = violin;
	}

	public Guitarra getGuitarra() {
		return guitarra;
	}

	public void setGuitarra(Guitarra guitarra) {
		this.guitarra = guitarra;
	}

	public Piano getPiano() {
		return piano;
	}

	public void setPiano(Piano piano) {
		this.piano = piano;
	}

	public Violin getViolin() {
		return violin;
	}

	public void setViolin(Violin violin) {
		this.violin = violin;
	}

	public void concierto() {
		guitarra.tocar();
		piano.tocar();
		violin.tocar();
	}

}
