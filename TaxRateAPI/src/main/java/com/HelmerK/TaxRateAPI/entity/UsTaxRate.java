/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HelmerK.TaxRateAPI.entity;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author super
 */
@Entity
@Table(name = "ustaxrate")
public class UsTaxRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "location_Code")
    private String locationCode;
    @Basic(optional = false)
    @Column(name = "state_tax")
    private double stateTax;

    public UsTaxRate() {
    }

    public UsTaxRate(String locationCode) {
        this.locationCode = locationCode;
    }

    public UsTaxRate(String locationCode, double stateTax) {
        this.locationCode = locationCode;
        this.stateTax = stateTax;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public double getStateTax() {
        return stateTax;
    }

    public void setStateTax(double stateTax) {
        this.stateTax = stateTax;
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
        if (!(object instanceof UsTaxRate)) {
            return false;
        }
        UsTaxRate other = (UsTaxRate) object;
        if ((this.locationCode == null && other.locationCode != null) || (this.locationCode != null && !this.locationCode.equals(other.locationCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Ustaxrate[ locationCode=" + locationCode + " ]";
    }
    
}
