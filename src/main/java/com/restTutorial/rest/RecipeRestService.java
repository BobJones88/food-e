package com.restTutorial.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restTutorial.models.Recipe;
import com.restTutorial.services.RecipeManager;

@Component
@Path("/recipe")
public class RecipeRestService {

	@Autowired
	private RecipeManager recipeManager;
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getRecipe(@PathParam("id") Long id){
		
		Recipe mockRecipe = recipeManager.get(id);
		
		if(mockRecipe == null) {
			return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Resource not found for id="+id).build();
		}

		return Response.ok(mockRecipe).build();
	
	}
	
	@GET
	@Path("/search")
	@Produces("application/json")
	public Response searchForRecipes(@QueryParam("filter") String filter){
		List<Recipe> recipe = recipeManager.searchForRecipeByName(filter);
		return Response.ok(recipe).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response createRecipe(Recipe recipe){
		if(recipe == null){
			return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity("Post contained no body").build();
		}
		
		recipe = recipeManager.save(recipe);
		return Response.ok(recipe).build();
	}
	
	@POST
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response modifyUser(@PathParam("id") Long recipeId, Recipe recipe){
		if(recipe == null){
			return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity("Post contained no body").build();
		}
		
		Recipe dbRecipe = recipeManager.get(recipeId);
		
		if(dbRecipe == null){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		dbRecipe.setRecipeName(recipe.getRecipeName());
		
		recipeManager.save(dbRecipe);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response deleteUser(@PathParam("id") Long id){
		if(!recipeManager.exists(id)){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		recipeManager.remove(id);
		return Response.noContent().build();
	}
}
