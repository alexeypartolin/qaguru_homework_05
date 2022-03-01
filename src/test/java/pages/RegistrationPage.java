package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userForm").$("#userEmail");
    private SelenideElement genderRadio = $(byText("gender"));
    private SelenideElement userNumber = $(By.id("userNumber"));
    private SelenideElement subjectsInput = $(By.id("subjectsInput"));
    private SelenideElement uploadPictureForm = $("#uploadPicture");
    private SelenideElement hobbieRadio = $("#hobbiesWrapper");
    private SelenideElement userAddress = $("#currentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement stateStateCity = $("#state");
    private SelenideElement stateCityWrapperNCR = $("#stateCity-wrapper").$(byText("NCR"));
    private SelenideElement stateCity = $("#city");
    private SelenideElement stateCityWrapperDelhi = $("#stateCity-wrapper").$(byText("Delhi"));

    private SelenideElement modalContent = $(".modal-content");
    public SelenideElement tableResponsive =  $(".table-responsive");


    // actions

    public void openPage() {
        open("/automation-practice-form");
    }

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
    }


    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }
    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }
    public void setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public void typeGender(String gender) {
        $(byText(gender)).click();
    }

    public void setNumber(String number) {
        userNumber.setValue(number);
    }

    public void setSubjects (String subject) {
        subjectsInput.setValue(subject).pressEnter();
    }

    public void imgPicture() {
        uploadPictureForm.uploadFile(new File("src/test/resources/upload-folder/homeAlone.jpeg"));
    }

    public void chooseHobie(String hobie) {
        hobbieRadio.find(byText(hobie)).click();
    }

    public void setAddress(String address) {
        userAddress.setValue(address);
    }

    public void scrollToSubmitButton() {
        submitButton.scrollTo();
    }

    public void choiceStateCityWrapperNCR() {
        stateStateCity.find(byText("NCR")).click();
    }

    public void choiceStateStateCity() {
        stateStateCity.scrollTo().click();
    }

    public void choiceStateCity() {
        stateCity.click();
    }

    public void choiceStateCityWrapperNoida() {
        stateCityWrapperDelhi.scrollTo().click();
    }

    public void pressSubmitButton() {
        submitButton.click();
    }

    // asserts

    public void checkModalContent() {
        modalContent.shouldBe(visible);
    }


}
