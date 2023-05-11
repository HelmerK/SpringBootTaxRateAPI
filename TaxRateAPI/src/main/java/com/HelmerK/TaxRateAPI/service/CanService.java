package com.HelmerK.TaxRateAPI.service;

import com.HelmerK.TaxRateAPI.DAO.CanTaxRateDAO;
import com.HelmerK.TaxRateAPI.DAO.LocationDAO;
import com.HelmerK.TaxRateAPI.entity.CanTaxRate;
import com.HelmerK.TaxRateAPI.entity.Location;

public class CanService {

	private CanTaxRateDAO canDAO = new CanTaxRateDAO();
	private LocationDAO locDAO = new LocationDAO();

	private Utilites util = new Utilites();

	public CanTaxRate getCan(String locationCode) {

		String cleanCode = util.formatLocationCode(locationCode);

		return canDAO.getCan(cleanCode);

	}

	public void insertCan(String country, String region, String locationCode, String gst, String pst, String hst) {

		double parseGst = Double.parseDouble(gst);
		double parseHst = Double.parseDouble(hst);
		double parsePst = Double.parseDouble(pst);

		Location newLoc = new Location(locationCode, country, region);

		locDAO.insertLoc(newLoc);

		CanTaxRate rate = new CanTaxRate(0, parseGst, parsePst, parseHst);
		rate.setLocation(newLoc);
		newLoc.getCanadaTaxRateList().add(rate);

		locDAO.updateLoc(newLoc);
		canDAO.insertCan(rate);

	}

	public void deleteCan(String locationCode) {
		CanTaxRate rate = canDAO.getCan(locationCode);

		canDAO.deleteCan(rate);

	}

	public void updateCan(String country, String region, String locationCode, String gst, String pst, String hst) {

		double parseGst = Double.parseDouble(gst);
		double parseHst = Double.parseDouble(hst);
		double parsePst = Double.parseDouble(pst);

		CanTaxRate rate = canDAO.getCan(locationCode);
		Location loc = locDAO.getLoc(locationCode);

		loc.setCountry(country);
		loc.setRegion(region);

		rate.setGst(parseGst);
		rate.setPst(parsePst);
		rate.setHst(parseHst);

		loc.getCanadaTaxRateList().clear();
		loc.getCanadaTaxRateList().add(rate);

		locDAO.updateLoc(loc);
		canDAO.updateCan(rate);

	}

}
