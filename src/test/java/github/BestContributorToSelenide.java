package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void asolntsevFirstContributor() {
        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors")).closest("h2").sibling(0).$$("li").first().hover();
        $(".Popover-message").shouldHave(text("asolntsev"));

    }
}
