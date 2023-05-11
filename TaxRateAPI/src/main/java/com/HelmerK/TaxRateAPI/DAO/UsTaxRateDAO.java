package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.HelmerK.TaxRateAPI.entity.UsTaxRate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UsTaxRateDAO {

	@PersistenceContext
	private EntityManager em;

	public UsTaxRateDAO() {

	}

	public List<UsTaxRate> getAllUs() {

		try {

			Session sesh = em.unwrap(Session.class);

			Query<UsTaxRate> query = (Query) em.createQuery("from UsTaxRate", UsTaxRate.class);

			List<UsTaxRate> taxRates = query.getResultList();

			return taxRates;

		} catch (Exception e) {

			return null;

		}
	}

	public UsTaxRate getUs(String locationCode) {

		try {

			Session sesh = em.unwrap(Session.class);

			Query<UsTaxRate> query = (Query) em.createQuery("from UsTaxRate", UsTaxRate.class);

			UsTaxRate usTaxRate = query.getSingleResult();

			return usTaxRate;

		} catch (Exception e) {

			return null;

		}
	}

	public void insertUs(UsTaxRate usTaxRate) {

		try {
			Session sesh = em.unwrap(Session.class);

			sesh.persist(usTaxRate);

		} catch (Exception e) {
			
			System.out.println("Bad US INSERT");
			
		}
	}

	public void deleteUs(UsTaxRate usTaxRate) {

		try {
			Session sesh = em.unwrap(Session.class);

			sesh.remove(usTaxRate);

		} catch (Exception e) {
			
			System.out.println("Bad US DELETE");
			
		}
	}

	public void updateUs(UsTaxRate usTaxRate) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.merge(usTaxRate);

		} catch (Exception e) {
			
			System.out.println("Bad US UPDATE");
			
		}
	}

}
