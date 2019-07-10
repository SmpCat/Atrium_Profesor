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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.atrium.hibernate.Municipios;
import com.atrium.hibernate.MunicipiosId;

/**
 * A data access object (DAO) providing persistence and search support for
 * Municipios2 entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.atrium.hibernate.Municipios
 * @author MyEclipse Persistence Tools
 */
@Repository("municipio_dao")
@Scope("prototype")
public class MunicipiosDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MunicipiosDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Municipios transientInstance) {
		log.debug("saving Municipios instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Municipios persistentInstance) {
		log.debug("deleting Municipios instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Municipios findById(com.atrium.hibernate.MunicipiosId id) {
		log.debug("getting Municipios instance with id: " + id);
		try {
			Municipios instance = (Municipios) getCurrentSession().get(
					"com.atrium.hibernate.Municipios", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Municipios> findByExample(Municipios instance) {
		log.debug("finding Municipios instance by example");
		try {
			List<Municipios> results = (List<Municipios>) getCurrentSession()
					.createCriteria("com.atrium.hibernate.Municipios")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Municipios instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Municipios as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Municipios instances");
		try {
			String queryString = "from Municipios";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Municipios merge(Municipios detachedInstance) {
		log.debug("merging Municipios instance");
		try {
			Municipios result = (Municipios) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Municipios instance) {
		log.debug("attaching dirty Municipios instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Municipios instance) {
		log.debug("attaching clean Municipios instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MunicipiosDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (MunicipiosDAO) ctx.getBean("MunicipiosDAO");
	}
}