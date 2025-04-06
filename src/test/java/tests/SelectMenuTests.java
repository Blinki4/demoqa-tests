package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelectMenuTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void selectMenuTest () {
        open("/select-menu");
        $("#withOptGroup").click();
        $(byText("A root option")).click();
        $(byText("Select Title")).click();
        $(byText("Mr.")).click();
    }

    @Test
    void oldStyleSelectTest() {
        open("/select-menu");
        $("#oldSelectMenu").selectOptionByValue("red");
    }

    @Test
    void multiselectDropdownTest() {
        open("/select-menu");
        $(byText("Select...")).click();
        $("#react-select-4-option-2").click();
        $("#react-select-4-option-3").click();
    }
}