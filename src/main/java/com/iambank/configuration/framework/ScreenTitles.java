package com.iambank.configuration.framework;

public enum ScreenTitles {
    MarketSelection("Select your \ncountry"),
    LegalName("Let's start out with your name."),
    PhoneNumber("Can we have your number?"),
    VerificationCode("Type in the code we sent."),
    ChoosePIN("Choose a five digit PIN."),
    Address("Where do you live?"),
    SSN("We need to legally verify who you are."),
    UploadDocument("We need to legally verify who you are."),
    ThanksScreen("we got your application."),
    FasterLogin("Faster Login"),
    EnterEmailAddress("Have things sent to your email"),
    UNKNOWN("No screen name"),
    
	//Address Screen texts//
    AddressScreenNumber("STEP 6 OF 6"),
	AddressSmallText("So we can send you a shiny new card."),
	AddressLine1Text("Address Line 1"),
	AddressLineOptionalText("Address Line 2 (optional)"),
	CityText("City"),
	StateText("State"),
	ZipText("Zip"),
	
	//SSN Screen texts//
	SSNScreenNumber("STEP 5 OF 6"),
	SSNSmallText("Your security is extremely important to us. We don’t want to ask for these kinds of things, but Federal Law requires that we do."),
	SSNFieldText("Social security number"),
	SSNDocumentUploadText("Use document photo instead.");
    
    private String title;

	ScreenTitles(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
        
    
}