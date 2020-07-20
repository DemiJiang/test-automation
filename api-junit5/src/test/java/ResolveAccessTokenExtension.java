import io.restassured.response.Response;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import static io.restassured.RestAssured.given;

public class ResolveAccessTokenExtension implements ParameterResolver {
    private static final int GRACE_PERIOD_IN_SECONDS = 15;
    private String accessToken;
    private int expiresInSeconds = 0;
    private long issuedAt = 0;

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == String.class
                && parameterContext.getParameter().getName().equals("accessToken");
    }

    @Override
    public synchronized Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        if (accessToken != null
                && (System.currentTimeMillis() - issuedAt) < (expiresInSeconds - GRACE_PERIOD_IN_SECONDS) * 1000) {
            return accessToken;
        }
        System.out.println("ResolveAccessTokenExtension: token expired or not exist, will fetch it.");

        Response response =
                given().
                        auth().preemptive().basic("username","password")
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("grant_type", "")
                        .formParam("resource", "")
                        .when().post("tokenURL")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
        accessToken = response.path("access_token");
        expiresInSeconds = response.path("expires_in");
        issuedAt = System.currentTimeMillis();
        System.out.println(accessToken);
        return accessToken;
    }
}
