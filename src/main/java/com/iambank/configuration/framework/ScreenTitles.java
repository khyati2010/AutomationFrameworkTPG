package com.iambank.configuration.framework;

public enum ScreenTitles {
    MarketSelection("Select your \ncountry"),
    LegalName("Let's start out with your name."),
    PhoneNumber("Can we have your number?"),
    VerificationCode("Type in the code we sent."),
    ChoosePIN("Choose a five digit PIN."),
    UNKNOWN("No screen name");
    
    private String title;

	ScreenTitles(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}