package steps;


import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.given;

@Log4j2
public class BaseSteps {

    public ValidatableResponse postRequest(String body, String myPath) {
        if(body == null || body.isEmpty()) {
            body = "{}";
        }
        log.info("body: " + body);
        ValidatableResponse response = given().log().all().body(body).header("Authorization","Bearer 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").contentType("application/json;charset=UTF-8").post(myPath).then().log().all();
        log.info(String.format("URL for request : \"%s\"", myPath));
        //log.info(response.asString());
         //Allure.step("response:\n" + response.asString());
        return response;
    }

    public Response getRequest(RequestSpecification specification, String url) {
        Response response = specification.get(url);
        log.info(String.format("URL for request : \"%s\"", url));
        Allure.step(String.format("URL for request : \"%s\"", url));
        Allure.step("response:\n" + response.asString());
        return response;
    }

    public JsonPath rawToJson(Response response) {
        String responseString = response.asString();
        return new JsonPath(responseString);
    }


}
