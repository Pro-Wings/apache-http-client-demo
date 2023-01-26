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
		
		
		//http://localhost:8080/students/30
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpGet get = new HttpGet("http://localhost:8080/students/30");
		
		CloseableHttpResponse response = client.execute(get);

		String res = EntityUtils.toString(response.getEntity());

		System.out.println(res);
		
		HttpPost post = new HttpPost("http://localhost:8080/students");
		//    "{ "roll": 30,"name": "ABC","address": "Mumbai" }"
		final String json = "{\"roll\":40,\"name\":\"Sham\",\"address\":\"Mumbai\"}";
		final StringEntity entity = new StringEntity(json);
		post.setHeader("Content-type", "application/json");
		post.setEntity(entity);
		
		CloseableHttpResponse postResponse = client.execute(post);
		String postRes = EntityUtils.toString(postResponse.getEntity());
		System.out.println(postRes);

	}
		
	
}
