package com.mikkimesser.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.mikkimesser.pages.RegistrationFormPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Tag("demoqa_registration_form")
public class AutomationPracticeFormTests extends TestBase {

    Faker faker = new Faker();

    /* Plan
    1. Добавить аллюр лисенер+
    2. Добавить степы+
    3. Добавить методы для сохранения консоли, скриншота и кода+
    4. Прогнать локально, убедиться, что всё работает+
    5. Зарегистрировать на дженкинсе+
    6. Настроить сборку+
    7. Добавить ремоут для селеноида+
    8. Добавить метод для сохранения видео+
     */
    @Test
    @DisplayName("Тест формы регистрации на demoqa")
    void fillFormTest() throws ParseException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        //initializing test data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String address = faker.address().fullAddress();

        //faking dates
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date randomDate = faker.date().between(simpleDateFormat.parse("1900-01-01"),
                simpleDateFormat.parse("2010-01-01"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(randomDate);
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        String day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));

        String state = "NCR";
        String city = "Gurgaon";
        String picturePath = "test.jpeg";
        String subject = "Maths";
        String gender = "Male";
        String hobby = "Reading";

        //opening the registration page
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        registrationFormPage.openPage();

        //filling the fields
        registrationFormPage.registerNewUser(firstName,
                lastName,
                email,
                phoneNumber,
                address,
                day,
                month,
                year,
                state,
                city,
                picturePath,
                gender,
                subject,
                hobby
        );

        //checking the results
        registrationFormPage.checkRegistrationResults(firstName,
                lastName,
                email,
                phoneNumber,
                address,
                day,
                month,
                year,
                state,
                city,
                picturePath,
                gender,
                subject,
                hobby);

        //closing the results form and asserting it closes
        registrationFormPage.closeResultsTable();
    }
}
