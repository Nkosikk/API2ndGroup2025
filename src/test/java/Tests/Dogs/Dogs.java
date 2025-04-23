package Tests.Dogs;
import RequestBuilder.DogsRequestBuilder;
import jdk.jfr.Description;
import org.testng.annotations.Test;

@Test
public class Dogs {

    @Description("Get a list of all breeds")
    public  void listAllBreedsTest(){
        DogsRequestBuilder.listAllBreedsRequest().
                then().
                log().all().
                assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK");

    }

    public void responseBodyTest(){
        DogsRequestBuilder.listAllBreedsRequest().
                then().
                log().all().
                assertThat().
                body("message",org.hamcrest.Matchers.notNullValue()).
                body("status",org.hamcrest.Matchers.equalToIgnoringCase("Success"));
    }

    @Description("Get a random dog image")
    public void randomDogImageTest(){
        DogsRequestBuilder.randomDogImageRequest().
                then().
                log().all().
                assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                body("message",org.hamcrest.Matchers.notNullValue()).
                body("status",org.hamcrest.Matchers.equalToIgnoringCase("Success")).
                body("message",org.hamcrest.Matchers.containsString(".jpg"));
    }

    public void listByBreedTest(){
        DogsRequestBuilder.byBreedRequest().
                then().
                log().all().
                assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                body("message",org.hamcrest.Matchers.notNullValue()).
                body("status",org.hamcrest.Matchers.equalToIgnoringCase("success"));
    }
}
