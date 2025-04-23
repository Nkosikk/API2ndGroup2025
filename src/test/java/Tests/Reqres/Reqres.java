package Tests.Reqres;

import RequestBuilder.ReqresRequest;
import jdk.jfr.Description;
import org.testng.annotations.Test;

@Test
public class Reqres {

    @Description("As an API User, I want to send post request that will create new employee")
    public void createEmployeeTest() {
        ReqresRequest.createEmployeeRequest().
                then().
                log().all().
                assertThat().
                statusCode(201);
    }

//    public void printEmployeeId() {
//        System.out.println("Extracted employee id is: " + employeeId);
//    }

    @Description("As an API User, I want to send put request that will update employee")
    @Test(dependsOnMethods = "createEmployeeTest")
    public void updateEmployeeTest() {
        ReqresRequest.UpdateEmployeeRequest().
                then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Description("As an API User, I want to send patch request that will edit employee details")
    @Test(dependsOnMethods = "updateEmployeeTest")
    public void editEmployeeTest() {
        ReqresRequest.EditEmployeeRequest().
                then().
                log().all().
                assertThat().
                statusCode(200);
    }

    @Description("As an API User, I want to send delete request that will delete employee")
    @Test(dependsOnMethods = "editEmployeeTest")
    public void deleteEmployeeTest() {
        ReqresRequest.deleteEmployeeRequest().
                then().
                log().all().
                assertThat().
                statusCode(204);}
}
