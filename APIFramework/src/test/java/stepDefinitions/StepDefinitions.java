package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Add_Place;
import pojo.location;
import resources.API_enum_resources;
import resources.TestDataBuild;
import resources.Utils;
import bdd.APIFramework.*;

public class StepDefinitions extends Utils{
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	static Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_Id;
	
	@Given("Add Place Payload")
	public void add_Place_Payload() throws IOException {
		reqSpec = requestSpecification();
		resSpec = responseSpecification();
	}

	@When("user calls {string} with {string} http request with {string} {string} {string}")
	public void user_calls_with_http_request_with(String resource_URL, String http_method, String name, String language, String address) {
		API_enum_resources resource_API = API_enum_resources.valueOf(resource_URL);
		
		switch (http_method){
		
			case ("POST"):
				response = given().spec(reqSpec).body(data.addPlacePayload(name,language,address)).post(resource_API.getResource())
				.then().spec(resSpec).extract().response();	
				break;
			
			case ("GET"):
				response = given().spec(reqSpec).get(resource_API.getResource());
				break;
			
			case ("DELETE"):
				break;
				
			case ("PUT"):
				break;
		}
		
		System.out.println(response.asString());

	}

	@Then("the API call is successful with status code {int}")
	public void the_API_call_is_successful_with_status_code(Integer statusCode) {
	    assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		assertEquals(ReusableMethods.payloadVar2Val(response.asString(), key), value);
	}
	
	@Then("verify place_Id created maps to with {string} using {string}")
	public void verify_place_Id_created_maps_to_with_using(String name, String resource_URL) throws IOException {
		place_Id = ReusableMethods.payloadVar2Val(response.asString(), "place_id");
		String nm = ReusableMethods.payloadVar2Val(response.asString(), "name");
		String lang=ReusableMethods.payloadVar2Val(response.asString(), "language");
		String addr=ReusableMethods.payloadVar2Val(response.asString(), "address");
		API_enum_resources resource_API = API_enum_resources.valueOf(resource_URL);
		
		reqSpec = requestSpecification().queryParam("place_id",place_Id );
		
		user_calls_with_http_request_with(resource_URL, "GET", nm, lang, addr);
		assertEquals(ReusableMethods.payloadVar2Val(response.asString(), "name"),nm);
	}

	@Given("Delete Place Payload")
	public void delete_Place_Payload() throws IOException {
		reqSpec = given().spec(requestSpecification())
				.body(data.delete_Place(place_Id));
	}
	
}
