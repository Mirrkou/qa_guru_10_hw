package guru.qa.tests;

import guru.qa.data.StudentData;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegisterStudentTest {

    RegistrationPage registrationPage = new RegistrationPage();
    StudentData studentData = new StudentData();

    @DisplayName("Регистрация студента")
    @Test
    void fillForm() {
        registrationPage.openPage()
                        .typeFirstName(studentData.firstName)
                        .typeLastName(studentData.lastName)
                        .typeUserEmail(studentData.userEmail)
                        .chooseGender("Female")
                        .typeMobile(studentData.mobile)
                        .chooseSubject("Arts")
                        .uploadPicture()
                        .chooseHobbies("Music")
                        .typeCurrentAddress(studentData.address)
                        .chooseState("NCR")
                        .chooseCity("Noida");
        registrationPage.calendar.setDate("9", "5", "1987");
        registrationPage.submitClick();
        registrationPage.checkResultsValue("Student Name", studentData.firstName)
                        .checkResultsValue("Student Email", studentData.userEmail)
                        .checkResultsValue("Gender", "Female")
                        .checkResultsValue("Mobile", studentData.mobile)
                        .checkResultsValue("Date of Birth", "9 June,1987")
                        .checkResultsValue("Subjects", "Arts")
                        .checkResultsValue("Hobbies", "Music")
                        .checkResultsValue("Picture", "avatar.png")
                        .checkResultsValue("Address", studentData.address)
                        .checkResultsValue("State and City", "NCR Noida");
    }
}