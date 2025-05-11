package PayloadBuilder;

import com.github.javafaker.Faker;
import common.TestDataGenerator;
import org.json.simple.JSONObject;

public class ReqResPayloadBuilder {

    public static String employeeName = TestDataGenerator.name;
    public static String jobTitle = TestDataGenerator.job;
    public static String companyName = TestDataGenerator.company;

    public static JSONObject createEmployeeResponse(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "employeeName");
        jsonObject.put("job","jobTitle");

        return jsonObject;
    }
    public static JSONObject updateEmployeeResponse() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "employeeName");
        jsonObject.put("job", "jobTitle");
        jsonObject.put("Company", "companyName");

        return jsonObject;
    }
    public static JSONObject PatchEmployeeResponse() {

        String updateName = Faker.instance().name().firstName();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", Faker.instance().name().firstName());
        jsonObject.put("job", " jobTitle");
        jsonObject.put("Company","companyName");

        return jsonObject;
    }

}
