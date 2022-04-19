package api.stepdefinitions;

import api.utulities.JsonUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import ui.utulities.ConfigReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

/* EXPECTED DATA WILL BE AS BELOW
{
    "status": 200,
    "content": {
        "id": "1957",
        "title": "Enjoy Pizza Delmenhorst",
        "companyName": null,
        "areaCodes": [

        ],
        "rruleSetDelivery": "",
        "rruleSetPickup": "",
        "hoursDelivery": [

            {
                "day": 1,
                "start": "07:05:00",
                "end": "23:55:00",
                "breakStart": null,
                "breakEnd": null
            },

            {
                "day": 7,
                "start": "07:05:00",
                "end": "23:55:00",
                "breakStart": null,
                "breakEnd": null
            }
        ],
        "hoursPickup": [
            {
                "day": 0,
                "start": "09:00:00",
                "end": "23:59:00",
                "breakStart": null,
                "breakEnd": null
            },
            {
                "day": 7,
                "start": "07:00:00",
                "end": "23:59:00",
                "breakStart": null,
                "breakEnd": null
            }
        ],
        "specialTimes": {
            "yesterday": null,
            "tomorrow": null
        },
        "isMaintenance": false,
        "isMaintenanceApp": false,
        "paymentMethods": [
            {
                "id": "1",
                "name": "bar",
                "code": null,
                "localKey": "cash",
                "setting": [
                    {
                        "minPrice": 0,
                        "orderType": "Pickup"}]}]
}
}
 */

public class bremen_Page_paypal_Api_StepDefinitions {
    Logger log = (Logger) LogManager.getLogger(hermes_Api_Stepdefinitons.class);

    Response response;
    JsonPath jsonPath;
    String baseUrl="https://dev.delivery-app.app-smart.services/api3/1/branches/1957?uniq%5B%5D=paypal";
    HashMap<String,Object> expectedData;
    HashMap<String,Object> actualData;
    List<Integer> responsePaymentMethods_IdList;

    @Given("Send Get request for Bremen Url_Page paypal address")
    public void sendGetRequestForBremenUrl_PagePaypalAddress() {
        response=given().accept(ContentType.JSON).when().get(baseUrl);

            log.info("Response is created");
        response.prettyPrint();
    }

    @When("Create your expectedData in JsonUtil_Format")
    public void createYourExpectedDataInJsonUtil_Format() {
        String JsonObject="{\n" +
                "    \"status\": 200,\n" +
                "    \"content\": {\n" +
                "        \"id\": \"1957\",\n" +
                "        \"title\": \"Enjoy Pizza Delmenhorst\",\n" +
                "        \"companyName\": null,\n" +
                "        \"areaCodes\": [\n" +
                "            \n" +
                "        ],\n" +
                "        \"rruleSetDelivery\": \"\",\n" +
                "        \"rruleSetPickup\": \"\",\n" +
                "        \"hoursDelivery\": [\n" +
                "            {\n" +
                "                \"day\": 7,\n" +
                "                \"start\": \"07:05:00\",\n" +
                "                \"end\": \"23:55:00\",\n" +
                "                \"breakStart\": null,\n" +
                "                \"breakEnd\": null\n" +
                "            }\n" +
                "        ],\n" +
                "        \"hoursPickup\": [\n" +
                "            {\n" +
                "                \"day\": 0,\n" +
                "                \"start\": \"09:00:00\",\n" +
                "                \"end\": \"23:59:00\",\n" +
                "                \"breakStart\": null,\n" +
                "                \"breakEnd\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"day\": 7,\n" +
                "                \"start\": \"07:00:00\",\n" +
                "                \"end\": \"23:59:00\",\n" +
                "                \"breakStart\": null,\n" +
                "                \"breakEnd\": null\n" +
                "            }\n" +
                "        ],\n" +
                "        \"specialTimes\": {\n" +
                "            \"yesterday\": null,\n" +
                "            \"tomorrow\": null\n" +
                "        },\n" +
                "        \"isMaintenance\": false,\n" +
                "        \"isMaintenanceApp\": false,\n" +
                "        \"paymentMethods\": [\n" +
                "            {\n" +
                "                \"id\": \"1\",\n" +
                "                \"name\": \"bar\",\n" +
                "                \"code\": null,\n" +
                "                \"localKey\": \"cash\",\n" +
                "                \"setting\": [\n" +
                "                    {\n" +
                "                        \"minPrice\": 0,\n" +
                "                        \"orderType\": \"Pickup\"}]}]\n" +
                "}\n" +
                "}\n";
            log.info("Expected Data created in JsonUtil Format");
        expectedData=JsonUtil.convertJsonToJava(JsonObject,HashMap.class);

        System.out.println("Expected Data========"+expectedData);

        actualData=JsonUtil.convertJsonToJava(response.asString(),HashMap.class);
            log.info("Response is converted Data for Actual Data (JsonUtil)");

        System.out.println("Actual Data==="+actualData);
    }

    @Then("Verify that status code is {int}")
    public void verifyThatStatusCodeIs(int expected_status_code) {

        Assert.assertEquals(expected_status_code,response.statusCode());
            log.info("Status is the as expected "+ expected_status_code);  //these assert directly with specific number;
    }


    @Then("Verify that content id is {string}")
    public void verifyThatContentIdIs(String contend_id) {
        Assert.assertEquals(contend_id, ((Map)actualData.get("content")).get("id"));
            log.info("Content Id is verified. It is same as " + contend_id);
    }

    @Then("Verify that the content {string} is the same as the expected data and response data")
    public void verifyThatTheContentIDIsTheSameAsTheExpectedDataAndResponseData(String content_body) {

        Assert.assertEquals(((Map)expectedData.get("content")).get(content_body),((Map)actualData.get("content")).get(content_body));
            log.info("Expected data is "+((Map)expectedData.get("content")).get("id")+ ",  Actual data is " +((Map)actualData.get("content")).get("id")+ "  They are same");
    }

    @Then("Verify that content title is {string}")
    public void verifyThatContentTitleIs(String title) {
        Assert.assertEquals(title,((Map)actualData.get("content")).get("title"));
            log.info("Content title is verified. It is same as " + title);
    }

    @Then("Verify that the response payment Methods id list size is the same as expected")
    public void verifyThatTheResponsePaymentMethodsIdListSizeIsTheSameAsExpected() {
        jsonPath=response.jsonPath();   //In this line Json Format is used
        responsePaymentMethods_IdList=jsonPath.getList("content.paymentMethods.id");
        System.out.println(responsePaymentMethods_IdList);

        Assert.assertEquals((Integer.parseInt(ConfigReader.getProperty("expected_content.paymentMethods.id"))),
                responsePaymentMethods_IdList.size());           //expected content paymentMethods Id data will come from configuration Properties
            log.info("Response payment Methods List size is verified ");
    }

    @Then("Verify that the response payment Methods id list has expected list")
    public void verifyThatTheResponsePaymentMethodsIdListHasExpectedList() {

        List<String> expectedList=new ArrayList<>();
        expectedList.add("1");
        System.out.println(expectedList);

        Assert.assertTrue(responsePaymentMethods_IdList.containsAll(expectedList));
            log.info("Response payment Methods has expected list ");
    }


    @Then("Verify that response payment Methods id_1 name is {string}")
    public void verifyThatResponsePaymentMethodsIdNameIs( String name) {
        jsonPath=response.jsonPath();
        System.out.println(jsonPath.getString("content.paymentMethods[0]"));
        Assert.assertEquals(jsonPath.getString("content.paymentMethods[0].name"),name);
            log.info("response payment Methods id-1 name is verified");
    }
}
