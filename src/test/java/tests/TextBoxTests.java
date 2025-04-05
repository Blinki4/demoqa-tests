package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulFormSubmitTest () {
        open("/text-box");
        $("#userName").setValue("Peter Parker");
        $("#userEmail").setValue("FriendlyNeighbour@web.com");
        $("#currentAddress").setValue("New-York. Manhattan. Spider-Island.");
        $("#permanentAddress").setValue("-----<3-----");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Peter Parker"));
        $("#output").$("#email").shouldHave(text("FriendlyNeighbour@web.com"));
        //Можно записать и так и так
        $("#output #currentAddress").shouldHave(text("New-York. Manhattan. Spider-Island."));
        $("#output #permanentAddress").shouldHave(text("-----<3-----"));
    }

    @Test
    void invalidEmail () {
        open("/text-box");
        $("#userEmail").setValue("FriendlyNeighbour");
        $("#submit").click();
        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}
