package com.restTutorial.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.restTutorial.dao.GenericDao;
import com.restTutorial.services.GenericManager;

@Transactional
public class GenericManagerImpl<T, PK extends Serializable> implements GenericManager<T, PK> {
	
	protected GenericDao<T, PK> dao;
	
	public GenericManagerImpl(final GenericDao<T, PK> genericDao) { this.dao = genericDao; }
	
	public List<T> getAll() {
		return dao.getAll();
	}
	
	public T get(PK id) {
		return dao.get(id);
	}
	
	public boolean exists(PK id) {
		return dao.exists(id);
	}
	
	public T save(T entity) {
		return dao.save(entity);
	}
	
	public void remove(PK id) {
		dao.remove(id);
	}
}
