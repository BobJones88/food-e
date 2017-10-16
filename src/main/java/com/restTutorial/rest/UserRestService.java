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

import com.restTutorial.models.User;
import com.restTutorial.services.UserManager;

@Component
@Path("/users")
public class UserRestService {

	@Autowired
	private UserManager userManager;
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getUser(@PathParam("id") Long id){
		
		User mockUser = userManager.get(id);
		
		if(mockUser == null) {
			return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_PLAIN).entity("Resource not found for id="+id).build();
		}

		return Response.ok(mockUser).build();
	
	}
	
	@GET
	@Path("/search")
	@Produces("application/json")
	public Response searchForUsers(@QueryParam("filter") String filter){
		List<User> users = userManager.searchForUserByName(filter);
		return Response.ok(users).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response createUser(User user){
		if(user == null){
			return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity("Post contained no body").build();
		}
		
		user = userManager.save(user);
		return Response.ok(user).build();
	}
	
	@POST
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response modifyUser(@PathParam("id") Long userId, User user){
		if(user == null){
			return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_PLAIN).entity("Post contained no body").build();
		}
		
		User dbUser = userManager.get(userId);
		
		if(dbUser == null){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		dbUser.setFirstName(user.getFirstName());
		dbUser.setLastName(user.getLastName());
		dbUser.setUserName(user.getLastName());
		
		userManager.save(dbUser);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response deleteUser(@PathParam("id") Long id){
		if(!userManager.exists(id)){
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		userManager.remove(id);
		return Response.noContent().build();
	}
}
