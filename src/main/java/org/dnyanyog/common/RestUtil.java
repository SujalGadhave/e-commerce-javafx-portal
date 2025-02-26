package org.dnyanyog.common;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtil {
	
	// Marshaling
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String postRequest(String url, String body) throws IOException, InterruptedException {
		// RestClient
		HttpClient client = HttpClient.newHttpClient();
		
		// Request 
		HttpRequest request = HttpRequest
								.newBuilder()
								.uri(URI.create(url))
								.header("Content-Type", "application/json")
								.POST(HttpRequest.BodyPublishers.ofString(body))
								.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return response.body();
	}
	
	
	// Post Request
	public static <T>T post(String url, Object objectBody, Class<?> responseClassType) throws IOException, InterruptedException {
		
		String body = objectMapper.writeValueAsString(objectBody);
		
		// RestClient 
		HttpClient client = HttpClient.newHttpClient();
		
		// Request 
		HttpRequest request = HttpRequest
								.newBuilder()
								.uri(URI.create(url))
								.header("Content-Type", "application/json")
								.POST(HttpRequest.BodyPublishers.ofString(body))
								.build();
		
		// Response 
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		@SuppressWarnings("unchecked")
		T responseObject = (T) objectMapper.readValue(response.body(), responseClassType);
		
		// Print
		return responseObject;
	}
	
	// Get request
	public static <T>T get(String url, Class<T> responseClassType) throws IOException, InterruptedException {
	    
		HttpClient client = HttpClient.newHttpClient();
		
	    HttpRequest request = HttpRequest
	    						.newBuilder()
	    						.uri(URI.create(url))
	    						.header("Content-Type", "application/json")
	    						.GET()
	    						.build();
	    
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	    return objectMapper.readValue(response.body(), responseClassType);
	}

	
	// Put request
	public static <T>T put(String url, Object objectBody, Class<?> responseClassType) throws IOException, InterruptedException {
		
		String body = objectMapper.writeValueAsString(objectBody);
		
		// RestClient 
		HttpClient client = HttpClient.newHttpClient();
		
		// Request 
		HttpRequest request = HttpRequest
								.newBuilder()
								.uri(URI.create(url))
								.header("Content-Type", "application/json")
								.PUT(HttpRequest.BodyPublishers.ofString(body))
								.build();
		
		// Response 
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		@SuppressWarnings("unchecked")
		T responseObject = (T) objectMapper.readValue(response.body(), responseClassType);
		
		// Print
		return responseObject;
	}
	
	// Delete Request
	public static <T>T delete(String url, Object objectBody, Class<?> responseClassType) throws IOException, InterruptedException {
		
		//RestClient
		HttpClient client = HttpClient.newHttpClient();
		
		//Request
		HttpRequest request = HttpRequest
								.newBuilder()
								.uri(URI.create(url))
								.DELETE()
								.build();
		
		//Response
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		@SuppressWarnings("unchecked")
		T objectResponse = (T) objectMapper.readValue(response.body(), responseClassType);
		
		return objectResponse;
	}
}
