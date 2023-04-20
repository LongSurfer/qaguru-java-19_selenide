package guru.qa.tests;


import guru.qa.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpenEnterprisePage extends TestBase {

//    На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
//    Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."

    @Test
    void openingEnterprizePage() {
        open("https://github.com/");

        $(".HeaderMenu-item", 1).hover();
        $("a[href='/enterprise']").click();

        $(".application-main ").shouldHave(text("Build like the best"));

    }
}
