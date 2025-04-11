package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ButtonsTests {
    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void openButtonsMenuPage() {
        open("/buttons");
    }

    @AfterEach
    void closeBrowser () {
        closeWindow();
    }

    @Test
    void doubleClickButtonTest() {
        $("#doubleClickBtn").doubleClick();

        $("#doubleClickMessage").shouldHave(text("You have done a double click"));
    }

    @Test
    void rightClickButtonTest() {
        $("#rightClickBtn").contextClick();

        $("#rightClickMessage").shouldHave(text("You have done a right click"));
    }

    @Test
    void dynamicClickButtonTest() {
        $(byText("Click Me")).click();

        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }
}
