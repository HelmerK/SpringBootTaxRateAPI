package com.HelmerK.TaxRateAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HelmerK.TaxRateAPI.DAO.LocationDAO;
import com.HelmerK.TaxRateAPI.DAO.UsTaxRateDAO;
import com.HelmerK.TaxRateAPI.DTO.UsTaxRateDTO;
import com.HelmerK.TaxRateAPI.entity.Location;
import com.HelmerK.TaxRateAPI.entity.UsTaxRate;

@Service
public class UsService {

	@Autowired
	private UsTaxRateDAO usDAO;
	@Autowired
	private LocationDAO locDAO;
	@Autowired
	private Utilites util;
	@Autowired
	private UsTaxRateDTO usDTO;

	public UsTaxRateDTO getUs(String locationCode) {
		String cleanCode = util.formatLocationCode(locationCode);
		boolean valid = usDAO.vaildCode(cleanCode);

		if (valid) {
		
			Location loc = locDAO.getLoc(cleanCode);
	
			UsTaxRate rate = usDAO.getUs(cleanCode);
	
			usDTO.setLocationCode(rate.getLocationCode());
			usDTO.setCountry(loc.getCountry());
			usDTO.setState(loc.getRegion());
			usDTO.setStateTax(rate.getStateTax());

			return usDTO;
		} else {
			return null;
		}
	}

	public void insertUs(UsTaxRateDTO rateDTO) {

		Location newLoc = new Location(rateDTO.getLocationCode(), rateDTO.getCountry(), rateDTO.getState());
		locDAO.insertLoc(newLoc);

		UsTaxRate newRate = new UsTaxRate(rateDTO.getLocationCode(), rateDTO.getStateTax());
		usDAO.insertUs(newRate);

	}

	public void deleteUs(String locationCode) {

		UsTaxRate deleteRate = usDAO.getUs(locationCode);
		usDAO.deleteUs(deleteRate);

		Location deleteLoc = locDAO.getLoc(locationCode);
		locDAO.deleteLoc(deleteLoc);

	}

	public void updateUs(UsTaxRateDTO rateDTO) {

		Location updatedLoc = new Location(rateDTO.getLocationCode(), rateDTO.getCountry(), rateDTO.getState());
		UsTaxRate updatedRate = new UsTaxRate(rateDTO.getLocationCode(), rateDTO.getStateTax());

		usDAO.updateUs(updatedRate);
		locDAO.updateLoc(updatedLoc);

	}

}
