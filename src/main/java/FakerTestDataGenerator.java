import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FakerTestDataGenerator {

    private final Faker faker = new Faker(new Locale("ru"));

    public String city() {
        return faker.address().cityName();
    }

    public String name() {
        return faker.name().fullName();
    }

    public String phoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String date(int daysFuture) {
        return LocalDate.now().plusDays(daysFuture).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}