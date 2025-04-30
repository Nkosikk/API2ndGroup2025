package PayloadBuilder;

import com.github.javafaker.Faker;
import Common.TestDataGenerator;
import org.json.simple.JSONObject;

public class ReqResPayloadBuilder {

    static String employeeName = TestDataGenerator.name;
    static String jobTitle = TestDataGenerator.job;
    static String companyName = TestDataGenerator.company;

    public static JSONObject createEmployeeResponse() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", employeeName);
        jsonObject.put("job", jobTitle);

        return jsonObject;
    }

    public static JSONObject updateEmployeeResponse() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", employeeName);
        jsonObject.put("job", jobTitle);
        jsonObject.put("Company name", companyName);

        return jsonObject;
    }

    public static JSONObject PatchEmployeeResponse() {

        String updateName = Faker.instance().name().firstName();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", updateName);
        jsonObject.put("job", jobTitle);
        jsonObject.put("Company", companyName);

        return jsonObject;
    }


}
