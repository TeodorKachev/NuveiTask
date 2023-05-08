package com.github.api.common;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.github.api.constants.Auth;
import com.github.api.constants.Path;
import com.github.api.constants.Repos;
import com.github.api.models.CreateRepositoryModel;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class RestUtilities {
	public static String ENDPOINT;
	public static RequestSpecBuilder REQUEST_BUILDER;
	public static RequestSpecification REQUEST_SPEC;
	public static ResponseSpecBuilder RESPONSE_BUILDER;
	public static ResponseSpecification RESPONSE_SPEC;
	
	/***
	 * Returns RequestSpecification object with common properties set
	 * 
	 * @param isTokenCorrect	- when false returns RequstSpecification with invalid token
	 * @return					- common RequestSpecification object
	 */
	public static RequestSpecification getRequestSpecification(boolean isTokenCorrect) {
		REQUEST_BUILDER = new RequestSpecBuilder();
		REQUEST_BUILDER.setBaseUri(Path.BASE_URI);
		
		if (isTokenCorrect) {
			REQUEST_BUILDER.addHeader("Authorization", "Bearer " + Auth.BEARER_TOKEN);
		} else {
			REQUEST_BUILDER.addHeader("Authorization", "Bearer " + "");
		}
		
		REQUEST_SPEC = REQUEST_BUILDER.build();
		return REQUEST_SPEC;
	}
	
	/***
	 * Returns ResponseSpecification object with common properties set 
	 * 
	 * @return	- common ResponseSpecification object
	 */
	public static ResponseSpecification getResponseSpecification() {
		RESPONSE_BUILDER = new ResponseSpecBuilder();
		RESPONSE_BUILDER.expectResponseTime(lessThan(2L), TimeUnit.SECONDS);
		RESPONSE_SPEC = RESPONSE_BUILDER.build();
		return RESPONSE_SPEC;
	}
	
	/***
	 * Adds multiple path parameters to existing request specification
	 * 
	 * @param reqSpec	- existing request specification object
	 * @param queryMap	- path parameters to add
	 * @return			- returns request specification object updated with path 
	 * 				      parameter
	 */
	public static RequestSpecification createPathParams(RequestSpecification reqSpec,
			Map<String, String> queryMap) {
		return reqSpec.pathParams(queryMap);
	}
	
	public static CreateRepositoryModel getRepoBody(boolean isExisting) {
		CreateRepositoryModel createRepository = new CreateRepositoryModel();
		if (isExisting) {
			createRepository.setName(Repos.EXISTING_REPO);
		} else {
			createRepository.setName(Repos.REPO);
		}

		createRepository.setDescription(Repos.DESCRIPTION);
		createRepository.setHomepage(Repos.HOMEPAGE);
		createRepository.setPrivate(Repos.IS_PRIVATE);
		createRepository.setTemplate(Repos.IS_TEMPLATE);
		return createRepository;
	}
}
