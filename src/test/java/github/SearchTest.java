package github;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тестирование поисковых результатов")
public class SearchTest {

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen= true;
    }

    @ValueSource(strings = {
            "Java", "Python"
    })
    @ParameterizedTest
    @DisplayName("Поиск выдает несколько результатов")
    void searchShouldContainManyResults(String query) {
        open("https://github.com/search?q=" + query + "&type=repositories");
        $("[data-testid='results-list']").$$(".Box-sc-g0xbh4-0")
                .shouldHave(sizeGreaterThan(0));
    }

}
