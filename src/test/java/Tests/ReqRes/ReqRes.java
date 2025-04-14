package Tests.ReqRes;

import RequestBuilder.ReqResRequestBuilder;
import io.qameta.allure.Severity;
import jdk.jfr.Description;
import org.testng.annotations.Test;

@Test
public class ReqRes {

    @Description("As an api user, I want to send post request that will create new employee")
    public void createEmployeeTest(){
        ReqResRequestBuilder.createEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201);

    }

}
