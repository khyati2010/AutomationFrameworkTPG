package com.iambank.configuration.framework;

public enum IntroScreenTitles {
	
	//Welcome Screen Texts//
	WelcomeScreen("We're a different kind of bank."),
	WelcomeScreenSmallText("Give us a chance, and we'll prove it."),
	WelcomeScreenBttnText("Ok, so prove it!"),
	WelcomeScreenSignInText("Sign In"),
	
	//First Intro Screen Texts//
	FirstIntroScreen("We never charge negative fees."),
	FirstIntroSmallText("Ever."),
	FirstIntroBttnText("Seems straightforward."),
	FirstIntroScreenNumber("1 OF 4"),
	
	//Second Intro Screen Texts//
	SecondIntroScreen("Use everyday shopping to pay off your debt."),
	SecondIntroSmallText("At zero cost to you. There are no catches, sorry."),
	SecondIntroBttnText("I'm listening."),
	SecondIntroScreenNumber("2 OF 4"),
	
	//Third Intro Screen Texts//
	ThirdIntroScreen("We have actual people you can talk to."),
	ThirdIntroSmallText("A novel idea, but we hate talking to machines too."),
	ThirdIntroBttnText("Cool."),
	ThirdIntroScreenNumber("3 OF 4"),
	
	//Fourth Intro screen Texts//
	FourthIntroScreen("Let's get started."),
	FourthIntroSmallText("Applying for an account usually takes 2-3 minutes. Let's go!"),
	FourthIntroBttnText("Apply for a new account"),
	FourthIntroSignInText("I already have an account"),
	FourthIntroScreenNumber("4 OF 4"),
	
	
	IntroSkipText("Skip this stuff");

	private String title;
	
	IntroScreenTitles(String title) {
		this.title = title;
	}
	
	 public String title() {
	        return title;
	    }

}
