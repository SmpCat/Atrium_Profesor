package com.atrium.hibernate.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.atrium.hibernate.Provincias;

/**
 * A data access object (DAO) providing persistence and search support for
 * Provincias entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Provincias
 * @author MyEclipse Persistence Tools
 */
public class ProvinciasDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ProvinciasDAO.class);
	// property constants
	public static final String PROVINCIA = "provincia";

	protected void initDao() {
		// do nothing
	}

	public void save(Provincias transientInstance) {
		log.debug("saving Provincias instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Provincias persistentInstance) {
		log.debug("deleting Provincias instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Provincias findById(java.lang.Byte id) {
		log.debug("getting Provincias instance with id: " + id);
		try {
			Provincias instance = (Provincias) getHibernateTemplate().get(
					"com.atrium.hibernate.Provincias", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Provincias> findByExample(Provincias instance) {
		log.debug("finding Provincias instance by example");
		try {
			List<Provincias> results = (List<Provincias>) getHibernateTemplate()
					.findByExample(instance);
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
			return getHibernateTemplate().find(queryString, value);
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
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Provincias merge(Provincias detachedInstance) {
		log.debug("merging Provincias instance");
		try {
			Provincias result = (Provincias) getHibernateTemplate().merge(
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
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Provincias instance) {
		log.debug("attaching clean Provincias instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
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