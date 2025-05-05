package Common;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    public static String name = Faker.instance().name().firstName();
    public static String job = Faker.instance().job().position();
    public static String company = Faker.instance().company().name();

    public static String longitude = Faker.instance().address().longitude();
    public static String latitude = Faker.instance().address().latitude();
    public static int altitude = Faker.instance().number().numberBetween(10,20);

}
