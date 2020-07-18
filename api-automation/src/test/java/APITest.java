import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.*;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.DOUBLE;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class APITest {
    @BeforeEach
    void setNumberReturnType() {
        config = newConfig().jsonConfig(jsonConfig().numberReturnType(DOUBLE));
    }


    @Test
    public void returnExpectedPayload(){
        given()
//                .auth().oauth2()
                .contentType("application/json")
                .when()
                .get(Base.baseUrl_SIT + "us/90210")
                .then()
                .log()
                .body()
                .statusCode(200)
                .assertThat()
                .body("places.state", hasItems("California"))
                .body("country", equalTo("United States"))
                .body("places.latitude", hasItems("34.0901"));
    }


}
