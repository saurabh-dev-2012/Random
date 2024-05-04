package com.java.practice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SyncRestApiCall {
    public static void main(String[] args) {
        // Replace with your API endpoint URL
        String apiUrl = "https://api.example.com/data";

        try {
            // Create an HTTP client
            HttpClient httpClient = HttpClient.newHttpClient();

            // Create an HTTP request
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            // Send the request and receive the response
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Print the response status code and body
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

