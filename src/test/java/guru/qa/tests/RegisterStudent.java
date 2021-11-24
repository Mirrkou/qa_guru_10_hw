package guru.qa.tests;

import guru.qa.data.StudentData;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterStudent extends StudentData {

    RegistrationPage registrationPage = new RegistrationPage();

    @DisplayName("Регистрация студента")
    @Test
    void fillForm() {
        registrationPage.openPage()
                        .typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(userEmail)
                        .chooseGender("Female")
                        .typeMobile(mobile)
                        .chooseSubject("Arts")
                        .uploadPicture()
                        .chooseHobbies("Music")
                        .typeCurrentAddress(address)
                        .chooseState("NCR")
                        .chooseCity("Noida");
        registrationPage.calendar.setDate("9", "5", "1987");
        registrationPage.submitClick();
        registrationPage.checkResultsValue("Student Name", firstName)
                        .checkResultsValue("Student Email", userEmail)
                        .checkResultsValue("Gender", "Female")
                        .checkResultsValue("Mobile", mobile)
                        .checkResultsValue("Date of Birth", "9 June,1987")
                        .checkResultsValue("Subjects", "Arts")
                        .checkResultsValue("Hobbies", "Music")
                        .checkResultsValue("Picture", "avatar.png")
                        .checkResultsValue("Address", address)
                        .checkResultsValue("State and City", "NCR Noida");
    }
}