package com.restTutorial.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.restTutorial.dao.UserDao;
import com.restTutorial.models.User;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoImpl<User, Long> implements UserDao {

	
	public UserDaoImpl() { super(User.class); }

	@SuppressWarnings("unchecked")
	public List<User> searchForUserByName(String name) {
		Session session = getSessionFactory().getCurrentSession();
		
		String userQuery = "FROM User u WHERE (u.firstName LIKE :firstName OR u.lastName LIKE :lastName)";
		Query query = session.createQuery(userQuery);
		query.setString("firstName", "%"+name+"%");
		query.setString("lastName", "%"+name+"%");
		List<User> usersResult = query.list();
		
		return usersResult;
		
	}
	
}
