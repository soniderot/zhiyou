package com.zy.common.db;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zy.common.util.LogUtil;

public class HibernateDao<T extends Serializable, PK extends Serializable> extends HibernateDaoSupport implements BaseDao<T, PK> {

	private Class<T> entityClass;

	public HibernateDao() {
		this.entityClass = null;
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
	}

	public T get(PK id) {
		try {
			return (T) getHibernateTemplate().get(entityClass, id);
		} catch (ObjectNotFoundException e) {
			LogUtil.error(e);
			return null;
		}
	}

	public T getWithLock(PK id, LockMode lock) {
		T t = (T) getHibernateTemplate().get(entityClass, id, lock);
		if (t != null) {
			this.flush();
		}
		return t;
	}

	public T load(PK id) {
		//return get(id);
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	public T loadWithLock(PK id, LockMode lock) {
		T t = (T) getHibernateTemplate().load(entityClass, id, lock);
		if (t != null) {
			this.flush();
		}
		return t;
	}

	public List<T> loadAll() {
		return (List<T>) getHibernateTemplate().loadAll(entityClass);
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public T merge(T entity) {
		return (T)getHibernateTemplate().merge(entity);
	}

	public void updateWithLock(T entity, LockMode lock) {
		getHibernateTemplate().update(entity, lock);
		this.flush();
	}

	public Serializable saveback(T entity) {
		return getHibernateTemplate().save(entity);
	}
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<T> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	public void deleteWithLock(T entity, LockMode lock) {
		getHibernateTemplate().delete(entity, lock);
		this.flush();
	}

	public void deleteByKey(PK id) {
		this.delete(this.load(id));
	}

	public void deleteByKeyWithLock(PK id, LockMode lock) {
		this.deleteWithLock(this.load(id), lock);
	}

	public void deleteAll(Collection<T> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	public int bulkUpdate(String queryString) {
		return getHibernateTemplate().bulkUpdate(queryString);
	}

	public int bulkUpdate(String queryString, Object[] values) {
		return getHibernateTemplate().bulkUpdate(queryString, values);
	}

	public List<T> find(String queryString) {
		this.getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().find(queryString);
	}
	
	public List<T> find(String queryString,Object value) {
		this.getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().find(queryString,value);
	}

	public List<T> find(String queryString, Object[] values) {
		this.getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().find(queryString, values);
	}

	public List findByNamedParam(String queryString, String[] paramNames, Object[] values) {
		return getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	public List findByNamedQuery(String queryName) {
		return getHibernateTemplate().findByNamedQuery(queryName);
	}

	public List findByNamedQuery(String queryName, Object[] values) {
		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public List findByNamedQueryAndNamedParam(String queryName, String[] paramNames, Object[] values) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramNames, values);
	}

	public Iterator iterate(String queryString) {
		return getHibernateTemplate().iterate(queryString);
	}

	public Iterator iterate(String queryString, Object[] values) {
		return getHibernateTemplate().iterate(queryString, values);
	}

	public void closeIterator(Iterator it) {
		getHibernateTemplate().closeIterator(it);
	}

	public DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(this.entityClass);
	}

	public Criteria createCriteria() {
		return this.createDetachedCriteria().getExecutableCriteria(this.getSession());
	}

	public List findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public List findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	public List<T> findEqualByEntity(T entity, String[] propertyNames) {
		Criteria criteria = this.createCriteria();
		Example exam = Example.create(entity);
		exam.excludeZeroes();
		String[] defPropertys = getSessionFactory().getClassMetadata(entityClass).getPropertyNames();
		for (String defProperty : defPropertys) {
			int ii = 0;
			for (ii = 0; ii < propertyNames.length; ++ii) {
				if (defProperty.equals(propertyNames[ii])) {
					criteria.addOrder(Order.asc(defProperty));
					break;
				}
			}
			if (ii == propertyNames.length) {
				exam.excludeProperty(defProperty);
			}
		}
		criteria.add(exam);
		return (List<T>) criteria.list();
	}

	public List<T> findLikeByEntity(T entity, String[] propertyNames) {
		Criteria criteria = this.createCriteria();
		for (String property : propertyNames) {
			try {
				Object value = PropertyUtils.getProperty(entity, property);
				if (value instanceof String) {
					criteria.add(Restrictions.like(property, (String) value, MatchMode.ANYWHERE));
					criteria.addOrder(Order.asc(property));
				} else {
					criteria.add(Restrictions.eq(property, value));
					criteria.addOrder(Order.asc(property));
				}
			} catch (Exception ex) {
			}
		}
		return (List<T>) criteria.list();
	}

	public Integer getRowCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List list = this.findByCriteria(criteria, 0, 1);
		return (Integer) list.get(0);
	}

	public Object getStatValue(DetachedCriteria criteria, String propertyName, String StatName) {
		if (StatName.toLowerCase().equals("max"))
			criteria.setProjection(Projections.max(propertyName));
		else if (StatName.toLowerCase().equals("min"))
			criteria.setProjection(Projections.min(propertyName));
		else if (StatName.toLowerCase().equals("avg"))
			criteria.setProjection(Projections.avg(propertyName));
		else if (StatName.toLowerCase().equals("sum"))
			criteria.setProjection(Projections.sum(propertyName));
		else
			return null;
		List list = this.findByCriteria(criteria, 0, 1);
		return list.get(0);
	}

	public void lock(T entity, LockMode lock) {
		getHibernateTemplate().lock(entity, lock);
	}

	public void initialize(Object proxy) {
		getHibernateTemplate().initialize(proxy);
	}

	public void flush() {
		getHibernateTemplate().flush();
	}

	/**
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	protected List<T> loadByPagenation(String hql, int pageNo, int pageSize, Object... paras) {
		if (pageSize <= 0)
			pageSize = 10;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		query.setCacheable(true);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}
	/**
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	public List loadByPagenationf(String hql, int pageNo, int pageSize, Object... paras) {
		if (pageSize <= 0)
			pageSize = 10;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}
	/**
	 * this method is suit for the special hql which return Object[] and others.
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param paras
	 * @return
	 */
	protected List loadByPage(String hql, int pageNo, int pageSize, Object... paras) {
		if (pageSize <= 0)
			pageSize = 10;
		if (pageNo <= 0) {
			pageNo = 1;
		}
		int start = (pageNo - 1) * pageSize;
		Query query = createQuery(hql, paras);
		return query.setFirstResult(start).setMaxResults(pageSize).list();
	}

	/**
	 * get top records
	 * 
	 * @param hql
	 * @param limitNum
	 * @param paras
	 * @return
	 */
	protected List<T> loadTopRows(String hql, int limitNum, Object... paras) {
		Query query = createQuery(hql, paras);
		return query.setFirstResult(0).setMaxResults(limitNum).list();
	}

	protected int getTotalRows(String hql, Object... paras) {
		List<?> countlist =null;
		
		getHibernateTemplate().setCacheQueries(true);
		countlist=getHibernateTemplate().find(hql, paras);
		
		 
		if (countlist == null || countlist.isEmpty())
			return 0;
		return ((Long) countlist.get(0)).intValue();
	}

	private Query createQuery(String hql, Object... values) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
}