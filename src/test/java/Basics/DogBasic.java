package Basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DogBasic {


    public static void main(String[] args) {

        RestAssured.baseURI = "https://dog.ceo/api";

        Response response = RestAssured.
                given().
                when().
                get("/breeds/list/all").
                then().
                log().all().
                statusCode(200).
                extract().
                response();


    }
}
