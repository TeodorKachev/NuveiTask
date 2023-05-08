package com.github.api.repos;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.api.common.RestUtilities;
import com.github.api.constants.Path;
import com.github.api.constants.Repos;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetRepositoryNegative {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	Map<String, String> pathParams = new HashMap<String, String>();
	
	@BeforeClass
	public void beforeClass() {
		reqSpec = RestUtilities.getRequestSpecification(true);
		
		resSpec = RestUtilities.getResponseSpecification();
	}
	
	@Test
	public void getNotExistingRepository() {
		reqSpec.basePath(Path.REPOS);
		given()
			.spec(RestUtilities.createPathParams(reqSpec, createPathParamsMap("")))
			.log().ifValidationFails()
		.when()
			.get("/{owner}/{repo}")
		.then()
			.spec(resSpec)
			.statusCode(404)
			.body("message", equalTo("Not Found"))
			.log().ifError();
	}
	
	@Test (dependsOnMethods={"getNotExistingRepository"})
	public void getNotAuthRepository() {
		reqSpec = RestUtilities.getRequestSpecification(false);
		reqSpec.basePath(Path.REPOS);
		given()
			.spec(RestUtilities.createPathParams(reqSpec, createPathParamsMap("VideoShop")))
			.log().ifValidationFails()
		.when()
			.get("/{owner}/{repo}")
		.then()
			.spec(resSpec)
			.statusCode(401)
			.body("message", equalTo("Bad credentials"))
			.log().ifError();
	}
	
	private Map<String, String> createPathParamsMap(String repo) {
		pathParams.put("owner", Repos.OWNER);
		pathParams.put("repo", repo);
		return pathParams;
	}
}
