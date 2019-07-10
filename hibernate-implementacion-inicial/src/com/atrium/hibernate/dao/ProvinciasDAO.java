package com.atrium.hibernate.dao;

import com.atrium.hibernate.Provincias;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Provincias entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.atrium.hibernate.Provincias
  * @author MyEclipse Persistence Tools 
 */
public class ProvinciasDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ProvinciasDAO.class);
		//property constants
	public static final String PROVINCIA = "provincia";



    
    public void save(Provincias transientInstance) {
        log.debug("saving Provincias instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Provincias persistentInstance) {
        log.debug("deleting Provincias instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Provincias findById( java.lang.Byte id) {
        log.debug("getting Provincias instance with id: " + id);
        try {
            Provincias instance = (Provincias) getSession()
                    .get("com.atrium.hibernate.Provincias", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Provincias instance) {
        log.debug("finding Provincias instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.atrium.hibernate.Provincias")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
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
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByProvincia(Object provincia
	) {
		return findByProperty(PROVINCIA, provincia
		);
	}
	

	public List findAll() {
		log.debug("finding all Provincias instances");
		try {
			String queryString = "from Provincias";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Provincias merge(Provincias detachedInstance) {
        log.debug("merging Provincias instance");
        try {
            Provincias result = (Provincias) getSession()
                    .merge(detachedInstance);
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
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Provincias instance) {
        log.debug("attaching clean Provincias instance");
        try {
                      	getSession().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}