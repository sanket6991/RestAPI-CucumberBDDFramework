package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.utils;

public class StepDefination extends utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();


	@Given("Add Place Payload with {string} {string} {string} {string} {string}")
	public void add_place_payload_with(String name, String phone_number, String address, String website, String language) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	
	
		res = given().spec(RequestSpecifications()).body(data.addPlacePayload(name, phone_number, address, website, language));

		// System.out.println("one");
		// throw new io.cucumber.java.PendingException();
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with__http_request(String resource, String method) {
		// Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST")) {
		response = res.when().post(resourceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getResource());
			}
		
		// System.out.println("two");
		// throw new io.cucumber.java.PendingException();
	}

	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		// System.out.println("three");
		assertEquals(response.getStatusCode(), 200);
		// throw new io.cucumber.java.PendingException();
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
		// Write code here that turns the phrase above into concrete actions
		
		assertEquals(getJsonPath(response, keyValue), ExpectedValue);
		// System.out.println("four");
		// throw new io.cucumber.java.PendingException();
	}
	@Then("Verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		place_id = getJsonPath(response,"place_id");
		res = given().spec(RequestSpecifications()).queryParam("place_id", place_id);
		user_calls_with__http_request(resource, "GET");
		String actualname = getJsonPath(response,"name");
		System.out.println();
		assertEquals(actualname,expectedName);
	 //	   throw new io.cucumber.java.PendingException();
	}
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		res = given().spec(RequestSpecifications()).body(data.deletePlacePayload(place_id));
		
	}


}
