package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTestsWithPageObject {
    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Дмитрий",
            lastName = "Иванов",
            email = "dima@bla.bla";

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).
                setGender("Male").
                setNumber("1234567890").
                setDateOfBirth("13", "September", "2003").
                setSubjects("Math").
                setHobbies("Sports").
                setHobbies("Music");


        $("#uploadPicture").uploadFromClasspath("ejik.jpg");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationPage.checkResult("Student Name", firstName);
        registrationPage.checkResult("Student Email", email);
    }
}
