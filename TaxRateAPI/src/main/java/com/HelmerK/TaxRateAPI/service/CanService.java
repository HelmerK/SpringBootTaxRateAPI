package com.HelmerK.TaxRateAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HelmerK.TaxRateAPI.DAO.CanadaTaxRateDAO;
import com.HelmerK.TaxRateAPI.DAO.LocationDAO;
import com.HelmerK.TaxRateAPI.DTO.CanadaTaxRateDTO;
import com.HelmerK.TaxRateAPI.entity.CanadaTaxRate;
import com.HelmerK.TaxRateAPI.entity.Location;

@Service
public class CanService {

	@Autowired
	private CanadaTaxRateDAO canDAO;
	@Autowired
	private LocationDAO locDAO;
	@Autowired
	private Utilites util;
	@Autowired
	private CanadaTaxRateDTO canDTO;

	public CanadaTaxRateDTO getCan(String locationCode) {

		String cleanCode = util.formatLocationCode(locationCode);

		boolean vaild = canDAO.vaildCode(cleanCode);

		if (vaild) {
			canDTO.setCountry(locDAO.getLoc(locationCode).getCountry());
			canDTO.setProvince(locDAO.getLoc(locationCode).getRegion());

			canDTO.setLocationCode(canDAO.getCan(locationCode).getLocationCode());
			canDTO.setGst(canDAO.getCan(locationCode).getGst());
			canDTO.setHst(canDAO.getCan(locationCode).getHst());
			canDTO.setPst(canDAO.getCan(locationCode).getPst());

			return canDTO;

		} else {

			return null;

		}
	}

	public void insertCan(CanadaTaxRateDTO rateDTO) {

		Location newLoc = new Location(rateDTO.getLocationCode(), rateDTO.getCountry(), rateDTO.getProvince());

		locDAO.insertLoc(newLoc);

		CanadaTaxRate newRate = new CanadaTaxRate(rateDTO.getLocationCode(), rateDTO.getGst(), rateDTO.getPst(),
				rateDTO.getHst());

		canDAO.insertCan(newRate);

	}

	public void deleteCan(String locationCode) {
		

		
		CanadaTaxRate deleteRate = canDAO.getCan(locationCode);
		canDAO.deleteCan(deleteRate);
		
		Location deleteLoc = locDAO.getLoc(locationCode);
		locDAO.deleteLoc(deleteLoc);

	}

	public void updateCan(CanadaTaxRateDTO rateDTO) {

		Location updatedLoc = new Location(rateDTO.getLocationCode(), rateDTO.getCountry(), rateDTO.getProvince());
		locDAO.updateLoc(updatedLoc);
		CanadaTaxRate updatedRate = new CanadaTaxRate(rateDTO.getLocationCode(), rateDTO.getGst(), rateDTO.getPst(),
				rateDTO.getHst());
		canDAO.updateCan(updatedRate);

	}

}
