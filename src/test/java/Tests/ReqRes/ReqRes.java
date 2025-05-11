package Tests.ReqRes;

import RequestBuilder.ReqResRequestBuilder;
import io.qameta.allure.Severity;
import jdk.jfr.Description;
import org.testng.annotations.Test;

@Test
public class ReqRes {

    @Description("As an api user, I want to send post request that will create new employee")
    public void createEmployeeTest() {
        ReqResRequestBuilder.createEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201);
    }
        @Description("As an api user, I want to send get request that will get employee")
        @Test(dependsOnMethods = "createEmployeeTest")
        public void getEmployeeTest() {
            ReqResRequestBuilder.getEmployeeRequest()
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200);
        }

    @Description("As an api user, I want to send put request that will update employee")
    @Test(dependsOnMethods = "getEmployeeTest")
    public void updateEmployeeTest() {
        ReqResRequestBuilder.updateEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Description("As an api user, I want to send patch request that will update employee")
    @Test(dependsOnMethods = "updateEmployeeTest()")
    public void patchEmployeeTest() {
        ReqResRequestBuilder.patchEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Description("As an api user, I want to send delete request that will delete employee")
    @Test(dependsOnMethods = "patchEmployeeTest()")
    public void deleteEmployeeTest() {
        ReqResRequestBuilder.deleteEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }


}
