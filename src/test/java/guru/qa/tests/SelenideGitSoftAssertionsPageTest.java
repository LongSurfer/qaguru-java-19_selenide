package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitSoftAssertionsPageTest {


//        - Откройте страницу Selenide в Github
//        - Перейдите в раздел Wiki проекта
//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com/selenide";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void OpenSoftAssertionsBySearch() {

        open("/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }

    @Test
    void OpenSoftAssertionsByShowMore() {

        open("/selenide");

        $("#wiki-tab").click();
        $(".wiki-more-pages-link").$("[type='button']").click();
        $(".Layout-sidebar").shouldHave(text("SoftAssertions"));
        $("a[href = '/selenide/selenide/wiki/SoftAssertions']").click();
//
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
