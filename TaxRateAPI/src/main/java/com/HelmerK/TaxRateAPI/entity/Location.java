package com.HelmerK.TaxRateAPI.entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author super
 */
@Entity
@Table(name = "location")
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "location_Code")
	private String locationCode;
	@Basic(optional = false)
	@Column(name = "country")
	private String country;
	@Basic(optional = false)
	@Column(name = "region")
	private String region;
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "location", fetch = FetchType.EAGER)
	private CanadaTaxRate canadataxrate;
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "location", fetch = FetchType.EAGER)
	private UsTaxRate ustaxrate;

	public Location() {
	}

	public Location(String locationCode) {
		this.locationCode = locationCode;
	}

	public Location(String locationCode, String country, String region) {
		this.locationCode = locationCode;
		this.country = country;
		this.region = region;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public CanadaTaxRate getCanadaTaxRate() {
		return canadataxrate;
	}

	public void setCanadaTaxRate(CanadaTaxRate canadataxrate) {
		this.canadataxrate = canadataxrate;
	}

	public UsTaxRate getUsTaxRate() {
		return ustaxrate;
	}

	public void setUsTaxRate(UsTaxRate ustaxrate) {
		this.ustaxrate = ustaxrate;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (locationCode != null ? locationCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Location)) {
			return false;
		}
		Location other = (Location) object;
		if ((this.locationCode == null && other.locationCode != null)
				|| (this.locationCode != null && !this.locationCode.equals(other.locationCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "models.Location[ locationCode=" + locationCode + " ]";
	}

}
