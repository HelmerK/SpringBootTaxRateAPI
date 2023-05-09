package Packages;

public class TaxRate {

	 double gst;
	 double pst;
	 double hst;
	 String postalCode;
	 String province;
	 final String COUNTRY = "CAN";
	 String county;

	public TaxRate() {
		super();
	}

	public TaxRate(double gst, double pst, double hst, String postalCode, String province, String county) {
		super();
		this.gst = gst;
		this.pst = pst;
		this.hst = hst;
		this.postalCode = postalCode;
		this.province = province;
		this.county = county;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

}
