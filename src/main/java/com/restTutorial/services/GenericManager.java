package com.restTutorial.services;

import java.io.Serializable;
import java.util.List;

public interface GenericManager<T, PK extends Serializable> {
	List<T> getAll();
	T get(PK id);
	boolean exists(PK id);
	T save(T entity);
	void remove(PK id);
}