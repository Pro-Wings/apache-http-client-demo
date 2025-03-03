package com.prowings;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApacheHttpClientDemo {


	public static void main(String[] args) throws ClientProtocolException, IOException{
		

		//http://localhost:8080/my-first-rest-api-using-spring-mvc/prowings/employees/5
		
		CloseableHttpClient client = HttpClients.createDefault();
		
//		HttpGet get = new HttpGet("http://localhost:8080/my-first-rest-api-using-spring-mvc/prowings/employees/8");
//		get.setHeader(HttpHeaders.ACCEPT, "application/json");
//		get.setHeader("company", "prowings");
//		CloseableHttpResponse response = client.execute(get);
//
//		String res = EntityUtils.toString(response.getEntity());
//
//		System.out.println(res);
		
		HttpPost post = new HttpPost("http://localhost:8080/my-first-rest-api-using-spring-mvc/prowings/employees");

		final String json = "{ \"name\":\"Sachin555\",\"address\":\"Kolhapur\",\"salary\":\"99999\"}";

		final StringEntity entity = new StringEntity(json);
		post.setHeader("Content-type", "application/json");
		post.setHeader(HttpHeaders.ACCEPT, "application/json");

		post.setEntity(entity);
		
		CloseableHttpResponse postResponse = client.execute(post);
		String postRes = EntityUtils.toString(postResponse.getEntity());
		System.out.println(postRes);
		System.out.println("Response Code : "+postResponse.getStatusLine().getStatusCode());
		System.out.println("Response Headers : ");
		Header[] headers = postResponse.getAllHeaders();
		for (Header header : headers) {
			System.out.println(header.getName() + " : " + header.getValue());
		}

	}
		
	
}
