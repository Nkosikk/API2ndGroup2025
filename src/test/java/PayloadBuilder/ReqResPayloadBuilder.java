package PayloadBuilder;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ReqResPayloadBuilder {

    public static JSONObject createEmployeeResponse(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Sibu");
        jsonObject.put("job","Engineer");

        return jsonObject;
    }
}
