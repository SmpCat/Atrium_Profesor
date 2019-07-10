package com.atrium.hibernate.dao.ext;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.atrium.hibernate.Pais;
import com.atrium.hibernate.dao.PaisDAO;

public class Pais_DAOEXT extends PaisDAO {

	public List<Pais> consultar_TodosOrdenados() {
		Criteria consulta = getCurrentSession().createCriteria(Pais.class);
		// EJEMPLO DE CONSULTA ORDENADA A LA BASE DE DATOS.
		consulta.addOrder(Order.desc("paisNombre"));
		return consulta.list();
	}

}
