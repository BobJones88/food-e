package com.restTutorial.services;

import java.util.List;

import com.restTutorial.models.Recipe;

public interface RecipeManager extends GenericManager<Recipe, Long> {
	Recipe getRecipeById(Long id);
	List<Recipe> searchForRecipeByName(String name);
}