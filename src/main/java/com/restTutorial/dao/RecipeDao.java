package com.restTutorial.dao;

import java.util.List;

import com.restTutorial.models.Recipe;

public interface RecipeDao extends GenericDao<Recipe, Long>{
	List<Recipe> searchForRecipeByName(String name);
}
