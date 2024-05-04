package com.java.practice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncRestApiCall {
    public static void main(String[] args) {
        // Replace with your API endpoint URL
        String apiUrl = "https://api.example.com/data";
     // Replace with your callback URL
        String callbackUrl = "https://your-callback-url.com/callback";

        try {
            // Create an HTTP client
            HttpClient httpClient = HttpClient.newHttpClient();

            // Create an HTTP request
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            // Send the request and receive the response
            CompletableFuture<Void> future = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
            		.thenApply(response -> {
            			sendResponseToCallback(response.body(), callbackUrl);
            			return null;
            		});

            // wait for request to complete
            future.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void sendResponseToCallback(String responseBody, String callbackUrl) {
        // Implement logic to send the response to the callback URL
        System.out.println("Sending response to callback URL: " + callbackUrl);
        System.out.println("Response Body: " + responseBody);
        // You can use libraries like Apache HttpClient or java.net.http for the callback request
    }
}

