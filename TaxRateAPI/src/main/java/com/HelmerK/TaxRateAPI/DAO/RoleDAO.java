package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HelmerK.TaxRateAPI.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RoleDAO {

	@Autowired
	private EntityManager em;

	@Transactional
	public List<Role> getAll() {

		try {
			Session sesh = em.unwrap(Session.class);

			Query<Role> query = sesh.createQuery("from Role", Role.class);

			List<Role> roles = query.getResultList();

			return roles;
			
		} catch (Exception e) {
			
			System.out.println("Bad ROLE GETALL");
			
			return null;
			
		}
	}

	@Transactional
	public Role getRole(int roleId) {
		try {
			
			Session sesh = em.unwrap(Session.class);
			
			Query<Role> query = (Query) em.createQuery("from Role", Role.class);
			
			Role role = query.getSingleResult();
			
			return role;
			
		} catch (Exception e) {
			
			System.out.println("Bad ROLE GET");
			
			return null;
			
		}
	}
}
