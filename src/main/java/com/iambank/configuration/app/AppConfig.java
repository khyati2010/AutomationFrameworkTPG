package com.iambank.configuration.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:app.properties"),
	@PropertySource(value = "${custom.properties.file}", ignoreResourceNotFound = true) //allows to use custom app.properties file
})
@ComponentScan({
"com.iambank.configuration.app"})
public class AppConfig  {

	@Autowired
	AppiumCapabilities appiumCapabilities;
}
