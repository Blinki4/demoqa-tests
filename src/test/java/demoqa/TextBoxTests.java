package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {
    String firstName = "Дмитрий",
            email = "dima@bla.bla",
            address = "address";

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void openTextBoxPage() {
        open("/text-box");
    }

    @AfterEach
    void closeBrowser() {
        closeWindow();
    }

    @Test
    void successfulFormSubmitTest() {
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(address);
        $("#permanentAddress").setValue("-----<3-----");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text(firstName));
        $("#output").$("#email").shouldHave(text(email));
        //Можно записать и так и так
        $("#output #currentAddress").shouldHave(text(address));
        $("#output #permanentAddress").shouldHave(text("-----<3-----"));
    }

    @Test
    void invalidEmail() {
        $("#userEmail").setValue("F123");
        $("#submit").click();
        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}
