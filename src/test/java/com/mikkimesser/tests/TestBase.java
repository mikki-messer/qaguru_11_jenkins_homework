package com.mikkimesser.tests;

import com.codeborne.selenide.Configuration;
import com.mikkimesser.helpers.Attach;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    @Step("Предварительная настройка")
    public static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1280x720";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    @Step("Сохранение скриншота, видео, исходного кода и логов консоли")
    void addAttachments() {
        String screenshotName;                                // Returns a `String`.
        screenshotName = String.format("Screnshot %s",ZonedDateTime                    // Represent a moment as perceived in the wall-clock time used by the people of a particular region ( a time zone).
                .now(                            // Capture the current moment.
                        ZoneId.of("Europe/Moscow")  // Specify the time zone using proper Continent/Region name. Never use 3-4 character pseudo-zones such as PDT, EST, IST.
                )                                // Returns a `ZonedDateTime` object.
                .format(                         // Generate a `String` object containing text representing the value of our date-time object.
                        DateTimeFormatter.ofPattern("uuuu.MM.dd.HH.mm.ss")
                ));
        Attach.screenshotAs(screenshotName);
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
