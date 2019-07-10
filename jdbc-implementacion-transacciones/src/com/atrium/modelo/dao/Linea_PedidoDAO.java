package com.atrium.modelo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.atrium.modelo.dto.Linea_Pedido;

/**
 * DAO para el proceso de la tabla linea_pedido.
 * 
 * @author Juan Antonio Solves Garcia
 * @version 1.2
 */
public class Linea_PedidoDAO extends Abstract_DAO {

	public Linea_PedidoDAO() {
		super();
	}

	public Linea_PedidoDAO(int tipoconexion) {
		super(tipoconexion);
	}

	/**
	 * Proceso de alta de linea de pedido.
	 * 
	 * @param linea_nueva
	 *            DTO con la informacion.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public void alta_LineaPedido(Linea_Pedido linea_nueva) throws SQLException {
		// SE PREPARA EL ALTA
		pta = conexion.prepareStatement(rb.getString("alta.lineapedido"));
		// SE CARGAN LOS DATOS
		this.cargar_DatosPTA(linea_nueva, ALTA);
		// SE EJECUTA LA OPERACION
		pta.execute();
	}

	/**
	 * Proceso de baja de linea de pedido.
	 * 
	 * @param linea_nueva
	 *            DTO con la informacion.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public void baja_Pedido(Linea_Pedido linea_aborrar) throws SQLException {
		// SE PREPARA LA BAJA
		pta = conexion.prepareStatement(rb.getString("baja.lineapedido"));
		// SE CARGAN LOS DATOS
		pta.setLong(1, linea_aborrar.getCodigo_linea_pedido());
		// SE EJECUTA LA OPERACION
		pta.execute();
	}

	/**
	 * Proceso de modificacion de linea de pedido.
	 * 
	 * @param linea_nueva
	 *            DTO con la informacion.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public void modificacion_LineaPedido(Linea_Pedido linea_amodificar) throws SQLException {
		// SE PREPARA LA MODIFICACION
		pta = conexion.prepareStatement(rb.getString("modificacion.lineapedido"));
		// SE CARGAN LOS DATOS
		this.cargar_DatosPTA(linea_amodificar, MODIFICACION);
		// SE EJECUTA LA OPERACION
		pta.execute();
	}

	/**
	 * Proceso de consultar lineas de un pedido.
	 * 
	 * @param numero_pedido
	 *            Numero clave primaria del pedido.
	 * @return Informacion resultado de la consulta.
	 * @throws SQLException
	 *             Posible excepcion de la BD.
	 */
	public List<Linea_Pedido> consultar_LineasPedido(Integer numero_pedido) throws SQLException {
		// SE PREPARA LA CONSULTA
		pta = conexion.prepareStatement(rb.getString("consultar.lineaspedido.pedido"));
		// SE CARGAN LOS DATOS
		pta.setInt(1, numero_pedido);
		// SE EJECUTA LA CONSULTA
		rs = pta.executeQuery();
		List<Linea_Pedido> lista = new ArrayList<>(0);
		Linea_Pedido linea_pedido;
		// SE PASA EL CONJUNTO DE INFORMACION RESULTANTE DE LA CONSULTA A UNA
		// COLECCION
		while (rs.next()) {
			linea_pedido = new Linea_Pedido();
			linea_pedido.setCodigo_articulo(rs.getInt("codigo_articulo"));
			linea_pedido.setCodigo_linea_pedido(rs.getLong("codigo_linea_pedido"));
			linea_pedido.setNumero_pedido(rs.getInt("nuemro_pedido"));
			linea_pedido.setNumero_unidades_articulo(rs.getInt("numero_unidades_articulo"));
			linea_pedido.setPorcentaje_descuento(rs.getFloat("porcentaje_descuento"));
			linea_pedido.setPrecio_unidad_articulo(rs.getDouble("precio_unidad_articulo"));
			lista.add(linea_pedido);
		}
		return lista;
	}

	/**
	 * Proceso de carga de variables de los prepare statement.
	 * 
	 * @param linea_nueva
	 *            Objeto pedido con la informacion a cargar.
	 * @param tipo_proceso
	 *            Tipo de carga (alta/modificacion).
	 * @throws SQLException
	 */
	private void cargar_DatosPTA(Linea_Pedido linea_nueva, int tipo_proceso) throws SQLException {
		// POSICION DE LA VARIABLE EN EL COMANDO SQL
		int posicion_variable = 0;
		// EN FUNCION DEL TIPO DE PROCESO SE ESTABLECE LA POSICION INICIAL
		if (tipo_proceso == ALTA) {
			posicion_variable = 2;
			pta.setLong(1, linea_nueva.getCodigo_linea_pedido());
		}
		if (tipo_proceso == MODIFICACION) {
			posicion_variable = 1;
			pta.setLong(6, linea_nueva.getCodigo_linea_pedido());
		}
		// UNA VEZ ESTABLECIDO EL POSICION INICIAL DE LA VARIABLE CARGAMOS LOS
		// VALORES
		if (linea_nueva.getCodigo_articulo() != null) {
			pta.setInt(posicion_variable, linea_nueva.getCodigo_articulo());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (linea_nueva.getNumero_pedido() != null) {
			pta.setInt(posicion_variable, linea_nueva.getNumero_pedido());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (linea_nueva.getPrecio_unidad_articulo() != null) {
			pta.setDouble(posicion_variable, linea_nueva.getPrecio_unidad_articulo());
		} else {
			pta.setDouble(posicion_variable, new Double(0));
		}
		posicion_variable++;
		if (linea_nueva.getNumero_unidades_articulo() != null) {
			pta.setInt(posicion_variable, linea_nueva.getNumero_unidades_articulo());
		} else {
			pta.setInt(posicion_variable, new Integer(0));
		}
		posicion_variable++;
		if (linea_nueva.getPorcentaje_descuento() != null) {
			pta.setFloat(posicion_variable, linea_nueva.getPorcentaje_descuento());
		} else {
			pta.setFloat(posicion_variable, new Float(0));
		}

	}
}
