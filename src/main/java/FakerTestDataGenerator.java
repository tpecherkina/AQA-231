import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FakerTestDataGenerator {
    private FakerTestDataGenerator() {
    }

        public static String generateName() {
            Faker faker = new Faker(new Locale("ru"));
            String name = faker.name().fullName();
            return name;
        }

        public static String generatePhone() {
            Faker faker = new Faker(new Locale("ru"));
            String phone = faker.phoneNumber().phoneNumber();
            return phone;
        }

    public static String generateAddress() {
        Faker faker = new Faker(new Locale("ru"));
        String address = faker.address().cityName();
        return address;
    }

    public static String generateDate(int daysFuture) {
        return LocalDate.now().plusDays(daysFuture).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}