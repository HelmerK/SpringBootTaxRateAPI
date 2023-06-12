package com.HelmerK.TaxRateAPI.DTO;

import org.springframework.stereotype.Service;

@Service
public class CanadaTaxRateDTO {

	private String country;
	private String province;
	private String locationCode;
	private double gst;
	private double pst;
	private double hst;

	public CanadaTaxRateDTO() {

	}

	public CanadaTaxRateDTO(String country, String province, String locationCode, double gst, double pst, double hst) {
		this.country = country;
		this.province = province;
		this.locationCode = locationCode;
		this.gst = gst;
		this.pst = pst;
		this.hst = hst;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getPst() {
		return pst;
	}

	public void setPst(double pst) {
		this.pst = pst;
	}

	public double getHst() {
		return hst;
	}

	public void setHst(double hst) {
		this.hst = hst;
	}

}
