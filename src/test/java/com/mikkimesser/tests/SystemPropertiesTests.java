package com.mikkimesser.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemProperties")
public class SystemPropertiesTests {
    @Test
    void someTest3() {
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser); // opera
    }
}
