package guru.qa.tests;

import guru.qa.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitSoftAssertionsPageTest extends TestBase {


//        - Откройте страницу Selenide в Github
//        - Перейдите в раздел Wiki проекта
//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5


    @Test
    void openSoftAssertionsBySearch() {

        open("selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }

    @Test
    void openSoftAssertionsByShowMore() {

        open("selenide/selenide");

        $("#wiki-tab").click();
        $(".wiki-more-pages-link").$("[type='button']").click();
        $(".Layout-sidebar").shouldHave(text("SoftAssertions"));
        $("a[href = '/selenide/selenide/wiki/SoftAssertions']").click();
//
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
