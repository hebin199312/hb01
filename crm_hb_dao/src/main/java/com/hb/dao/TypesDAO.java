package com.hb.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hb.entity.Types;

/**
 * A data access object (DAO) providing persistence and search support for Types
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.hb.entity.Types
 * @author MyEclipse Persistence Tools
 */

public class TypesDAO extends HibernateDaoSupport implements ITypesDAO {
	private static final Logger log = LoggerFactory.getLogger(TypesDAO.class);
	// property constants
	public static final String TNAME = "tname";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#save(com.hb.entity.Types)
	 */
	public void save(Types transientInstance) {
		log.debug("saving Types instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#delete(com.hb.entity.Types)
	 */
	public void delete(Types persistentInstance) {
		log.debug("deleting Types instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#findById(java.lang.Integer)
	 */
	public Types findById(java.lang.Integer id) {
		log.debug("getting Types instance with id: " + id);
		try {
			Types instance = (Types) getHibernateTemplate().get(
					"com.hb.entity.Types", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#findByExample(com.hb.entity.Types)
	 */
	public List findByExample(Types instance) {
		log.debug("finding Types instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Types instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Types as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#findByTname(java.lang.Object)
	 */
	public List findByTname(Object tname) {
		return findByProperty(TNAME, tname);
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Types instances");
		try {
			String queryString = "from Types";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#merge(com.hb.entity.Types)
	 */
	public Types merge(Types detachedInstance) {
		log.debug("merging Types instance");
		try {
			Types result = (Types) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#attachDirty(com.hb.entity.Types)
	 */
	public void attachDirty(Types instance) {
		log.debug("attaching dirty Types instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.hb.dao.ITypesDAO#attachClean(com.hb.entity.Types)
	 */
	public void attachClean(Types instance) {
		log.debug("attaching clean Types instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ITypesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ITypesDAO) ctx.getBean("TypesDAO");
	}
}