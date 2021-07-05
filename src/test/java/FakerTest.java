import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.BACK_SPACE;

    public class FakerTest {
        private final FakerTestDataGenerator fakerTestDataGenerator = new FakerTestDataGenerator();

        @BeforeEach
        void setUpAll() {
            open("http://localhost:7777/");
        }


        @Test
        void completedFormWithFaker() {
            $("[data-test-id=city] input").setValue(fakerTestDataGenerator.city());
            $("[data-test-id=date] input").doubleClick();
            $("[data-test-id=date] input").sendKeys(Keys.chord(BACK_SPACE, fakerTestDataGenerator.date(3)));
            $("[data-test-id=name] input").setValue(fakerTestDataGenerator.name());
            $("[data-test-id=phone] input").setValue(fakerTestDataGenerator.phoneNumber());
            $("[data-test-id=agreement]").click();
            $(".button__text").click();
            $("[data-test-id=success-notification] .notification__content").shouldHave(Condition.exactText("Встреча успешно запланирована на " + fakerTestDataGenerator.date(3)));
        }

    }

