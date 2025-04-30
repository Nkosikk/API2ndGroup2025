package RequestBuilder;
import io.restassured.response.Response;
import static Common.BasePaths.dogs_baseUrl;
import static io.restassured.RestAssured.given;

public class DogsRequestBuilder {

    public static Response listAllBreedsRequest(){

        Response response = given()
                .when()
                .log().all()
                .get(dogs_baseUrl +"/breeds/list/all")
                .then()
                .extract()
                .response();

        return response;
    }

    public  static Response randomDogImageRequest(){

        return given()
                .when()
                .log().all()
                .get(dogs_baseUrl +"/breeds/image/random")
                .then()
                .extract().response();
    }

    public  static Response byBreedRequest(){

        return given()
                .when()
                .log().all()
                .get(dogs_baseUrl +"/breed/hound/images")
                .then()
                .extract().response();
    }
}
