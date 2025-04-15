package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginTests {
    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void openSelectMenuPage() {
        open("/login");
    }

    @AfterEach
    void closeBrowser() {
        closeWindow();
    }

    @Test
    void successfulLoginTest() {
        $("#userName").setValue("Spider-Man");
        $("#password").setValue("Venom13!");
        $("#login").click();

        $("#userName-value").shouldHave(text("Spider-Man"));
    }

    @Test
    void invalidLoginTest() {
        $("#userName").setValue("Batman");
        $("#password").setValue("Venom13!");
        $("#login").click();

        $("#name").shouldHave(text("Invalid username or password!"));
    }

    @Test
    void invalidPasswordTest() {
        $("#userName").setValue("Spider-Man");
        $("#password").setValue("Venomenalno");
        $("#login").click();

        $("#name").shouldHave(text("Invalid username or password!"));
    }

    @Test
    void emptyLoginAndPasswordTest() {
        $("#login").click();
        $("#userName").shouldHave(cssClass("is-invalid"));
        $("#password").shouldHave(cssClass("is-invalid"));
    }

    @Test
    void redirectToRegister() {
        $("#newUser").click();

        webdriver().shouldHave(url("https://demoqa.com/register"));
    }
}
