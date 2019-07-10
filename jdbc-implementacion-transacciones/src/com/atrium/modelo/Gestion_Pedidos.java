package com.atrium.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atrium.modelo.dao.Linea_PedidoDAO;
import com.atrium.modelo.dao.Pedidos_DAO;
import com.atrium.modelo.dto.Linea_Pedido;
import com.atrium.modelo.dto.Pedido;
/**
 * Fachada del proceso de acceso a la base de datos.
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 *
 */
public class Gestion_Pedidos {
	// DAOS PARA LOS PROCESOS DE DATOS
	private Pedidos_DAO pedido_dao;
	private Linea_PedidoDAO linea_dao;

	public Gestion_Pedidos() {
		pedido_dao = new Pedidos_DAO();
		linea_dao = new Linea_PedidoDAO();
	}

	/**
	 * Alta pedido sin ejecutar transaccion.
	 * 
	 * @param pedido_nuevo
	 * @return
	 */
	public boolean alta_PedidoNoTransaccional(Pedido pedido_nuevo) {
		boolean valido = true;
		try {
			pedido_dao.alta_Pedido(pedido_nuevo);
		} catch (SQLException e) {
			valido = false;
		}
		return valido;
	}

	/**
	 * Proceso transaccional de alta de pedido.
	 * 
	 * @param pedido_nuevo
	 * @return
	 */
	public boolean alta_Pedido(Pedido pedido_nuevo) {
		boolean valido = true;
		try {
			// INTERCAMBIO DE CONEXIONES PARA QUE AMBOS DAO TENGAN LA MISMA
			linea_dao.recibir_Conexion(pedido_dao.conexion);
			// APERTURA DE TRANSACCION
			pedido_dao.iniciar_Transaccion();
			// INICIO DE OPERACIONES EN LA TRANSACCION
			pedido_dao.alta_Pedido(pedido_nuevo);
			for (Linea_Pedido linea : pedido_nuevo.getLineas_pedido()) {
				linea_dao.alta_LineaPedido(linea);
			}
			// CONFIRMACION DE LA TRANSACCION
			pedido_dao.confirmar_Transaccion();
		} catch (SQLException e) {
			try {
				// ANULACION DE LA TRANSACCION
				pedido_dao.anular_Transaccion();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			valido = false;
		}
		try {
			// LIBERACION DE RECURSOS EN LOS DAO
			pedido_dao.liberar_Recursos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valido;
	}

	public Pedido consultar_Pedido(Integer numero_pedido) {
		Pedido pedido_consultado = null;
		try {
			pedido_consultado = pedido_dao
					.consultar_PedidoPorNumero(numero_pedido);
			pedido_dao.liberar_Recursos();
		} catch (SQLException sql) {
			System.out.println("error");
		}
		return pedido_consultado;
	}

}
