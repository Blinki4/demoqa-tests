package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void validFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Peter");
        $("#lastName").setValue("Parker");
        $("#userEmail").setValue("FriendlyNeighbour@web.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999111776");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("2003");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Computer").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("ejik.jpg");
        $("#currentAddress").setValue("New-York. Manhattan. Spider-Island.");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaiselmer").pressEnter();
        $("#submit").click();

        $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("Peter Parker"));
        $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("FriendlyNeighbour@web.com"));
        $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Male"));
        $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("8999111776"));
        $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("13 September,2003"));
        $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("Computer Science"));
        $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Sports, Reading, Music"));
        $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("ejik.jpg"));
        $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("New-York. Manhattan. Spider-Island."));
        $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("Rajasthan Jaiselmer"));
    }
}
