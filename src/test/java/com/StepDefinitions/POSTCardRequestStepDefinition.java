package com.StepDefinitions;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.factory.Objectfactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.PropReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import junit.framework.Assert;

import com.POJO_Classes.POST_Card;
import com.factory.*;


public class POSTCardRequestStepDefinition {

	Objectfactory factory;
	private String finalresponse;
	// Assigning the mapper as the object mapper
	ObjectMapper mapper;
	PropReader reader = new PropReader();
	
	//creating the object of POJO class which 
	POST_Card postcard = new POST_Card();
	
	public POSTCardRequestStepDefinition(Objectfactory factory) {
		
		this.factory = factory;
		
	}
	
	
	@Given("Trello APIs are operational and running")
	public void trello_apis_are_operational_and_running() throws Exception {
	 
		Thread.sleep(5000);
		factory.setRequestSpecification(RestAssured.given().queryParam("key", reader.getString("Key")).queryParam("token", reader.getString("Token")).queryParam("name", reader.getString("CardName")));
		
	}

		@When("{string} as URI {string} as API key and {string} as token is passed as a query params with {string} as end points")
		public void as_api_key_and_as_token_is_passed_as_a_query_params_with_as_end_points(String uri, String apikey, String token, String endpoints) throws Exception {

			uri = reader.getString("URI");
			System.out.println(uri + endpoints);
			factory.setResponse(factory.getRequestSpecification().post(uri+endpoints));
			
		}
	
	@When("payload is prepared")
	public void payload_is_prepared() throws Exception {
	   
		
		mapper = new ObjectMapper();
		postcard.setName(reader.getString("CardName"));
		postcard.setDefaultLabels(true);
		postcard.setDefaultLists(false);
		postcard.setDesc("This is the description");
		
		try {
			
			// converting create repo object into string
			this.finalresponse = mapper.writeValueAsString(this.postcard);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		factory.setRequestSpecification(factory.getRequestSpecification().body(finalresponse));
	}
		

	@Then("Response is sent back by server")
	public void response_is_sent_back_by_server() {

		System.out.println(factory.getResponse().then().log().all());	
	}
}
