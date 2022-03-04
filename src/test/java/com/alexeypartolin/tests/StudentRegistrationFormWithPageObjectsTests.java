package com.alexeypartolin.tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
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
    String imgPath = "src/test/resources/upload-folder/homeAlone.jpeg";
    String state = "NCR";
    String city = "Noida";

    @Test
    void newTest() {
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setUserEmail(userEmail);
        registrationPage.typeGender(userGender);
        registrationPage.setNumber(userNumber);
        registrationPage.setSubjects(subject);
        registrationPage.setImgPicture(imgPath);
        registrationPage.setBirthDate(day, month, year);
        registrationPage.chooseHobie(hobie);
        registrationPage.setAddress(address);
        registrationPage.scrollToSubmitButton();
        registrationPage.setStateAndCity(state, city);
        registrationPage.pressSubmitButton();

        // Asserts

        registrationPage.checkModalContent();
        registrationPage.checkForm(firstName,lastName,userEmail,userNumber,day,month,year,userGender,hobie,address,state,city);
    }
}