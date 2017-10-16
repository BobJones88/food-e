package com.restTutorial.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.restTutorial.dao.GenericDao;

@Transactional
public abstract class HibernateDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> persistanceClass;
	
	public HibernateDaoImpl(final Class<T> persistanceClass) { this.persistanceClass = persistanceClass; }
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(persistanceClass).list();
	}
	
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		return (T) sessionFactory.getCurrentSession().get(persistanceClass, id);
	}
	
	public boolean exists(PK id){
		T entity = get(id);
		return entity != null;
	}
	
	@SuppressWarnings("unchecked")
	public T save(T entity) {
		return (T) sessionFactory.getCurrentSession().merge(entity);
	}
	
	public void remove(PK id) {
		sessionFactory.getCurrentSession().delete(this.get(id));
	}
	
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
}
