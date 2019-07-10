package anotaciones;

import anotaciones.anotadas.Dulce;
import anotaciones.anotadas.FrutoSeco;

/**
 * Ejemplo de clase anotada para la gestion de metadatos.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 1-3-2017.
 *
 */
public class BolsitaMarcaA {
	@FrutoSeco(calorias = 500, tieneVitaminaE = true, arbolQueDaEsteFruto = "Almendro")
	private int almendras = 50;

	@FrutoSeco(calorias = 600, tieneVitaminaE = true, arbolQueDaEsteFruto = "Avellano")
	private int avellanas = 40;

	@FrutoSeco(calorias = 700, arbolQueDaEsteFruto = "Pino")
	private int pinones = 30;

	@Dulce(2500)
	private int caramelos = 20;

	@Dulce(3800)
	private int chocolates = 15;

	@SuppressWarnings("unused")
	private int juguetesPromocionales = 1;
}