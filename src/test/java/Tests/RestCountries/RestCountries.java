package Tests.RestCountries;

import RequestBuilder.RestCountriesRequestBuilder;
import org.testng.annotations.Test;

public class RestCountries {
@Test
    public void GetRestCountriesTests(){
        RestCountriesRequestBuilder.GetRestCountriesResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }
    @Test
    public void VerifyTotalNumberOfCountriesTests(){
        RestCountriesRequestBuilder.VerifyTotalNumberOfCountriesResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }
    @Test
    public void VerifySignLanguageIsOfficialLanguageTests(){
        RestCountriesRequestBuilder.VerifySignLanguageIsOfficialLanguageResponse()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK");
    }
}
