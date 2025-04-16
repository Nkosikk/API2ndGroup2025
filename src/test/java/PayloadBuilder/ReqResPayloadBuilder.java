package PayloadBuilder;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ReqResPayloadBuilder {

    public static JSONObject createEmployeeResponse() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Sibu");
        jsonObject.put("job", "Engineer");

        return jsonObject;
    }

    public static JSONObject updateEmployeeResponse() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Sibu");
        jsonObject.put("job", "Senior Engineer");
        jsonObject.put("Department", "IT");

        return jsonObject;
    }

    public static JSONObject PatchEmployeeResponse() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Ntsako");
        jsonObject.put("job", "Senior Engineer");
        jsonObject.put("Department", "IT");

        return jsonObject;
    }


}
