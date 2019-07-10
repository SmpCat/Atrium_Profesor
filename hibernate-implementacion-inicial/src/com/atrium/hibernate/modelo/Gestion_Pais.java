package com.atrium.hibernate.modelo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.dao.PaisDAO;

/**
 * Fachada de acceso a la informacion de PAIS.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 2-11-2016.
 *
 */
public class Gestion_Pais implements IGestion_Pais {
	// DAO DE ACCESO A PAIS
	private PaisDAO pais_DAO;

	/**
	 * Constructor de la clase.
	 */
	public Gestion_Pais() {
		// CREACION DEL DAO
		pais_DAO = new PaisDAO();
	}

	// **** CONSULTAS
	/**
	 * Proceso de consulta de todos los paises.
	 * 
	 * @return Coleccion con la informacion obtenida de la base de datos.
	 */
	@Override
	public List<Pais> consultar_Todos() {
		// LLAMADA A LA OPERACION DEL DAO.
		List<Pais> lista = pais_DAO.findAll();
		// CIERRE DE LA CONEXIOS
		pais_DAO.getSession().close();
		// RETORNO DE LA INFORMACION
		return lista;
	}

	/**
	 * Proceso de consulta de un pais por su codigo.
	 * 
	 * @param codigopais
	 *            Codigo del pais consultado.
	 * @return Informacion obtenida.
	 */
	@Override
	public Pais consultar_PorCodigo(Long codigopais) {
		// LLAMADA A LA OPERACION DEL DAO.
		Pais pais_consultado = pais_DAO.findById(codigopais);
		// CIERRE DE LA CONEXION
		pais_DAO.getSession().close();
		// RETORNO DE LA INFORMACION
		return pais_consultado;
	}

	// ***** PROCESOS MODIFICATIVOS
	@Override
	public boolean alta_Pais(Pais pais_nuevo) {
		boolean correcto = true;
		Transaction tran = pais_DAO.getSession().beginTransaction();
		try {
			pais_DAO.save(pais_nuevo);
			tran.commit();
		} catch (HibernateException e) {
			tran.rollback();
			correcto = false;
		}
		pais_DAO.getSession().close();
		return correcto;
	}

	@Override
	public boolean baja_Pais(Pais pais_aeleminar) {
		boolean correcto = true;
		Transaction tran = pais_DAO.getSession().beginTransaction();
		try {
			pais_DAO.delete(pais_aeleminar);
			tran.commit();
		} catch (HibernateException e) {
			correcto = false;
			tran.rollback();
		}
		pais_DAO.getSession().close();
		return correcto;
	}

	@Override
	public boolean modificacion_Pais(Pais pais_amodificar) {
		boolean correcto = true;
		Transaction tran = pais_DAO.getSession().beginTransaction();
		try {
			pais_DAO.attachDirty(pais_amodificar);
			tran.commit();
		} catch (HibernateException e) {
			correcto = false;
			tran.rollback();
		}
		pais_DAO.getSession().close();
		return correcto;
	}
}
