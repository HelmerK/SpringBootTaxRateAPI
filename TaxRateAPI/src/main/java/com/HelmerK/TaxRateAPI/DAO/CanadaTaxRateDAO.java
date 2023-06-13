package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.HelmerK.TaxRateAPI.entity.CanadaTaxRate;

import jakarta.persistence.EntityManager;

@Repository
public class CanadaTaxRateDAO {

	@Autowired
	private EntityManager em;

	/**
	 * 
	 * @return a List of CanadaTaxRate objects.
	 */

	public List<CanadaTaxRate> getAllCan() {

		try {

			Session sesh = em.unwrap(Session.class);

			Query<CanadaTaxRate> query = sesh.createQuery("from CanadaTaxRate", CanadaTaxRate.class);

			List<CanadaTaxRate> rates = query.getResultList();

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
	@Transactional
	public CanadaTaxRate getCan(String locationCode) {

		try {

			Session sesh = em.unwrap(Session.class);

			CanadaTaxRate rate = sesh.find(CanadaTaxRate.class, locationCode);

			return rate;

		} catch (Exception e) {

			System.out.println("Bad CANTAX GET");

			return null;
		}

	}

	/**
	 * 
	 * @param CanadaTaxRate A CanadaTaxRate object that will be inserted into the
	 *                      DB.
	 */
	@Transactional
	public CanadaTaxRate insertCan(CanadaTaxRate CanadaTaxRate) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.persist(CanadaTaxRate);

			return CanadaTaxRate;

		} catch (Exception e) {

			System.out.println("Bad CANTAX INSERT");

			return null;

		}

	}

	/**
	 * 
	 * @param CanadaTaxRate The CanadaTaxRate that will be deleted from the DB.
	 */
	@Transactional
	public void deleteCan(CanadaTaxRate CanadaTaxRate) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.remove(CanadaTaxRate);

		} catch (Exception e) {

			System.out.println("Bad CANTAX DELETE");

		}

	}

	/**
	 * 
	 * @param CanadaTaxRate The CanadaTaxRate object that will be updated in the
	 *                      database.
	 */
	@Transactional
	public void updateCan(CanadaTaxRate CanadaTaxRate) {

		try {

			Session sesh = em.unwrap(Session.class);

			sesh.merge(CanadaTaxRate);

		} catch (Exception e) {

			System.out.println("Bad CANTAX UPDATE");

		}

	}

	@Transactional
	public boolean vaildCode(String locationCode) {
		boolean result = false;

		try {
			Session sesh = em.unwrap(Session.class);

			CanadaTaxRate rate = sesh.find(CanadaTaxRate.class, locationCode);
			if (rate == null) {
				return result;
			} else {
				result = true;
				return result;

			}

		} catch (Exception e) {

			return false;
		}

	}

}
