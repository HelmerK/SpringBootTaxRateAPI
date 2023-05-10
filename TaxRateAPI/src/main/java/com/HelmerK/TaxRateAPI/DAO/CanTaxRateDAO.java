package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.HelmerK.TaxRateAPI.entity.CanTaxRate;
import com.HelmerK.TaxRateAPI.entity.Location;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CanTaxRateDAO {

	private EntityManager em;

	@Autowired
	public CanTaxRateDAO(EntityManager em) {
		this.em = em;
	}

	/**
     * 
     * @param locationCode location code string that represents a Canada Postal Code
     * @return CanadaTaxRate object retrieved using the locationCode.
     */
    public CanTaxRate getCan(String locationCode) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            Query queryCanLocCode = (Query) em.createNamedQuery("Location.findByLocationCode");
            queryCanLocCode.setParameter("locationCode", locationCode);
            Location Loc = (Location) queryCanLocCode.getSingleResult();

            CanTaxRate canTaxRate = Loc.getCanadaTaxRateList().get(0);
            return canTaxRate;
        }finally {
//            em.close();
        }

        
    }

	/**
     * 
     * @return a List of CanadaTaxRate objects.
     */
    public List<CanTaxRate> getAllCan() {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try{

            List<CanTaxRate> taxRates = em.createNamedQuery("CanadaTaxRate.findAll", CanTaxRate.class).getResultList();
            return taxRates;
        }finally {
//            em.close();
        }
        
    }

	/**
	 * 
	 * @param canTaxRate A CanadaTaxRate object that will be inserted into the DB.
	 */
	public void insertCan(CanTaxRate canTaxRate) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {

			LocationDAO locDB = new LocationDAO(em);
			Location loc = locDB.getLoc(canTaxRate.getLocation().getLocationCode());

			tran.begin();
			em.merge(loc);
			em.persist(canTaxRate);
			tran.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			tran.rollback();
		}finally {
//            em.close();
        }
	}

	/**
	 * 
	 * @param canTaxRate The CanadaTaxRate that will be deleted from the DB.
	 */
	public void deleteCan(CanTaxRate canTaxRate) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			Location loc = canTaxRate.getLocation();
			tran.begin();
			loc.getCanadaTaxRateList().clear();
			em.remove(em.merge(canTaxRate));
			em.merge(loc);
			tran.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			tran.rollback();
		}finally {
//            em.close();
        }
	}

	/**
	 * 
	 * @param canTaxRate The CanadaTaxRate object that will be updated in the
	 *                   database.
	 */
	public void updateCan(CanTaxRate canTaxRate) {

//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {

			tran.begin();
			em.merge(canTaxRate);
			tran.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			tran.rollback();
		}finally {
//            em.close();
        }
	}

}
