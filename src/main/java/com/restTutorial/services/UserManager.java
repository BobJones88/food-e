package com.restTutorial.services;

import java.util.List;

import com.restTutorial.models.User;

public interface UserManager extends GenericManager<User, Long> {
	User getUserById(Long id);
	List<User> searchForUserByName(String name);
}