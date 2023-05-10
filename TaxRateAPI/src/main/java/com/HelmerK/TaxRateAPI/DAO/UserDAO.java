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

public class UserDAO {

	private EntityManager em;

	@Autowired
	public UserDAO(EntityManager em) {
		this.em = em;
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
			Query<?> userQuery = (Query<?>) em.createNamedQuery("User.findByUsername");
			userQuery.setParameter("username", username);
			User user = (User) userQuery.getSingleResult();
			return user;

		} catch (NoResultException e) {
			System.out.println("User not found");
			return null;
		}finally {
//            em.close();
        }

	}
	/**
     * Retrieves all User objects from the database.
     *
     * @return A list of all User objects stored in the database.
     * @throws Exception If any exception occurs during the database operation.
     */
	@Transactional
	public List<User> getAll() {

		try {
		Session sesh = em.unwrap(Session.class);

		Query<User> query = sesh.createQuery("from User", User.class);

		List<User> roles = query.getResultList();

		return roles;
		
		}catch(Exception e) {
			return null;
		}finally {
//            em.close();
        }
	}

	
	/**
     * Inserts a new User object into the database.
     *
     * @param user The User object to be inserted.
     * @throws Exception If any exception occurs during the database operation.
     */
	@Transactional
    public void insert(User user) throws Exception {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();

        try {

            Role role = user.getRoleId();
            role.getUserList().add(user);

            tran.begin();
            em.persist(user);
            em.merge(role);
            tran.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            tran.rollback();
        }finally {
//            em.close();
        }
    }

    /**
     * Deletes the given User object from the database.
     *
     * @param user The User object to be deleted.
     * @throws Exception If any exception occurs during the database operation.
     */
	@Transactional
    public void delete(User user) throws Exception {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();

        try {

            Role role = user.getRoleId();
            role.getUserList().remove(user);

            tran.begin();
            em.remove(em.merge(user));
            em.merge(role);
            tran.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            tran.rollback();
        }finally {
//            em.close();
        }
    }

    /**
     * Updates the given User object in the database.
     *
     * @param user The User object containing the updated information.
     * @throws Exception If any exception occurs during the database operation.
     */
	@Transactional
    public void update(User user) throws Exception {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction tran = em.getTransaction();

        try {

            tran.begin();
            em.merge(user);
            tran.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            tran.rollback();
        } finally {
//            em.close();
        }
    }
}
