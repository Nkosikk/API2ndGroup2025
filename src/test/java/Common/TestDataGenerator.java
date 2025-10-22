package Common;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    public static String name = Faker.instance().name().firstName();
    public static String job = Faker.instance().job().position();
    public static String company = Faker.instance().company().name();

    public static String external_id = Faker.instance().idNumber().valid();
    public static String latitude = String.valueOf(Faker.instance().number().randomDouble(2, -90, 90));
    public static String longitude = String.valueOf(Faker.instance().number().randomDouble(2, -180, 180));
    public static String altitude = String.valueOf(Faker.instance().number().randomDouble(2, 0, 10000));


}
