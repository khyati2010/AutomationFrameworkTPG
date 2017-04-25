package com.iambank.app.configuration;

import com.iambank.framework.configuration.ConfigBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("classpath:app.properties"),
        @PropertySource(value = "${custom.properties.file}", ignoreResourceNotFound = true) //allows to use custom app.properties file
})
@ComponentScan({
        "com.iambank.app.configuration"})
public class AppConfig extends ConfigBase {

    public static final String TEST_USER = "testUser";

    @Autowired
    AppiumCapabilities appiumCapabilities;
}
