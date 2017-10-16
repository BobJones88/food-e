package com.restTutorial.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restTutorial.dao.RecipeDao;
import com.restTutorial.models.Recipe;
import com.restTutorial.services.RecipeManager;

@Service("recipeManager")
@Transactional
public class RecipeManagerImpl extends GenericManagerImpl<Recipe, Long> implements RecipeManager {

	private RecipeDao recipeDao;
	
	@Autowired
	public RecipeManagerImpl(RecipeDao dao) {
		super(dao);
		this.recipeDao = dao;
	}

	public Recipe getRecipeById(Long id) {
		return recipeDao.get(id);
	}
	
	public List<Recipe> searchForRecipeByName(String name) {
		return recipeDao.searchForRecipeByName(name);
	}
}
