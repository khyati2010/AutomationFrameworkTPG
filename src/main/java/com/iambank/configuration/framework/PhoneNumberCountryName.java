package com.iambank.configuration.framework;

public enum PhoneNumberCountryName {
	US("United States"),
	UK("United Kingdom"),
	Ireland("Ireland"),
	India("India"),
	UNKNOWN("No country name");
	
	private String countryName;

	PhoneNumberCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String countryName() {
        return countryName;
    }
}
