package api.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class hermes_American_singleProduct_Api_StepDefinitions {
    Logger log = (Logger) LogManager.getLogger(hermes_American_singleProduct_Api_StepDefinitions.class);
    Response response;

    @Given("Send Get request for American get-single-product baseUrl")
    public void send_get_request_for_american_get_single_product() {
        String baseUrl = "https://dev.delivery-app.app-smart.services/api2.5/cdMiu0eNA2OJ58Z3/get-single-product/159/25448";

        response = given()
                .accept("application/json")
                .when()
                .get(baseUrl);
            log.info("=====Response  is success============");

        response.prettyPrint();
            log.info("Response  is success");
    }
    @Then("Assert status code is {int}")
    public void assert_status_code_is(Integer expectedStatusCode) {

        response.then().assertThat().statusCode(expectedStatusCode);

           log.info("=====Status Code is same as  "+expectedStatusCode);
    }

    @Then("Assert success is true")
    public void assert_success_is_true() {

        response.then().body("success", equalTo(true));   //Matchers Class
            log.info("body success is verified as "+ true);
    }

    @Then("Assert checksum is {string}")
    public void assertChecksumIs(String checksum_number) {

        response.then().body("checksum", equalTo(checksum_number));
            log.info("body checksum is verified as "+ checksum_number);

    }
    @Then("Assert branch_id is {int}")
    public void assert_branch_id_is(Integer branchId_Num) {

        response.then().body("branch_id", equalTo(branchId_Num));
            log.info("body branch_id is verified as "+ branchId_Num);

    }
    @Then("Assert product_id is {int}")
    public void assert_product_id_is(Integer product_Id_Num) {
        response.then().body("product_id", equalTo(product_Id_Num));
            log.info("body product_id is verified as "+ product_Id_Num);
    }

    @Then("Assert d name is {string}")
    public void assertDNameIs(String name) {

        response.then().body("d.name", equalTo(name));
            log.info("body d.name verified as "+ name);

    }

    @Then("Assert d isCombo is false")
    public void assertDIsComboIsFalse() {

        response.then().body("d.isCombo",equalTo(false));
            log.info("body d.isCombo verified as "+false);
    }

    @Then("Assert Additives has {string}")
    public void assertAdditivesHas(String additives_num) {
        response.then().body("d.additives",hasItems(additives_num));
            log.info("body d.isCombo verified as "+additives_num);

    }
}
