package com.atrium.hibernate.dao;

import com.atrium.hibernate.Tareas;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tareas entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Tareas
 * @author MyEclipse Persistence Tools
 */
public class TareasDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TareasDAO.class);
	// property constants
	public static final String DESCRIPCION_TAREA = "descripcionTarea";
	public static final String VINCULO = "vinculo";

	public void save(Tareas transientInstance) {
		log.debug("saving Tareas instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tareas persistentInstance) {
		log.debug("deleting Tareas instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tareas findById(java.lang.Byte id) {
		log.debug("getting Tareas instance with id: " + id);
		try {
			Tareas instance = (Tareas) getSession().get(
					"com.atrium.hibernate.Tareas", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tareas instance) {
		log.debug("finding Tareas instance by example");
		try {
			List results = getSession()
					.createCriteria("com.atrium.hibernate.Tareas")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Tareas instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tareas as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDescripcionTarea(Object descripcionTarea) {
		return findByProperty(DESCRIPCION_TAREA, descripcionTarea);
	}

	public List findByVinculo(Object vinculo) {
		return findByProperty(VINCULO, vinculo);
	}

	public List findAll() {
		log.debug("finding all Tareas instances");
		try {
			String queryString = "from Tareas";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tareas merge(Tareas detachedInstance) {
		log.debug("merging Tareas instance");
		try {
			Tareas result = (Tareas) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tareas instance) {
		log.debug("attaching dirty Tareas instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tareas instance) {
		log.debug("attaching clean Tareas instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}