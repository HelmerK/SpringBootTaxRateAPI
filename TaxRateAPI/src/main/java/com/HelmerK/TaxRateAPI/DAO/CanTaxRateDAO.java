package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.HelmerK.TaxRateAPI.entity.CanTaxRate;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;

public class CanTaxRateDAO {

	@PersistenceContext
	private EntityManager em;

	public CanTaxRateDAO() {

	}

	/**
	 * 
	 * @return a List of CanadaTaxRate objects.
	 */
	public List<CanTaxRate> getAllCan() {

		try {
			Session sesh = em.unwrap(Session.class);

			Query<CanTaxRate> query = (Query) em.createQuery("from CanTaxRate", CanTaxRate.class);

			List<CanTaxRate> rates = query.getResultList();

			return rates;

		} catch (Exception e) {

			System.out.println("Bad CANTAX GETALL");

			return null;

		}
	}

	/**
	 * 
	 * @param locationCode location code string that represents a Canada Postal Code
	 * @return CanadaTaxRate object retrieved using the locationCode.
	 */
	public CanTaxRate getCan(String locationCode) {

		try {
			Session sesh = em.unwrap(Session.class);

			Query<CanTaxRate> query = (Query) em.createQuery("from CanTaxRate", CanTaxRate.class);

			CanTaxRate rate = query.getSingleResult();

			return rate;

		} catch (Exception e) {

			System.out.println("Bad CANTAX GET");

			return null;
		}

	}

	/**
	 * 
	 * @param canTaxRate A CanadaTaxRate object that will be inserted into the DB.
	 */
	public CanTaxRate insertCan(CanTaxRate canTaxRate) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.persist(canTaxRate);

			return canTaxRate;

		} catch (Exception e) {

			System.out.println("Bad CANTAX INSERT");

			return null;

		}

	}

	/**
	 * 
	 * @param canTaxRate The CanadaTaxRate that will be deleted from the DB.
	 */
	public void deleteCan(CanTaxRate canTaxRate) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.remove(canTaxRate);

		} catch (Exception e) {

			System.out.println("Bad CANTAX DELETE");

		}

	}

	/**
	 * 
	 * @param canTaxRate The CanadaTaxRate object that will be updated in the
	 *                   database.
	 */
	public void updateCan(CanTaxRate canTaxRate) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.merge(canTaxRate);

		} catch (Exception e) {

			System.out.println("Bad CANTAX UPDATE");

		}

	}

}
