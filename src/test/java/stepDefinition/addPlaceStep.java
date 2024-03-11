package stepDefinition;

import Pojo.AddPlacePojo.AddPlacePayload;
import Pojo.AddPlacePojo.Location;
import TestData.APIResources;
import TestData.TestDataBuilder;
import TestData.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class addPlaceStep extends Utils {
    RequestSpecification res;
    Response response;
    TestDataBuilder dataBuilder = new TestDataBuilder();

    static String place_id;

    @Given("Add AddPlace payload with {string}, {string} and {string}")
    public void addAddPlacePayloadWithAnd(String name, String language, String address) throws IOException {
        res = given().spec(requestSpecification()).body(dataBuilder.addPlaceLoad(name,language,address));
    }

    @When("User calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String apiResource, String requestType) {
        APIResources resourceAPI = APIResources.valueOf(apiResource);
        if (requestType.equalsIgnoreCase("POST")) {
            response = res.when().post(resourceAPI.getResource());
        } else if (requestType.equalsIgnoreCase("DELETE")) {
            response = res.when().delete(resourceAPI.getResource());
        } else if(requestType.equalsIgnoreCase("GET")) {
            response = res.when().get(resourceAPI.getResource());
        }
    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        Assert.assertEquals(getJsonPath(response,key),value);
    }

    @And("Verify place_Id created maps to {string} using {string}")
    public void verifyPlace_IdCreatedMapsToUsing(String name, String APIName) throws IOException {
        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id",place_id);
        userCallsWithHttpRequest(APIName, "GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(name,actualName);
    }

    @Given("DeletePlace Payload")
    public void deletePlacePayload() throws IOException {
        res = given().spec(requestSpecification().body(dataBuilder.deletePlacePay(place_id)));
    }
}