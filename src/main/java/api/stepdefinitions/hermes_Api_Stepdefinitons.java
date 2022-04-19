package api.stepdefinitions;

import api.utulities.TestBaseHermes;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import ui.stepdefinitions.bugReport_Stepdefinitions;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class hermes_Api_Stepdefinitons extends TestBaseHermes {

    Logger log = (Logger) LogManager.getLogger(hermes_Api_Stepdefinitons.class);

    Response response;
    JsonPath jsonPath;
    String baseUrl="https://dev.delivery-app.app-smart.services/api2.5/cdMiu0eNA2OJ58Z3/get-single-product/159/25448";

    @When("Get request for api")
    public void getRequestForApi() {
        response=given().accept(ContentType.JSON).when().get(baseUrl);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        log.info("Status Code is verified");

        jsonPath=response.jsonPath();

    }
}