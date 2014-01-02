package de.agiledojo.multienv;

public class SampleBean {

	private String defaultValue;

	private String productionValue;

	public SampleBean(String defaultValue, String productionValue) {
		this.defaultValue = defaultValue;
		this.productionValue = productionValue;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public String getProductionValue() {
		return productionValue;
	}

}
