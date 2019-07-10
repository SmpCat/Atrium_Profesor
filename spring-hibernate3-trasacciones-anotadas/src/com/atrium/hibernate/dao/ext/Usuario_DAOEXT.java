package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

@Component("usuario_dao")
@Scope("prototype")
public class Usuario_DAOEXT extends UsuariosDAO {

	public Usuarios consultar_ConRol(String nombre_usuario) {
		// ABRIMOS LA CONSULTA
		DetachedCriteria consulta = DetachedCriteria.forClass(Usuarios.class);
		// RESOLUCION DE LA RELACION ENTRE ENTIDADES
		consulta.setFetchMode("roles", FetchMode.JOIN);
		// CONDICION DE IGUALDAD EN CLAVE PRIMARIA
		consulta.add(Restrictions.idEq(nombre_usuario));
		// HACEMOS LA CONSULTA
		List<Usuarios> lista = getHibernateTemplate().findByCriteria(consulta);
		Usuarios usuario = null;
		if (!lista.isEmpty()) {
			usuario = lista.get(0);
		}
		// RETORNAMOS EL VALOR DE LA CONSULTA
		return usuario;
	}

	public Usuarios consultar_Todo(String nombre_usuario) {
		// ABRIMOS LA CONSULTA
		DetachedCriteria consulta = DetachedCriteria.forClass(Usuarios.class);
		// RESOLUCION DE LA RELACION ENTRE ENTIDADES
		consulta.setFetchMode("roles", FetchMode.JOIN);
		// RESOLUCION DE LA RELACION ENTRE ENTIDADES
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		// CONDICION DE IGUALDAD EN CLAVE PRIMARIA
		consulta.add(Restrictions.idEq(nombre_usuario));
		// RESOLUCION DE PRODUCTO CARTESIANO
		consulta.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// HACEMOS LA CONSULTA
		List<Usuarios> lista = getHibernateTemplate().findByCriteria(consulta);
		Usuarios usuario = null;
		if (!lista.isEmpty()) {
			usuario = lista.get(0);
		}
		// RETORNAMOS EL VALOR DE LA CONSULTA
		return usuario;
	}
}
