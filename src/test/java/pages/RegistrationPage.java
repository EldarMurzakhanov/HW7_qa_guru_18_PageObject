package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            EmailInput = $("#userEmail"),
            GenderRadio = $("#genterWrapper"),
            PhoneInput = $("#userNumber"),
            DateOfBirthInput = $("#dateOfBirthInput"),
            SubjectInput = $("#subjectsInput"),
            HobbiesInput = $("#hobbiesWrapper"),
            PictureUpload = $("#uploadPicture"),
            AddressInput = $("#currentAddress"),
            StateInput = $("#state"),
            StateDropDown = $("#stateCity-wrapper"),
            CityInput = $("#city"),
            CityDropDown = $("#stateCity-wrapper"),
            SubmitButton = $("#submit");


    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
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
        EmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        GenderRadio.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        PhoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        DateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        SubjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        HobbiesInput.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage setPicture(String location) {
        PictureUpload.uploadFromClasspath(location);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        AddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        StateInput.click();
        StateDropDown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        CityInput.click();
        CityDropDown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage pushSubmit() {
        SubmitButton.click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }
}
