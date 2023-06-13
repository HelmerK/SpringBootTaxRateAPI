package com.HelmerK.TaxRateAPI.entity;



import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author super
 */
@Entity
@Table(name = "canadataxrate")

public class CanadaTaxRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "location_Code")
    private String locationCode;
    @Basic(optional = false)
    @Column(name = "gst")
    private double gst;
    @Basic(optional = false)
    @Column(name = "pst")
    private double pst;
    @Basic(optional = false)
    @Column(name = "hst")
    private double hst;
   

    public CanadaTaxRate() {
    }

    public CanadaTaxRate(String locationCode) {
        this.locationCode = locationCode;
    }

    public CanadaTaxRate(String locationCode, double gst, double pst, double hst) {
        this.locationCode = locationCode;
        this.gst = gst;
        this.pst = pst;
        this.hst = hst;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationCode != null ? locationCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CanadaTaxRate)) {
            return false;
        }
        CanadaTaxRate other = (CanadaTaxRate) object;
        if ((this.locationCode == null && other.locationCode != null) || (this.locationCode != null && !this.locationCode.equals(other.locationCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Canadataxrate[ locationCode=" + locationCode + " ]";
    }
    
}
