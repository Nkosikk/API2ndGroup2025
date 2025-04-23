package RequestBuilder;
import io.restassured.response.Response;
import static Common.BasePaths.dogs_baseURI;
import static io.restassured.RestAssured.given;

public class DogsRequestBuilder {

    public static Response listAllBreedsRequest(){

        Response response = given()
                .when()
                .log().all()
                .get(dogs_baseURI +"/breeds/list/all")
                .then()
                .extract()
                .response();

        return response;
    }

    public  static Response randomDogImageRequest(){

        return given()
                .when()
                .log().all()
                .get(dogs_baseURI +"/breeds/image/random")
                .then()
                .extract().response();
    }

    public  static Response byBreedRequest(){

        return given()
                .when()
                .log().all()
                .get(dogs_baseURI +"/breed/hound/images")
                .then()
                .extract().response();
    }
}
