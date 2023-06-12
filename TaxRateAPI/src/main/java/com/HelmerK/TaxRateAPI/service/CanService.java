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
		canDTO.setLocationCode(canDAO.getCan(locationCode).getLocationCode());
		canDTO.setCountry(locDAO.getLoc(locationCode).getCountry());
		canDTO.setProvince(locDAO.getLoc(locationCode).getRegion());
		canDTO.setGst(canDAO.getCan(locationCode).getGst());
		canDTO.setHst(canDAO.getCan(locationCode).getHst());
		canDTO.setPst(canDAO.getCan(locationCode).getPst());
		return canDTO;

	}

	public void insertCan(CanadaTaxRate rate) {

	

	

	}

	public void deleteCan(CanadaTaxRate rate) {

		canDAO.deleteCan(rate);

	}

	public void updateCan(CanadaTaxRate rate) {

	

	}

}
