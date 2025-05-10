package common;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    public static String name = Faker.instance().name().firstName();
    public static String job = Faker.instance().job().position();
    public static String company = Faker.instance().company().name();
}
