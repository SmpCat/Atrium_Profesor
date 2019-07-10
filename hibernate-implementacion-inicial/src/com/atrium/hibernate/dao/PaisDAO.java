package com.atrium.hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class PaisDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PaisDAO.class);
	// property constants
	public static final String PAIS_ISONUM = "paisIsonum";
	public static final String PAIS_ISO2 = "paisIso2";
	public static final String PAIS_ISO3 = "paisIso3";
	public static final String PAIS_NOMBRE = "paisNombre";

	public void save(Pais transientInstance) {
		log.debug("saving Pais instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pais persistentInstance) {
		log.debug("deleting Pais instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pais findById(java.lang.Long id) {
		log.debug("getting Pais instance with id: " + id);
		try {
			Pais instance = (Pais) getSession().get(
					"com.atrium.hibernate.Pais", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Pais instance) {
		log.debug("finding Pais instance by example");
		try {
			List results = getSession()
					.createCriteria("com.atrium.hibernate.Pais")
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
		log.debug("finding Pais instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pais as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPaisIsonum(Object paisIsonum) {
		return findByProperty(PAIS_ISONUM, paisIsonum);
	}

	public List findByPaisIso2(Object paisIso2) {
		return findByProperty(PAIS_ISO2, paisIso2);
	}

	public List findByPaisIso3(Object paisIso3) {
		return findByProperty(PAIS_ISO3, paisIso3);
	}

	public List findByPaisNombre(Object paisNombre) {
		return findByProperty(PAIS_NOMBRE, paisNombre);
	}

	public List findAll() {
		log.debug("finding all Pais instances");
		try {
			String queryString = "from Pais";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pais merge(Pais detachedInstance) {
		log.debug("merging Pais instance");
		try {
			Pais result = (Pais) getSession().merge(detachedInstance);
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
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pais instance) {
		log.debug("attaching clean Pais instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}