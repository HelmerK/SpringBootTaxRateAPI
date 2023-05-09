package Packages;

public class UsTaxRate {
	double stateRate;
	String country;
	String state;
	String zipcode;
	static int locCount = 1;
	static int taxCount = 1;

	public UsTaxRate() {
		super();
	}

	public UsTaxRate(double stateRate, String country, String state, String zipcode) {
		super();
		this.stateRate = stateRate;
		this.country = country;
		this.state = state;
		this.zipcode = zipcode;
	}

	public static int getLocCount() {
		return locCount;
	}

	public static void setLocCount(int locCount) {
		UsTaxRate.locCount = locCount;
	}

	public static int getTaxCount() {
		return taxCount;
	}

	public static void setTaxCount(int taxCount) {
		UsTaxRate.taxCount = taxCount;
	}

	public double getStateRate() {
		return stateRate;
	}

	public void setStateRate(double stateRate) {
		this.stateRate = stateRate;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
