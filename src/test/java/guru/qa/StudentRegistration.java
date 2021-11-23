package guru.qa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentRegistration {

    @BeforeEach
    void ensurePrecondition() {
        openRegistrationFormPage();
    }

    @Test
    @DisplayName("Регистрация студента с заполнением дополнительных полей")
    void registrationWithAllFields() {
        fillFields();
        submitBtnClick();
        checkStudentInformation();
    }

    void fillFields() {
        $("input#firstName").setValue("Daria");
        $("input#lastName").setValue("Langina");
        $("input#userEmail").setValue("test@mail.com");
        $(byText("Female")).click(); //selectRadio не получилось
        $("input#userNumber").setValue("9879879879");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $$(".react-datepicker__day").find(text("11")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/resources/RegistrationForm.png"));
        $("#currentAddress").setValue("Tver");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
    }

    void submitBtnClick() {
        $("#submit").scrollTo().click();
        $(".modal-content").shouldBe(visible);
    }

    void checkStudentInformation() {
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Daria Langina"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@mail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9879879879"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("11 November,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("RegistrationForm.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Tver"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }

    @DisplayName("Открытие страницы 'Practice Form' с формой 'Student Registration Form'")
    void openRegistrationFormPage() {
        open("https://demoqa.com/automation-practice-form");
        $("#userForm").shouldBe(visible);
    }
}