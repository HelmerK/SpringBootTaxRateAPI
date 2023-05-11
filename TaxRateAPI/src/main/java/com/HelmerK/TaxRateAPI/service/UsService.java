package com.HelmerK.TaxRateAPI.service;

import com.HelmerK.TaxRateAPI.DAO.LocationDAO;
import com.HelmerK.TaxRateAPI.DAO.UsTaxRateDAO;
import com.HelmerK.TaxRateAPI.entity.Location;
import com.HelmerK.TaxRateAPI.entity.UsTaxRate;

public class UsService {

	private UsTaxRateDAO usDAO = new UsTaxRateDAO();
	private LocationDAO locDAO = new LocationDAO();

	public UsTaxRate getUs(String locationCode) {

		UsTaxRate rate = usDAO.getUs(locationCode);

		return rate;

	}

	public void insertUs(String country, String region, String locationCode, String stateTax) {

		double parseStateTax = Double.parseDouble(stateTax);

		Location newLoc = new Location(locationCode, country, region);
		locDAO.insertLoc(newLoc);

		UsTaxRate newRate = new UsTaxRate(0, parseStateTax);
		newRate.setLocation(newLoc);

		newLoc.getUsTaxRateList().add(newRate);

		locDAO.insertLoc(newLoc);
		usDAO.insertUs(newRate);

	}

	public void deleteUs(String locationCode) {

		UsTaxRate rate = usDAO.getUs(locationCode);
		Location loc = locDAO.getLoc(locationCode);

		usDAO.deleteUs(rate);

		locDAO.deleteLoc(loc);

	}

	public void updateUs(String country, String region, String locationCode, String stateTax) {

		double parseStateTax = Double.parseDouble(stateTax);

		Location loc = locDAO.getLoc(locationCode);
		UsTaxRate rate = usDAO.getUs(locationCode);

		loc.getUsTaxRateList().clear();
		loc.setCountry(country);
		loc.setRegion(region);

		rate.setStateTax(parseStateTax);
		rate.setLocation(loc);

		loc.getUsTaxRateList().add(rate);
		
		locDAO.updateLoc(loc);
		usDAO.updateUs(rate);

	}
}
