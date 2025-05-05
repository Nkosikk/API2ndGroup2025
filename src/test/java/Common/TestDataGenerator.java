package Common;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    public static String name = Faker.instance().name().firstName();
    public static String job = Faker.instance().job().position();
    public static String company = Faker.instance().company().name();

    //Test data generator weather.
    public static String stationName = String.valueOf(Faker.instance().name());
    public static String externalID = String.valueOf(Faker.instance().idNumber());
    public static String latitude = String.valueOf(Faker.instance().address().latitude());
    public static String longitude = String.valueOf(Faker.instance().address().longitude());
    public static String altitude = String.valueOf(Faker.instance().address().buildingNumber());

}


