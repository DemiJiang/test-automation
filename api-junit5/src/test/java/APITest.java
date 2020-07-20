import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@WithAccessToken
class APITest {
    private String accessToken;

      @BeforeEach
  void getToken(){
      accessToken =
              given().
                      auth().preemptive().basic("username","password")
                      .contentType("application/x-www-form-urlencoded")
                      .formParam("grant_type", "")
                      .formParam("resource", "")
                      .when().post("tokenURL")
                      .then()
                      .extract()
                      .path("access_token");
  }
    @Test
    void returnExpectedPayload(String accessToken){
        given()
                .auth().oauth2(accessToken)
                .contentType("application/json")
                .when()
                .get(Base.baseUrl_SIT + "invoiceUrl")
                .then()
                .log()
                .body()
                .statusCode(200)
                .assertThat()
                .body("meta.page", equalTo(1));
    }
}


