package com.atrium.hibernate.dao.ext;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

@Component("usuarios_dao")
@Scope("prototype")
public class Usuario_DAOEXT extends UsuariosDAO {

	public Usuarios consultar_UsuarioConRol(String nombre_usuario) {
		Criteria consulta = getCurrentSession().createCriteria(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));
		return (Usuarios) consulta.uniqueResult();
	}

	public Usuarios consultar_TareasUsuario(String nombre_usuario) {
		Criteria consulta = getCurrentSession().createCriteria(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre_usuario));
		return (Usuarios) consulta.uniqueResult();
	}

	public List<Tareas> consultar_Tareas(String nombre) {
		Criteria consulta = getCurrentSession().createCriteria(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre));
		consulta.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		List<Usuarios> lista = consulta.list();
		List<Tareas> lista_tareas = new ArrayList<Tareas>(0);
		if (lista.size() > 0 && lista.get(0).getRoles() != null) {
			lista_tareas.addAll(lista.get(0).getRoles().getTareases());
		}
		return lista_tareas;
	}

	public Usuarios consulta_GeneralUsuario(String nombre) {
		Criteria consulta = getCurrentSession().createCriteria(Usuarios.class);
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		consulta.add(Restrictions.idEq(nombre));
		consulta.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		return (Usuarios) consulta.uniqueResult();
	}
}
