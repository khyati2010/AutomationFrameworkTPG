package com.iambank.configuration.framework;

public enum ScreenTitles {
    MarketSelection("Select your \ncountry"),
    LegalName("Let's start out with your name."),
    PhoneNumber("Can we have your number?"),
    VerificationCode("Type in the code we sent."),
    ChoosePIN("Choose a five digit PIN."),
    SSN("We need to legally verify who you are."),
    Address("Where do you live?"),
    UNKNOWN("No screen name");
    
    private String title;

	ScreenTitles(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
    
    
    public enum AddressScreenUSTexts {
       	SmallText("So we can send you a shiny new card."),
    	AddressLine1Text("Address Line 1"),
    	AddressLineOptionalText("Address Line 2 (optional)"),
    	CityText("City"),
    	StateText("State"),
    	ZipText("Zip");
    }
}