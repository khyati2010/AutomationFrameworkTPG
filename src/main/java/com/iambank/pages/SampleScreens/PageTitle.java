package com.iambank.pages.SampleScreens;

public enum PageTitle {
	adminuser("peach@test.com"),
	adminpswd("Tpg@12345"),
	sspurl("http://selfserviceportal-test.parkmobile.3pillarglobal.com"),
	title("Parkmobile"),
	firstname("Admin@12345"),
	email("testing12@test.com"),
	UsermanagementPage("User Management"),
	HomePageTitle("Parkmobile Self-Service Portal"),
	msg1("Please enter a valid username or password.");
	
	 
	public String value;
	//for enum either use private or no access modifier
	PageTitle(String val) {	
		value=val;
		}
}
