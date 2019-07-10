package com.atrium.hibernate.dao.ext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.atrium.hibernate.Tareas;
import com.atrium.hibernate.Usuarios;
import com.atrium.hibernate.dao.UsuariosDAO;

/**
 * Extension del DAO original con los metodos propios de consulta.
 * 
 * @author Juan Antonio Solves Garcia.
 * @version 1.0.
 * @since 26-10-2016.
 *
 */
public class Usuarios_DAOEXT extends UsuariosDAO {

	/**
	 * Consulta de resolucion de carga vaga de TAREAS.
	 * 
	 * @param nombre_usuario
	 *            Nombre del usuarioa consultar.
	 * @return Resultado de la consulta
	 */
	public List<Tareas> consultar_Tareas(String nombre_usuario) {
		// CREAMOS EL OBJETO CRITERIA
		Criteria consulta = getSession().createCriteria(Usuarios.class);
		// ESTABLECEMOS LAS OPCIONES DE LA CONSULTA
		// ** RESOLUCION DE CARGA VAGA
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		// CONDICIONES
		consulta.add(Restrictions.idEq(nombre_usuario));
		// GESTION DEL PRODUCTO CARTESIANO DE LA CONSULTA
		consulta.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		// REALIZACION DE LA CONSULTA
		Usuarios usuario = (Usuarios) consulta.uniqueResult();
		List<Tareas> lista_tareas = new ArrayList<Tareas>(0);
		// TRATAMIENTO DEL RESULTADO DE LA CONSULTA PREVIO A LA DEVOLUCION DEL
		// VALOR
		if (usuario != null) {
			Set<Tareas> set_tareas = usuario.getRoles().getTareases();
			if (!set_tareas.isEmpty()) {
				lista_tareas.addAll(set_tareas);
			}
		}
		// RETORNO DEL RESULTADO
		return lista_tareas;
	}

	/**
	 * Consulta de resolucion de carga vaga de ROLES.
	 * 
	 * @param nombre_usuario
	 *            Nombre del usuario a consultar.
	 * @return Resultado de la consulta
	 */
	public Usuarios consultar_ConRol(String nombre_usuario) {
		// CREAMOS EL OBJETO CRITERIA
		Criteria consulta = getSession().createCriteria(Usuarios.class);
		// ESTABLECEMOS LAS OPCIONES DE LA CONSULTA
		// ** RESOLUCION DE CARGA VAGA
		consulta.setFetchMode("roles", FetchMode.JOIN);
		consulta.setFetchMode("roles.tareases", FetchMode.JOIN);
		// CONDICIONES
		consulta.add(Restrictions.idEq(nombre_usuario));
		// GESTION DEL PRODUCTO CARTESIANO DE LA CONSULTA
		consulta.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		// REALIZACION DE LA CONSULTA
		Usuarios usuario = (Usuarios) consulta.uniqueResult();
		// RETORNO DEL RESULTADO
		return usuario;
	}

}
