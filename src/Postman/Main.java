package Postman;

import okhttp3.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create an OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // The URL for the API endpoint
        String url = "https://chatgpt.com/";  // Replace with the correct URL for the API

        // JSON body for the POST request
        String jsonBody = "{ \"message\": \"Hello, ChatGPT!\" }";  // Example JSON body

        // Create the RequestBody for the POST request
        RequestBody body = RequestBody.create(
                jsonBody,
                MediaType.get("application/json")
        );

        // Create the POST request with required headers
        Request postRequest = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")  // Header for JSON
                .addHeader("Authorization", "Bearer YOUR_API_KEY")  // Replace with your API key
                .addHeader("User-Agent", "MyJavaClient/1.0")        // Optional, but recommended
                .build();

        // Send the POST request and handle the response
        try (Response response = client.newCall(postRequest).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                // Print the response for a successful POST request
                System.out.println("POST Response: " + response.body().string());
            } else {
                System.out.println("POST Request Failed: " + response.code() + " - " + response.message());

                // Print the response body in case of a 400 error
                if (response.code() == 400 && response.body() != null) {
                    System.out.println("Response Body: " + response.body().string());
                }

                // If POST fails with a 405 or 403, attempt a GET request
                if (response.code() == 405 || response.code() == 403) {
                    System.out.println("Trying GET request as fallback...");

                    // Create the GET request with headers
                    Request getRequest = new Request.Builder()
                            .url(url)
                            .get()
                            .addHeader("Authorization", "Bearer YOUR_API_KEY")  // Add headers as required
                            .addHeader("User-Agent", "MyJavaClient/1.0")
                            .build();

                    // Send the GET request and handle the response
                    try (Response getResponse = client.newCall(getRequest).execute()) {
                        if (getResponse.isSuccessful() && getResponse.body() != null) {
                            System.out.println("GET Response: " + getResponse.body().string());
                        } else {
                            System.out.println("GET Request Failed: " + getResponse.code() + " - " + getResponse.message());
                        }
                    }
                }
            }
        } catch (IOException e) {
            // Handle any I/O exceptions
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}