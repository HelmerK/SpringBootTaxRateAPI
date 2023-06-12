package com.HelmerK.TaxRateAPI.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.HelmerK.TaxRateAPI.DAO.LocationDAO;
import com.HelmerK.TaxRateAPI.DAO.UsTaxRateDAO;
import com.HelmerK.TaxRateAPI.entity.Location;
import com.HelmerK.TaxRateAPI.entity.UsTaxRate;

@Service
public class UsService {

	@Autowired
	private UsTaxRateDAO usDAO;
	@Autowired
	private LocationDAO locDAO;
	
	public UsTaxRate getUs(String locationCode) {

		UsTaxRate rate = usDAO.getUs(locationCode);

		return rate;

	}

//	public void insertUs(UsTaxRate rate) {
//
//		Location newLoc = new Location(rate.getLocation().getLocationCode(), rate.getLocation().getCountry(),
//				rate.getLocation().getRegion());
//		locDAO.insertLoc(newLoc);
//
//		rate.setLocation(newLoc);
//
//		newLoc.setUsTaxRate(rate);
//
//		locDAO.insertLoc(newLoc);
//		usDAO.insertUs(rate);
//
//	}

	public void deleteUs(UsTaxRate rate) {

		usDAO.deleteUs(rate);

	}

//	public void updateUs(UsTaxRate rate) {
//
//		Location loc = locDAO.getLoc(rate.getLocation().getLocationCode());
//		UsTaxRate updated = usDAO.getUs(rate.getLocation().getLocationCode());
//
//		
//		loc.setCountry(rate.getLocation().getCountry());
//		loc.setRegion(rate.getLocation().getRegion());
//		
//		updated.setStateTax(rate.getStateTax());
//		
//		updated.setLocation(loc);
//		loc.setUsTaxRate(rate);
//		
//
//		locDAO.updateLoc(loc);
//		usDAO.updateUs(rate);
//
//	}

}
