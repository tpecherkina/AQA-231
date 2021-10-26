import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.Keys.BACK_SPACE;


class FakerTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:7777/");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldRegisterDate() {
        $("[data-test-id=city] input").setValue(FakerTestDataGenerator.generateAddress());
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.chord(BACK_SPACE, FakerTestDataGenerator.generateDate(3)));
        $("[data-test-id=name] input").setValue(FakerTestDataGenerator.generateName());
        $("[data-test-id=phone] input").setValue(FakerTestDataGenerator.generatePhone());
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
        $("[data-test-id=success-notification] .notification__content").shouldHave(Condition.exactText("Встреча успешно запланирована на " + FakerTestDataGenerator.generateDate(3)));
    }

    @Test
    void shouldRegisterNewDate() {
        $("[data-test-id=city] input").setValue(FakerTestDataGenerator.generateAddress());
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.chord(BACK_SPACE, FakerTestDataGenerator.generateDate(3)));
        $("[data-test-id=name] input").setValue(FakerTestDataGenerator.generateName());
        $("[data-test-id=phone] input").setValue(FakerTestDataGenerator.generatePhone());
        $("[data-test-id=agreement]").click();
        $(".button__text").click();
        $("[data-test-id=success-notification] .notification__content").shouldHave(Condition.exactText("Встреча успешно запланирована на " + FakerTestDataGenerator.generateDate(3)));
        $("[data-test-id=date] input").doubleClick();
        $("[data-test-id=date] input").sendKeys(Keys.chord(BACK_SPACE, FakerTestDataGenerator.generateDate(4)));
        $(".button__text").click();
        $("[data-test-id=replan-notification] .button__text").click();
        $("[data-test-id=success-notification] .notification__content").shouldHave(Condition.exactText("Встреча успешно запланирована на " + FakerTestDataGenerator.generateDate(4)));

    }

}

