package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

/**
 * Ejemplo de extension del DAO base para añadir nuestras propias consultas.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.5.
 * @since 4-3-2017.
 *
 */
public class Usuario_DAOEXT extends UsuariosDAO {
	/**
	 * Consulta que resulve la relacion entre usuarios y roles.
	 * 
	 * @param 
	 * @return Objeto de persistencia resultante de la consulta.
	 */
	public Usuarios consultar_ConRol(String nombre_usuario) {
		// CONSULTA DESCONECTADA
		DetachedCriteria consulta = DetachedCriteria.forClass(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));
		List<Usuarios> lista = getHibernateTemplate().findByCriteria(consulta);
		Usuarios usuario = null;
		if (!lista.isEmpty()) {
			usuario = lista.get(0);
		}
		return usuario;
	}
}
