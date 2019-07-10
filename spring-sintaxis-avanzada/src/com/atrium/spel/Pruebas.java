package com.atrium.spel;

import java.util.List;

/**
 * Ejemplo de uso de expresiones dinamicas Spel en spring.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 2.0.
 * @since 27-3-2017.
 *
 */
public class Pruebas {
	//PROPIEDADES
	private int valorContador;
	private double importeCompras;
	private List<Cliente> clientes;
	private List<Cliente> mejoresClientes;
	private List<String> nuevaColeccion;
//ACCESORES PARA SPRING
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public double getImporteCompras() {
		return importeCompras;
	}

	public void setImporteCompras(double importeCompras) {
		this.importeCompras = importeCompras;
	}

	public List<Cliente> getMejoresClientes() {
		return mejoresClientes;
	}

	public void setMejoresClientes(List<Cliente> mejoresClientes) {
		this.mejoresClientes = mejoresClientes;
	}

	public List<String> getNuevaColeccion() {
		return nuevaColeccion;
	}

	public void setNuevaColeccion(List<String> nuevaColeccion) {
		this.nuevaColeccion = nuevaColeccion;
	}

	public int getValorContador() {
		return valorContador;
	}

	public void setValorContador(int valorContador) {
		this.valorContador = valorContador;
	}

}
