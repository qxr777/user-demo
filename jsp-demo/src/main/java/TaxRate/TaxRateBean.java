package TaxRate;

public class TaxRateBean {
	private String product;
	private double rate;

	public TaxRateBean() {
		this.product = "A001";
		this.rate = 5;
	}

	public void setProduct(String ProductName) {
		this.product = ProductName;
	}

	public String getProduct() {
		return (this.product);
	}

	public void setRate(double RateValue) {
		this.rate = RateValue;
	}

	public double getRate() {
		return (this.rate);
	}
}
