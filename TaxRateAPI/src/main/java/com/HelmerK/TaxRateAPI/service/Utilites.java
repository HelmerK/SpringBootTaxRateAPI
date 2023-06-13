package com.HelmerK.TaxRateAPI.service;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HelmerK.TaxRateAPI.DAO.UserDAO;
import com.HelmerK.TaxRateAPI.entity.User;

/*
 *Purpose of this class is to provide any needed utilities for the API to function. Will include verification for incoming location code and user login.  
 */

@Service
public class Utilites {

	@Autowired
	private UserDAO uDAO;

	// User related methods
	public boolean login(String username, String password) {
		uDAO = new UserDAO();

		User user = uDAO.getUser(username);

		if (user.getPassword().equals(password)) {

			return true;

		} else {
			return false;
		}
	}

	// Location code related methods
	/**
	 * This method will check the argument if it is in postal code or zip code
	 * format. If it is one of those, will remove all whitespace from the string and
	 * return it. If it is invalid then a empty string is returned. 
	 *
	 * @param locationCode The string representation of a US Zip Code or Canada
	 *                     Postal Code
	 * @return the formatted zipcode or postalcode, if they are valid. Returns the
	 *         locationCode if it is neither us or canada.
	 */
	public String formatLocationCode(String locationCode) {
		String parsedCode = "";

		if (isUSCode(locationCode)) {
			parsedCode = locationCode.trim().replaceAll("\\s+", "").substring(0, 5);
		} else if (isCanCode(locationCode)) {
			parsedCode = locationCode.trim().toUpperCase().replaceAll("\\s+", "").substring(0, 3);
		} else {
			return locationCode;
		}
		return parsedCode;
	}

	/**
	 * Checks to see if the parameter passed into it matches a regular expression
	 * for a US zip code.
	 *
	 * @param locationCode The string representation of a US Zip Code or Canada
	 *                     Postal Code
	 * @return true if it is in US Zip Code format
	 */
	public boolean isUSCode(String locationCode) {
		if (locationCode == null) {
			return false;
		}
		locationCode = locationCode.trim().replaceAll("\\s+", "");
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(locationCode);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks to see if the parameter passed into it matches a regular expression
	 * for the first 3 characters of a Canada postal code.
	 *
	 * @param locationCode The string representation of a US Zip Code or Canada
	 *                     Postal Code
	 * @return true if it is in Canada Postal Code format
	 */
	public boolean isCanCode(String locationCode) {
		if (locationCode == null) {
			return false;
		}
		locationCode = locationCode.toUpperCase().trim().replaceAll("\\s+", "").substring(0, 3);

		String regex = "^(?:[a-zA-Z]\\d[a-zA-Z])$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(locationCode);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
	

}
