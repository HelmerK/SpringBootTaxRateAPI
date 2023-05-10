package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.HelmerK.TaxRateAPI.entity.Location;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

/**
 * LocationDB class is used to support CRUD functionality on the location table
 * in the taxrate database.
 *
 */
public class LocationDAO {

	private EntityManager em;

	@Autowired
	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	/**
	 *
	 * @return A List of all Location objects from the database.
	 */
	public List<Location> getAll() {
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			List<Location> locations = em.createNamedQuery("Location.findAll", Location.class).getResultList();
			return locations;

		} finally {
			em.close();
		}

	}

	/**
	 *
	 * @param locationCode The string that represents a US ZipCode or Canada Postal
	 *                     Code
	 * @return A location object retrieved from the database.
	 */
	public Location getLoc(String locationCode) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();

		try {
			Location loc = em.find(Location.class, locationCode);
			return loc;
		} finally {
//            em.close();
        }
	}

	/**
	 *
	 * @param loc Location object that will be inserted into the Location table in
	 *            the taxratedb database
	 */
	public void insertLoc(Location loc) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		try {

			trans.begin();
			em.persist(loc);
			trans.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			trans.rollback();
		}finally {
//            em.close();
        }

	}

	/**
	 *
	 * @param loc Location object that will be updated in the Location table of the
	 *            taxratedb database.
	 */
	public void updateLoc(Location loc) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();
			em.merge(em.merge(loc));
			trans.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			trans.rollback();
		}finally {
//            em.close();
        }

	}

	/**
	 *
	 * @param loc Location object that will be removed from the Location table of
	 *            the taxratedb database.
	 */
	public void deleteLoc(Location loc) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();
			em.remove(em.merge(loc));
			trans.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			trans.rollback();

		}finally {
//            em.close();
        }

	}

}
