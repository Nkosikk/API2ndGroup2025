package PayloadBuilder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ReqresPayload {
    @Test
    public static JSONObject createEmployee(){
        JSONObject jsonObject = new JSONObject();
        //this put is to insert data
        jsonObject.put("name", "Mvelo");
        jsonObject.put("job", "Test Engineer");
        //System.out.println(jsonObject);

        return jsonObject;

    }

    public static JSONObject updateEmployee(){
        //put
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Mvelo");
        jsonObject.put("job", "Test Engineer");
        jsonObject.put("gender", "Female");

        return jsonObject;

    }
    public static JSONObject editEmployee(){
        //patch
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Mvelo");
        jsonObject.put("job", "Senior Test Engineer");
        jsonObject.put("gender", "Female");

        return jsonObject;
    }

}
