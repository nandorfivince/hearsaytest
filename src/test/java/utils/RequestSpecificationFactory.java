package utils;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.Config.isSecuredEnvironment;

public class RequestSpecificationFactory {

    public RequestSpecification create() {
        if (isSecuredEnvironment()) {
            return given().relaxedHTTPSValidation();
        } else {
            return given().auth().preemptive().basic("username", "pwd");
        }
    }

}
