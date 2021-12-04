package guru.qa.tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("commonSearch")
public class CommonSearchTest extends TestBase {

    @BeforeEach
    void openPage() {
        open("https://www.wildberries.ru/");
    }

    @DisplayName("Поиск шапки через общее поле поиска 'Я ищу'")
    @Test
    void searchHat() {
        $("#searchInput").setValue("Шапка").pressEnter();
        $(".searching-results__title").shouldHave(text("По запросу «шапка» найдено"));
    }

    @DisplayName("Поиск джинс через общее поле поиска 'Я ищу'")
    @Test
    void searchJeans() {
        $("#searchInput").setValue("Джинсы").pressEnter();
        $(".searching-results__title").shouldHave(text("По запросу «джинсы» найдено"));
    }

    @DisplayName("Открыть информацию о компании")
    @Test
    void openCompanyInfo() {
        $("[rel='nofollow']").find(byText("О нас")).click();
        $("[class='features__section-header section-header']").shouldHave(text("Наши преимущества"));
    }

    @DisplayName("Открыть раздел 'Доставка'")
    @Test
    void openDeliverySection() {
        $("[class='simple-menu__item'] [class='simple-menu__link']").click();
        $("[class='free-shipping-banner']").shouldHave(text("Доставка"));
    }

    @DisplayName("Открыть раздел 'Работа'")
    @Test
    void openWorkSection() {
        $("[class='simple-menu__link simple-menu__link--employment']").click();
        $("[class='employment__intro employment__gradient intro']").shouldBe(visible);
    }
}