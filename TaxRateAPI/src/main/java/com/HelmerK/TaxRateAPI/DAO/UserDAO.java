package com.HelmerK.TaxRateAPI.DAO;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.HelmerK.TaxRateAPI.entity.Role;
import com.HelmerK.TaxRateAPI.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;

	
	public UserDAO() {
		
	}
	
	/**
     * Retrieves the User object associated with the given username.
     *
     * @param username The string representing the username of the User.
     * @return The User object associated with the provided username, or null if
     * not found.
     * @throws Exception If any exception occurs during the database operation.
     */
	@Transactional
	public User getUser(String username) {

		try {
			Session sesh = em.unwrap(Session.class);
			
			Query<User> query = sesh.createQuery("from User", User.class);
			
			User user = (User) query.getSingleResult();
			
			return user;

		} catch (NoResultException e) {
			
			System.out.println("User not found");
			
			return null;
			
		}

	}
	/**
     * Retrieves all User objects from the database.
     *
     * @return A list of all User objects stored in the database.
     * @throws Exception If any exception occurs during the database operation.
     */
	@Transactional()
	public List<User> getAll() {

		try {
			
		Session sesh = em.unwrap(Session.class);

		Query<User> query = sesh.createQuery("from User", User.class);

		List<User> roles = query.getResultList();

		return roles;
		
		}catch(Exception e) {
			
			return null;
			
		}
	}


   
}
