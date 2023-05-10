package com.HelmerK.TaxRateAPI.DAO;

import java.util.List;

import org.hibernate.query.Query;

import com.HelmerK.TaxRateAPI.entity.Location;
import com.HelmerK.TaxRateAPI.entity.UsTaxRate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UsTaxRateDAO {

	private EntityManager em;
	
	public UsTaxRateDAO(EntityManager em) {
		this.em = em;
	}
	
	 public UsTaxRate getUs(String locationCode) {

//	        EntityManager em = DBUtil.getEmFactory().createEntityManager();

	        try {
	            Query queryCanLocCode = (Query) em.createNamedQuery("Location.findByLocationCode");
	            queryCanLocCode.setParameter("locationCode", locationCode);
	            Location Loc = (Location) queryCanLocCode.getSingleResult();

	            UsTaxRate usTaxRate = Loc.getUsTaxRateList().get(0);

	            return usTaxRate;

	        } finally {
//	            em.close();
	        }
	    }

	    public List<UsTaxRate> getAllUs() {

//	        EntityManager em = DBUtil.getEmFactory().createEntityManager();

	        try {

	            List<UsTaxRate> taxRates = em.createNamedQuery("UsTaxRate.findAll", UsTaxRate.class).getResultList();
	            return taxRates;

	        } finally {
//	            em.close();
	        }
	    }

	    public void insertUs(UsTaxRate usTaxRate) {

//	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction tran = em.getTransaction();

	        try {

	            LocationDAO locDB = new LocationDAO(em);
	            Location loc = locDB.getLoc(usTaxRate.getLocation().getLocationCode());

	            tran.begin();
	            em.merge(loc);
	            em.persist(usTaxRate);
	            tran.commit();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	            tran.rollback();
	        } finally {
//	            em.close();
	        }
	    }

	    public void deleteUs(UsTaxRate usTaxRate) {

//	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction tran = em.getTransaction();

	        try {
	            Location loc = usTaxRate.getLocation();
	            tran.begin();
	            loc.getUsTaxRateList().clear();
	            em.remove(em.merge(usTaxRate));
	            em.merge(loc);
	            tran.commit();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	            tran.rollback();
	        } finally {
//	            em.close();
	        }
	    }

	    public void updateUs(UsTaxRate usTaxRate) {

//	        EntityManager em = DBUtil.getEmFactory().createEntityManager();
	        EntityTransaction tran = em.getTransaction();

	        try {

	            tran.begin();
	            em.merge(usTaxRate);
	            tran.commit();

	        } catch (Exception ex) {
	            ex.printStackTrace();
	            tran.rollback();
	        } finally {
//	            em.close();
	        }
	    }
	
}
