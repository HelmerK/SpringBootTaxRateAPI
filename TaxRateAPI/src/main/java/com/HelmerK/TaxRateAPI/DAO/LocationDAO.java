package com.HelmerK.TaxRateAPI.DAO;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HelmerK.TaxRateAPI.entity.Location;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;

/**
 * LocationDB class is used to support CRUD functionality on the location table
 * in the taxrate database.
 *
 */
@Repository
public class LocationDAO {

	@Autowired
	private EntityManager em;


	/**
	 *
	 * @return A List of all Location objects from the database.
	 */
	@Transactional
	public List<Location> getAll() {

		try {
			Session sesh = em.unwrap(Session.class);

			Query<Location> query = (Query) em.createQuery("from Location", Location.class);

			List<Location> locations = query.getResultList();
			
			return locations;

		} catch (Exception e) {
			
			System.out.println("Bad LOCATION GETALL");
			
			return null;
			
		}

	}

	/**
	 *
	 * @param locationCode The string that represents a US ZipCode or Canada Postal
	 *                     Code
	 * @return A location object retrieved from the database.
	 */
	@Transactional
	public Location getLoc(String locationCode) {

		try {
			
			Session sesh = em.unwrap(Session.class);
			
			Location loc = sesh.find(Location.class, locationCode);
			
			return loc;
			
		} catch (Exception e) {
			
			System.out.println("Bad LOCATION GET");
			
			return null;
			
		}
	}

	/**
	 *
	 * @param loc Location object that will be inserted into the Location table in
	 *            the taxratedb database
	 */
	@Transactional
	public void insertLoc(Location loc) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.persist(loc);

		} catch (Exception e) {
			
			System.out.println("Bad LOCATION INSERT");
			
		}

	}

	/**
	 *
	 * @param loc Location object that will be updated in the Location table of the
	 *            taxratedb database.
	 */
	@Transactional
	public void updateLoc(Location loc) {

		try {
			
			Session sesh = em.unwrap(Session.class);
			
			sesh.merge(loc);
			
		} catch (Exception e) {
			
			System.out.println("Bad LOCATION UPDATE");
			
		}

	}

	/**
	 *
	 * @param loc Location object that will be removed from the Location table of
	 *            the taxratedb database.
	 */
	@Transactional
	public void deleteLoc(Location loc) {

		try {
			
			Session sesh = em.unwrap(Session.class);
			
			sesh.remove(loc);
			
		} catch (Exception e) {
			
			System.out.println("Bad LOCATION DELETE");
			
		}

	}

}
