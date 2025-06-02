package Common;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    //For ReqRes
    public static String name = Faker.instance().name().firstName();
    public static String job = Faker.instance().job().position();
    public static String company = Faker.instance().company().name();

    //For OpenWeatherMap
    public static String Station = Faker.instance().country().capital();
    public static String External_ID = Faker.instance().numerify("Test_101");
    public static long altitude = Faker.instance().number().numberBetween(-1000, 1000);
    //public static float longitude = Float.parseFloat(Faker.instance().address().longitude());
    //public static float latitude = Float.parseFloat(Faker.instance().address().latitude());

}

