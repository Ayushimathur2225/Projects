package com.howtodoinjava.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

public class TestEmployeeController {
	@Test
	public void testGetEmployeeListSuccess() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    String randomServerPort = "8081";
		final String baseUrl = "http://localhost:" + randomServerPort + "/employees/";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("employeeList"));
	}
}
