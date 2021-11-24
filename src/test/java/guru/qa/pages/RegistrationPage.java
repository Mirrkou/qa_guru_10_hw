package guru.qa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import guru.qa.components.Calendar;
import java.io.File;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioBtn = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPictureBtn = $("#uploadPicture"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCitySelected = $("#stateCity-wrapper"),
            submitBtn = $("#submit"),
            resultsTable = $(".table-responsive");
    public Calendar calendar = new Calendar();


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender(String value) {
        genderRadioBtn.find(byText(value)).click();
        return this;
    }

    public RegistrationPage typeMobile(String value) {
        mobileInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture() {
        uploadPictureBtn.uploadFile(new File("src/test/resources/avatar.png"));
        return this;
    }

    public RegistrationPage chooseHobbies(String value) {
        hobbiesCheckbox.findElement(byText(value)).click();
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseState(String value) {
        stateInput.scrollTo();
        stateInput.click();
        stateCitySelected.$(byText(value)).scrollTo().click();
        return this;
    }

    public RegistrationPage chooseCity(String value) {
        cityInput.click();
        stateCitySelected.$(byText(value)).scrollTo().click();
        return this;
    }

    public void submitClick() {
        submitBtn.click();
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}