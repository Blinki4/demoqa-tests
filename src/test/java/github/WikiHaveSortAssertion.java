package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiHaveSortAssertion {
    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void sortAssertionPageHaveJUnit () {
        open("https://github.com/selenide/selenide");
        $(byText("Wiki")).click();
        $(byText("Soft assertions")).click();
        $(byText("Using JUnit5")).sibling(0).$("pre").shouldHave(text("Test"));
    }
}
