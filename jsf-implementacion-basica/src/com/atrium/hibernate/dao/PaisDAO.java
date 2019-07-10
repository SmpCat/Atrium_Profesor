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

import com.atrium.hibernate.Pais;

/**
 * A data access object (DAO) providing persistence and search support for Pais
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.atrium.hibernate.Pais
 * @author MyEclipse Persistence Tools
 */
@Repository("pais_dao")
@Scope("prototype")
public class PaisDAO {
	private static final Logger log = LoggerFactory.getLogger(PaisDAO.class);

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

	public void save(Pais transientInstance) {
		log.debug("saving Pais instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pais persistentInstance) {
		log.debug("deleting Pais instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pais findById(java.lang.Long id) {
		log.debug("getting Pais instance with id: " + id);
		try {
			Pais instance = (Pais) getCurrentSession().get(
					"com.atrium.hibernate.Pais", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Pais> findByExample(Pais instance) {
		log.debug("finding Pais instance by example");
		try {
			List<Pais> results = (List<Pais>) getCurrentSession()
					.createCriteria("com.atrium.hibernate.Pais")
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
		log.debug("finding Pais instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pais as model where model."
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
		log.debug("finding all Pais instances");
		try {
			String queryString = "from Pais";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pais merge(Pais detachedInstance) {
		log.debug("merging Pais instance");
		try {
			Pais result = (Pais) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pais instance) {
		log.debug("attaching dirty Pais instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pais instance) {
		log.debug("attaching clean Pais instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PaisDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PaisDAO) ctx.getBean("PaisDAO");
	}
}