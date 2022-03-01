package com.alexeypartolin.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;
import pages.TestBase;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alexey";
    String lastName = "Partolin";
    String userEmail = "alexeypartolin@yahoo.com";
    String userGender = "Male";
    String userNumber = "9163322170";
    String subject = "Computer Science";
    String hobie = "Sports";
    String day = "10";
    String month = "July";
    String year = "2021";
    String address = "Ovchinnikovskaya наб., 6 стр1, Москва, 19128";


    @Test
    void newTest() {
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.typeGender(userGender);
        registrationPage.setNumber(userNumber);
        registrationPage.setSubjects(subject);
        registrationPage.imgPicture();
        registrationPage.setBirthDate(day, month, year);
        registrationPage.chooseHobie(hobie);
        registrationPage.setAddress(address);
        registrationPage.scrollToSubmitButton();
        registrationPage.choiceStateStateCity();
        registrationPage.choiceStateCityWrapperNCR();
        registrationPage.choiceStateCity();
        registrationPage.choiceStateCityWrapperNoida();
        registrationPage.pressSubmitButton();

        // Asserts

        registrationPage.checkModalContent();
        registrationPage.tableResponsive.shouldHave(text(firstName), text(lastName),
                text(userEmail), text(day), text(month), text(year), text(userGender), text(hobie), text(address),
                text(userNumber));


        sleep(10000);
    }
}