package com.github.api.repos;

import org.testng.annotations.Test;

import com.github.api.common.RestUtilities;
import com.github.api.constants.Path;
import com.github.api.constants.Repos;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

/***
 * Creates, gets and deletes GitHub repository
 * 
 * @author Teodor Kachev
 *
 */
public class EndToEndTest {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	Map<String, String> pathParams = new HashMap<String, String>();
	

	@BeforeClass
	public void beforeClass() {
		reqSpec = RestUtilities.getRequestSpecification(true);
		
		resSpec = RestUtilities.getResponseSpecification();
	}
	
	@Test
	public void createRepository() {
		reqSpec.basePath(Path.USER_REPOS);
		
		given()
			.spec(reqSpec)
			.body(RestUtilities.getRepoBody(false))
			.log().ifValidationFails()
		.when()
			.post()
		.then()
			.spec(resSpec)
			.statusCode(201)
			.log().ifError();
	}
	
	@Test (dependsOnMethods={"createRepository"})
	public void getRepository() {
		reqSpec.basePath(Path.REPOS);
		given()
			.spec(RestUtilities.createPathParams(reqSpec, createPathParamsMap()))
			.log().ifValidationFails()
		.when()
			.get("/{owner}/{repo}")
		.then()
			.spec(resSpec)
			.statusCode(200)
			.body("name", equalTo(Repos.REPO))
			.body("description", equalTo(Repos.DESCRIPTION))
			.body("html_url", containsString(Repos.HOMEPAGE))
			.log().ifError();
	}
	
	@Test (dependsOnMethods={"getRepository"})
//	@Test
	public void deleteRepository() {
		reqSpec.basePath(Path.REPOS);
		given()
		.spec(RestUtilities.createPathParams(reqSpec, createPathParamsMap()))
			.log().ifValidationFails()
		.when()
			.delete("/{owner}/{repo}")
		.then()
			.spec(resSpec)
			.statusCode(204)
			.log().ifError();
	}
	
	private Map<String, String> createPathParamsMap() {
		pathParams.put("owner", Repos.OWNER);
		pathParams.put("repo", Repos.REPO);
		return pathParams;
	}
}
