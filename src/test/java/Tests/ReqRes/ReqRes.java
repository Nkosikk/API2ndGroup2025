package Tests.ReqRes;

import RequestBuilder.ReqResRequestBuilder;
import io.qameta.allure.Severity;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static RequestBuilder.ReqResRequestBuilder.employeeNumber;

@Test
public class ReqRes {

    @Description("As an api user, I want to send post request that will create new employee")
    public void createEmployeeTest(){
        ReqResRequestBuilder.createEmployeeRequest()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);

    }
    @Description("As an api user, I want to send put request that will update employee")
    @Test(dependsOnMethods = "createEmployeeTest()")
    public void updateEmployeeTest(){
        ReqResRequestBuilder.updateEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Description("As an api user, I want to send patch request that will update employee")
    @Test(dependsOnMethods = "updateEmployeeTest()")
    public void patchEmployeeTest(){
        ReqResRequestBuilder.PatchEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
    @Description("As an api user, I want to send delete request that will delete employee")
    @Test(dependsOnMethods = "patchEmployeeTest()")
    public void deleteEmployeeTest(){
        ReqResRequestBuilder.deleteEmployeeRequest()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }



}
