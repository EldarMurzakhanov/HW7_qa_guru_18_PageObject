package qa.guru;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        String userName = "Chandra";
        String lastName = "Nalaar";
        String userEmail = "kaladesh@testmail.test";
        String userGender = "Female";
        String userPhone = "1234567890";
        String userBirthDayDay = "01";
        String userBirthDayMonth = "January";
        String userBirthDayYear = "2000";
        String userSubject = "Hindi";
        String userHobbies = "Reading";
        String UserPicture = "no-homo-sapiens.png";
        String UserAddress = "10 Crestwood DrHudson currentAddress";
        String UserState = "NCR";
        String UserCity = "Delhi";

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDayDay, userBirthDayMonth, userBirthDayYear)
                .setSubject(userSubject)
                .setHobby(userHobbies)
                .setPicture(UserPicture)
                .setAddress(UserAddress)
                .setState(UserState)
                .setCity(UserCity)

                .sendSubmit();

        registrationPage
                .verifyResult("Student Name", userName + " Nalaar")
                .verifyResult("Student Email", "kaladesh@testmail.test")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "01 January,2000")
                .verifyResult("Subjects", "Hindi")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "no-homo-sapiens.png")
                .verifyResult("Address", "10 Crestwood DrHudson currentAddress")
                .verifyResult("State and City", "NCR Delhi");
    }
}