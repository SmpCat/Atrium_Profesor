package anotaciones;

import anotaciones.anotadas.Dulce;
import anotaciones.anotadas.FrutoSeco;

/**
 * Ejemplo de anotacion para a�adir metadatos a los objetos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
 *
 */
public class BolsitaMarcaB {
	@FrutoSeco(calorias = 300, tieneVitaminaE = true, arbolQueDaEsteFruto = "Almendro")
	private int almendras = 20;

	@FrutoSeco(calorias = 250, tieneVitaminaE = true)
	private int nueces = 30;

	@Dulce(1500)
	private int azucarillos = 15;

	@SuppressWarnings("unused")
	private int tornillos = 2;
}