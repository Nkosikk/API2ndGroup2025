package Common;

import com.github.javafaker.Faker;

public class TestDataGenerator {

    public static String name = Faker.instance().name().firstName();
    public static String job = Faker.instance().job().position();
    public static String company = Faker.instance().company().name();


    public  static String Station = Faker.instance().country().capital();
    public  static String External_ID = Faker.instance().numerify("Test_101");
}
