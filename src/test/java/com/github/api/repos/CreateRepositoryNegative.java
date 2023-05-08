package com.github.api.repos;

import org.testng.annotations.Test;

import com.github.api.common.RestUtilities;
import com.github.api.constants.Path;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.BeforeClass;

public class CreateRepositoryNegative {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;

	
	@BeforeClass
	public void beforeClass() {
		reqSpec = RestUtilities.getRequestSpecification(true);
		
		resSpec = RestUtilities.getResponseSpecification();
	}
	
	@Test 
	public void createRepositoryBadRequest() {
		reqSpec.basePath(Path.USER_REPOS);
		
		given()
			.spec(reqSpec)
			.log().ifValidationFails()
		.when()
			.post()
		.then()
			.spec(resSpec)
			.statusCode(400)
			.body("message", equalTo("Body should be a JSON object"))
			.log().ifError();
	}
	
	@Test 
	public void createRepositoryAgain() {
		reqSpec.basePath(Path.USER_REPOS);
		
		given()
			.spec(reqSpec)
			.body(RestUtilities.getRepoBody(true))
			.log().ifValidationFails()
		.when()
			.post()
		.then()
			.spec(resSpec)
			.statusCode(422)
			.body("message", equalTo("Repository creation failed."))
			.body("errors.message", hasItem("name already exists on this account"))
			.log().ifError();
	}
	
	@Test (dependsOnMethods={"createRepositoryAgain", "createRepositoryBadRequest"})
	public void createRepositoryNotAuth() {
		reqSpec = RestUtilities.getRequestSpecification(false);
		reqSpec.basePath(Path.USER_REPOS);
		
		given()
			.spec(reqSpec)
			.body(RestUtilities.getRepoBody(false))
			.log().ifValidationFails()
		.when()
			.post()
		.then()
			.spec(resSpec)
			.statusCode(401)
			.body("message", equalTo("Bad credentials"))
			.log().ifError();
	}

}
