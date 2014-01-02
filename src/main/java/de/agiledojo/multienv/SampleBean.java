package de.agiledojo.multienv;

/**
 * Sample Bean to demonstrate property values with Spring
 * 
 */
public class SampleBean {

	private String generalValue;

	private String environmentSpecificValue;

	public SampleBean(String generalValue, String environmentSpecificValue) {
		this.generalValue = generalValue;
		this.environmentSpecificValue = environmentSpecificValue;
	}

	public String getGeneralValue() {
		return generalValue;
	}

	public String getEnvironmentSpecificValue() {
		return environmentSpecificValue;
	}

}
