package com.app.configuration.driver;

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
"com.app.configuration.driver"})
public class DriverConfig  {
	@Autowired
	DriverProperties driverProperties;
}
