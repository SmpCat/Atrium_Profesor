package com.atrium.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atrium.modelo.Gestion_Pedidos;
import com.atrium.modelo.dto.Linea_Pedido;
import com.atrium.modelo.dto.Pedido;

/**
 * Implementacion de uso de transacciones a la BD via JDBC.
 * 
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * 
 */
public class Inicio {

	public static void main(String[] args) {
		// CREAMOS LA FACHADA
		Gestion_Pedidos gestion_pedido = new Gestion_Pedidos();

		// DATOS DEL PEDIDO
		Pedido pedido_nuevo = new Pedido();
		pedido_nuevo.setNumero_pedido(new Integer(9980));
		pedido_nuevo.setFecha_pedido(new Date());
		pedido_nuevo.setTotal_factura_pedido(new Double(10151));
		pedido_nuevo.setCodigo_cliente(new Integer(21));
		// DATOS DE LAS LINEAS DE PEDIDO
		List<Linea_Pedido> lineas = new ArrayList<>();
		Linea_Pedido linea_nueva = new Linea_Pedido();
		linea_nueva.setCodigo_linea_pedido(new Long(1201));
		linea_nueva.setNumero_pedido(new Integer(9980));
		linea_nueva.setCodigo_articulo(new Integer(101));
		lineas.add(linea_nueva);
		linea_nueva = new Linea_Pedido();
		linea_nueva.setCodigo_linea_pedido(new Long(1202));
		linea_nueva.setNumero_pedido(new Integer(9980));
		linea_nueva.setCodigo_articulo(new Integer(104));
		lineas.add(linea_nueva);
		// PASO LAS LINEAS DE PEDIDO AL PEDIDO NUEVO
		pedido_nuevo.setLineas_pedido(lineas);

		// LLAMADA AL PROCESO DE ALTA CON GESTION DE TRANSACCIONES
		boolean valido = gestion_pedido.alta_Pedido(pedido_nuevo);
		

	}

}
