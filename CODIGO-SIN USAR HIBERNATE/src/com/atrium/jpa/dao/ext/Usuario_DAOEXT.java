package com.atrium.jpa.dao.ext;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.atrium.jpa.Roles;
import com.atrium.jpa.Usuarios;
import com.atrium.jpa.dao.EntityManagerHelper;
import com.atrium.jpa.dao.UsuariosDAO;

public class Usuario_DAOEXT extends UsuariosDAO {

	

	// FUNCIONA CON EL MOTOR DE PERSISTENCIA DE ECLIPSELINK PERO CON HIBERNATE 4
	// FALTA UNA LIBERIA AL EVALUAR LA CONDICION
	@Override
	public Usuarios consultar_ConRol(String nombre_usuario) {
		// OBTENEMOS EL CONSTRUCTOR DE CONSULTAS
		CriteriaBuilder criteriaBuilder = EntityManagerHelper
				.getEntityManager().getCriteriaBuilder();
		// CREAMOS UNA CONSULTA PARA LA ENTIDAD QUE NECESITEMOS
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder
				.createQuery(Usuarios.class);
		// DEFINIMOS OBJETOS AUXILIARES PARA LA DEFINICION DE LA CONSULTA
		Root<Usuarios> usuario = criteriaQuery.from(Usuarios.class);
		Root<Roles> rol = criteriaQuery.from(Roles.class);
		// COLECCION DONDE ALMACENAR TODAS LAS CONDICIONES
		List<Predicate> lista_condiciones = new ArrayList<Predicate>();
		// CONDICION DE IGUALDAD EN CLAVE PRIMARIA
		Predicate condicion_igualdad = criteriaBuilder.equal(
				usuario.get("nombreUsuario"), nombre_usuario);
		// GUARDAMOS LA CONDICION (PREDICATE) EN UNA COLECCION PARA PODER AÑADIR
		// TODAS LAS NECESARIAS
		lista_condiciones.add(condicion_igualdad);
		// CREAMOS UN SOLO CRITERIA CON TODAS LAS CONDICIONES CREADAS
		criteriaQuery.where(criteriaBuilder.and(lista_condiciones
				.toArray(new Predicate[0])));
		// SE PREPARA EL OBJETO NECESARIO PARA LANZAR LA CONSULTA -- EVALUACION
		// DE LA CONDICION
		TypedQuery<Usuarios> query = EntityManagerHelper.getEntityManager()
				.createQuery(criteriaQuery);
		// LANZAMOS LA CONSULTA PARA MULTIPLES RESULTADOS
		List<Usuarios> lista = query.getResultList();
		// LANZAMOS CONSULTA PARA RESULTADO UNICO
		Usuarios usuario_consultado = (Usuarios) query.getSingleResult();
		return usuario_consultado;
	}

}