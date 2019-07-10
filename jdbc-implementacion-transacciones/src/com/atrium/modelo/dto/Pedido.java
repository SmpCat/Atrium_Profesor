package com.atrium.modelo.dto;

import java.util.Date;
import java.util.List;

/**
 * DTO para la tabla MUNICIPIOS de oracle.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.0
 * 
 */
public class Pedido {

	// DATOS DE PEDIDO
	private Integer numero_pedido;
	private Date fecha_pedido;
	private Double porte_pedido;
	private Double seguro_pedido;
	private Double otros_cargos_pedio;
	private Double total_cargos_pedido;
	private Double total_bruto_pedido;
	private Integer porcentaje_iva_pedido;
	private Double iva_pedido;
	private Double total_factura_pedido;
	private Integer codigo_cliente;

	// REPRESENTACION DE LA RELACION ENTRE PEDIDOS Y LINEA DE PEDIDOS
	private List<Linea_Pedido> lineas_pedido;

	// METODOS ACCESORES
	public List<Linea_Pedido> getLineas_pedido() {
		return lineas_pedido;
	}

	public void setLineas_pedido(List<Linea_Pedido> lineas_pedido) {
		this.lineas_pedido = lineas_pedido;
	}

	public Integer getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(Integer numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public Date getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Double getPorte_pedido() {
		return porte_pedido;
	}

	public void setPorte_pedido(Double porte_pedido) {
		this.porte_pedido = porte_pedido;
	}

	public Double getSeguro_pedido() {
		return seguro_pedido;
	}

	public void setSeguro_pedido(Double seguro_pedido) {
		this.seguro_pedido = seguro_pedido;
	}

	public Double getOtros_cargos_pedio() {
		return otros_cargos_pedio;
	}

	public void setOtros_cargos_pedio(Double otros_cargos_pedio) {
		this.otros_cargos_pedio = otros_cargos_pedio;
	}

	public Double getTotal_cargos_pedido() {
		return total_cargos_pedido;
	}

	public void setTotal_cargos_pedido(Double total_cargos_pedido) {
		this.total_cargos_pedido = total_cargos_pedido;
	}

	public Double getTotal_bruto_pedido() {
		return total_bruto_pedido;
	}

	public void setTotal_bruto_pedido(Double total_bruto_pedido) {
		this.total_bruto_pedido = total_bruto_pedido;
	}

	public Integer getPorcentaje_iva_pedido() {
		return porcentaje_iva_pedido;
	}

	public void setPorcentaje_iva_pedido(Integer porcentaje_iva_pedido) {
		this.porcentaje_iva_pedido = porcentaje_iva_pedido;
	}

	public Double getIva_pedido() {
		return iva_pedido;
	}

	public void setIva_pedido(Double iva_pedido) {
		this.iva_pedido = iva_pedido;
	}

	public Double getTotal_factura_pedido() {
		return total_factura_pedido;
	}

	public void setTotal_factura_pedido(Double total_factura_pedido) {
		this.total_factura_pedido = total_factura_pedido;
	}

	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

}
