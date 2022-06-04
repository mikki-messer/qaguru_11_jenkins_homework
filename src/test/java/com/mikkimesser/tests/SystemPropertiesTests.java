package com.mikkimesser.tests;

import com.mikkimesser.configuration.CredentialConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemProperties")
public class SystemPropertiesTests {
    @Test
    void someTest3() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); // opera
    }
    @Test
    void someTest4(){
        CredentialConfig credentialConfig = ConfigFactory.create(CredentialConfig.class);
        String selenoidLogin = credentialConfig.login();
        String selenoidPassword = credentialConfig.password();

        System.out.println(selenoidLogin);
        System.out.println(selenoidPassword);
    }
}
