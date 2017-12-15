package dorm.system.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dorm.system.dao.BaseDao;

@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	
	// 获得当前事物的session	
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	
	public void save(T t) {
		if(t!=null) {
			this.getCurrentSession().save(t);
		}
	}

	public void delete(T t) {
		if(t!=null) {
			this.getCurrentSession().delete(t);
		}
	}

	public void update(T t) {
		if(t!=null) {
			this.getCurrentSession().update(t);
		}
	}

	public T get(Class<T> c, Serializable id) {

		return (T) this.getCurrentSession().get(c,id);
	}

	public T get(String hql) {
		Query q=this.getCurrentSession().createQuery(hql);
		List<T> tList= q.list();
		if (tList != null && tList.size() > 0) {
			return tList.get(0);
		}
		return null;
	}

	public T get(String hql, Map<String, Object> params) {
		Query q=this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> tList = q.list();
		if (tList != null && tList.size() > 0) {
			return tList.get(0);
		}
		return null;
	}

	public List<T> find(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	public List<T> find(String hql, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

}
