package com.prowings;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Java11HttpClientDemo {

	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		//Lets prepare the HttpRequest
		
		HttpRequest getReq = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/my-first-rest-api-using-spring-mvc/students/11"))
				.build();
		
		HttpClient client = HttpClient.newBuilder()
				.build();
		
		HttpResponse<String> response = client.send(getReq, BodyHandlers.ofString());
		
		System.out.println(response.body());
		System.out.println(response.statusCode());
	}

}
