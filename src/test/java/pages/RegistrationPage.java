package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String TITLE_TEXT = "Student Registration Form";
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final SelenideElement firstNameInput = $("#firstName"), lastNameInput = $("#lastName"), emailInput = $("#userEmail"), genderRadio = $("#genterWrapper"), phoneInput = $("#userNumber"), dateOfBirthInput = $("#dateOfBirthInput"), subjectInput = $("#subjectsInput"), hobbiesInput = $("#hobbiesWrapper"), pictureUpload = $("#uploadPicture"), addressInput = $("#currentAddress"), stateInput = $("#state"), stateDropDown = $("#stateCity-wrapper"), cityInput = $("#city"), cityDropDown = $("#stateCity-wrapper"), submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanners() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderRadio.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage setPicture(String location) {
        pictureUpload.uploadFromClasspath(location);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateDropDown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityDropDown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage sendSubmit() {
        submitButton.click();

        return this;
    }


    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
