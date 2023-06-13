package com.HelmerK.TaxRateAPI.DTO;

import org.springframework.stereotype.Service;

@Service
public class UsTaxRateDTO {

	private String locationCode;
	private String country;
	private String state;
	private double stateTax;

	public UsTaxRateDTO() {

	}

	public UsTaxRateDTO(String locationCode, String country, String state, double stateTax) {

		this.locationCode = locationCode;
		this.country = country;
		this.state = state;
		this.stateTax = stateTax;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getStateTax() {
		return stateTax;
	}

	public void setStateTax(double stateTax) {
		this.stateTax = stateTax;
	}

}
