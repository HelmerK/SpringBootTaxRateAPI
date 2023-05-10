package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.HelmerK.TaxRateAPI.entity.Role;
import jakarta.persistence.EntityManager;

public class RoleDAO {

	private EntityManager em;

	@Autowired
	public RoleDAO(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public List<Role> getAll() {

		try {
		Session sesh = em.unwrap(Session.class);

		Query<Role> query = sesh.createQuery("from Role", Role.class);

		List<Role> roles = query.getResultList();

//		List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
		return roles;
		}catch(Exception e) {
			return null;
		}finally {
//            em.close();
        }
	}

	@Transactional
	public Role getRole(int roleId) {
		try {
			Role role = em.find(Role.class, roleId);
			return role;
		} catch (Exception e) {
			return null;
		} finally {
//    		em.close();
		}
	}
}
