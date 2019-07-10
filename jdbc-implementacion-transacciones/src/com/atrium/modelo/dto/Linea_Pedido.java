package com.atrium.modelo.dto;

/**
 * DTO para la tabla LINEA_PEDIDO de oracle.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0
 * 
 */
public class Linea_Pedido {
	// PROPIEDADES DE CLASE
	private Long codigo_linea_pedido;
	private Integer codigo_articulo;
	private Integer numero_pedido;
	private Double precio_unidad_articulo;
	private Integer numero_unidades_articulo;
	private Float porcentaje_descuento;

	//METODOS ACCESORES
	public Long getCodigo_linea_pedido() {
		return codigo_linea_pedido;
	}

	public void setCodigo_linea_pedido(Long codigo_linea_pedido) {
		this.codigo_linea_pedido = codigo_linea_pedido;
	}

	public Integer getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(Integer codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

	public Integer getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(Integer numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public Double getPrecio_unidad_articulo() {
		return precio_unidad_articulo;
	}

	public void setPrecio_unidad_articulo(Double precio_unidad_articulo) {
		this.precio_unidad_articulo = precio_unidad_articulo;
	}

	public Integer getNumero_unidades_articulo() {
		return numero_unidades_articulo;
	}

	public void setNumero_unidades_articulo(Integer numero_unidades_articulo) {
		this.numero_unidades_articulo = numero_unidades_articulo;
	}

	public Float getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(Float porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}

}
