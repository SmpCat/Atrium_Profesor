package com.atrium.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Provincias;

/**
 * A data access object (DAO) providing persistence and search support for
 * Provincias entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see rdrre.Provincias
 * @author MyEclipse Persistence Tools
 */
public class ProvinciasDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ProvinciasDAO.class);
	// property constants
	public static final String PROVINCIA = "provincia";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Provincias transientInstance) {
		log.debug("saving Provincias instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Provincias persistentInstance) {
		log.debug("deleting Provincias instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Provincias findById(java.lang.Byte id) {
		log.debug("getting Provincias instance with id: " + id);
		try {
			Provincias instance = (Provincias) getCurrentSession().get(
					"Provincias", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Provincias> findByExample(Provincias instance) {
		log.debug("finding Provincias instance by example");
		try {
			List<Provincias> results = (List<Provincias>) getCurrentSession()
					.createCriteria("Provincias").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Provincias instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Provincias as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Provincias> findByProvincia(Object provincia) {
		return findByProperty(PROVINCIA, provincia);
	}

	public List findAll() {
		log.debug("finding all Provincias instances");
		try {
			String queryString = "from Provincias";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Provincias merge(Provincias detachedInstance) {
		log.debug("merging Provincias instance");
		try {
			Provincias result = (Provincias) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Provincias instance) {
		log.debug("attaching dirty Provincias instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Provincias instance) {
		log.debug("attaching clean Provincias instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProvinciasDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProvinciasDAO) ctx.getBean("ProvinciasDAO");
	}
}