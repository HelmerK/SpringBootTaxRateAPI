package Packages;

public class State {

	String stateName;
	double taxRate;

	public State() {
		super();

	}

	public State(String stateName, double taxRate) {
		super();
		this.stateName = stateName;
		this.taxRate = taxRate;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

}
