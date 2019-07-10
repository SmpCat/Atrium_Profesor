package com.atrium.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.atrium.modelo.dto.Pedido;

/**
 * DAO para el proceso de la tabla Pedidos.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 */
public class Pedidos_DAO extends Abstract_DAO {

	public Pedidos_DAO() {
		super();
	}

	public Pedidos_DAO(int tipoconexion) {
		super(tipoconexion);
	}

	/**
	 * Proceso de alta de pedido.
	 * 
	 * @param pedido_nuevo
	 *            DTO con la informacion.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public void alta_Pedido(Pedido pedido_nuevo) throws SQLException {
		// SE PREPARA EL ALTA
		pta = conexion.prepareStatement(rb.getString("alta.pedido"));
		// SE CARGAN LOS DATOS
		this.cargar_DatosPTA(pedido_nuevo, ALTA);
		// SE EJECUTA EL ALTA
		pta.execute();
	}

	/**
	 * Proceso de baja de pedido.
	 * 
	 * @param pedido_nuevo
	 *            DTO con la informacion.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public void baja_Pedido(Pedido pedido_aeliminar) throws SQLException {
		// SE PREPARA LA BAJA
		pta = conexion.prepareStatement(rb.getString("baja.pedido"));
		// SE CARGAN LOS DATOS
		pta.setInt(1, pedido_aeliminar.getNumero_pedido());
		// SE EJECUTA LA BAJA
		pta.execute();
	}

	/**
	 * Proceso de modificacion de pedido.
	 * 
	 * @param pedido_nuevo
	 *            DTO con la informacion.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public void modificar_Pedido(Pedido pedido_amodificar) throws SQLException {
		// SE PREPARA LA MODIFICACION
		pta = conexion.prepareStatement(rb.getString("modificacion.pedido"));
		// SE CARGAN LOS DATOS
		this.cargar_DatosPTA(pedido_amodificar, MODIFICACION);
		// SE EJECUTA LA MODIFICACION
		pta.execute();
	}

	/**
	 * Proceso de consulta de pedido.
	 * 
	 * @param numero_pedido
	 *            Numero clave primaria del pedido.
	 * @return Informacion resultado de la consulta.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public Pedido consultar_PedidoPorNumero(Integer numero_pedido) throws SQLException {
		// SE PREPARA LA CONSULTA
		pta = conexion.prepareStatement(rb.getString("consulta.pedido.numero"));
		// SE SUSTITUYE LA VARIABLE POR SU RESULTADO
		pta.setInt(1, numero_pedido);
		// SE EJECUTA LA CONSULTA
		rs = pta.executeQuery();
		Pedido pedido_consultado = null;
		// SE BUSCA EN EL RESULTASET ALGUN RESULTADO SI LO HAY
		if (rs.next()) {
			// SE PASA LA INFORMACION AL OBJETO CORRESPONDIENTE
			pedido_consultado = new Pedido();
			// Cargar_Datos.cargar_Objeto_RS(rs, pedido_consultado);
			pedido_consultado.setCodigo_cliente(rs.getInt("codigo_cliente"));
			pedido_consultado.setFecha_pedido(new java.util.Date(rs.getDate("fecha_pedido").getTime()));
			pedido_consultado.setIva_pedido(rs.getDouble("iva_pedido"));
			pedido_consultado.setNumero_pedido(rs.getInt("numero_pedido"));
			pedido_consultado.setOtros_cargos_pedio(rs.getDouble("otros_cargos_pedido"));
			pedido_consultado.setPorcentaje_iva_pedido(rs.getInt("iva_pedido"));
			pedido_consultado.setSeguro_pedido(rs.getDouble("seguro_pedido"));
			pedido_consultado.setTotal_bruto_pedido(rs.getDouble("total_bruto_pedido"));
			pedido_consultado.setTotal_cargos_pedido(rs.getDouble("total_cargos_pedido"));
			pedido_consultado.setTotal_factura_pedido(rs.getDouble("total_factura_pedido"));
		}
		// SE RETORNA EL RESULTADO DE LA CONSULTA
		return pedido_consultado;
	}

	/**
	 * Proceso de carga de variables de los prepare statement.
	 * 
	 * @param pedido_nuevo
	 *            Objeto pedido con la informacion a cargar.
	 * @param tipo_proceso
	 *            Tipo de carga (alta/modificacion).
	 * @throws SQLException
	 */
	private void cargar_DatosPTA(Pedido pedido_nuevo, int tipo_proceso) throws SQLException {
		// POSICION DE LA VARIABLE EN EL COMANDO SQL
		int posicion_variable = 0;
		// EN FUNCION DEL TIPO DE PROCESO SE ESTABLECE LA POSICION INICIAL
		if (tipo_proceso == ALTA) {
			posicion_variable = 2;
			pta.setInt(1, pedido_nuevo.getNumero_pedido());
		}
		if (tipo_proceso == MODIFICACION) {
			posicion_variable = 1;
			pta.setInt(11, pedido_nuevo.getNumero_pedido());
		}
		// UNA VEZ ESTABLECIDO EL POSICION INICIAL DE LA VARIABLE CARGAMOS LOS
		// VALORES
		if (pedido_nuevo.getFecha_pedido() != null) {
			pta.setDate(posicion_variable, new Date(pedido_nuevo.getFecha_pedido().getTime()));
		} else {
			pta.setDate(posicion_variable, new Date(new java.util.Date().getTime()));
		}
		posicion_variable++;
		if (pedido_nuevo.getPorte_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getPorte_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getSeguro_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getSeguro_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getOtros_cargos_pedio() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getOtros_cargos_pedio());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getTotal_cargos_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getTotal_cargos_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getTotal_bruto_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getTotal_bruto_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getPorcentaje_iva_pedido() != null) {
			pta.setInt(posicion_variable, pedido_nuevo.getPorcentaje_iva_pedido());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getIva_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getIva_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (pedido_nuevo.getTotal_factura_pedido() != null) {
			pta.setDouble(posicion_variable, pedido_nuevo.getTotal_factura_pedido());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		pta.setInt(posicion_variable, pedido_nuevo.getCodigo_cliente());
	}
}
