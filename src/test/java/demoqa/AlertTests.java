package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AlertTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void alertTest() {
        open("/alerts");
        $("#alertButton").click();
        dismiss();
    }

    @Test
    void confirmTest() {
        open("/alerts");
        $("#confirmButton").click();
        confirm();

        $("#confirmResult").shouldHave(text("Ok"));
    }

    @Test
    void dismissTest() {
        open("/alerts");
        $("#confirmButton").click();
        dismiss();

        $("#confirmResult").shouldHave(text("Cancel"));
    }

    @Test
    void promptTest() {
        open("/alerts");
        $("#promtButton").click();
        prompt("Dmitriy");
        $("#promptResult").shouldHave(text("Dmitriy"));
    }

    @Test
    void alertWithTimeoutTest() {
        open("/alerts");
        $("#timerAlertButton").click();
        sleep(5000);
        confirm();
    }
}
