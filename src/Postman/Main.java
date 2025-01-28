package Postman;

import okhttp3.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // The URL for the API endpoint
        String url = "https://chatgpt.com/";  // Replace with the correct URL for the API

        // JSON body for the POST request
        String jsonBody = "{ \"message\": \"Hello, ChatGPT!\" }";  // Example JSON body for POST request

        // RequestBody for the POST request
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json"));

        // Create the POST request
        Request postRequest = new Request.Builder()
                .url(url)
                .post(body)  // POST request with JSON body
                .build();

        // Send the POST request and handle the response
        try (Response response = client.newCall(postRequest).execute()) {
            if (response.isSuccessful()) {
                // If POST request is successful, print the response
                System.out.println("POST Response: " + response.body().string());
            } else {
                // If we get a 405 Method Not Allowed error, try a GET request
                System.out.println("Error: " + response.code() + " - Method Not Allowed. Trying GET request...");

                // Create a GET request as a fallback
                Request getRequest = new Request.Builder()
                        .url(url)
                        .get()  // Send GET request
                        .build();

                // Send the GET request and handle the response
                try (Response getResponse = client.newCall(getRequest).execute()) {
                    if (getResponse.isSuccessful()) {
                        // If GET request is successful, print the response
                        System.out.println("GET Response: " + getResponse.body().string());
                    } else {
                        // If GET request fails as well
                        System.out.println("Error: " + getResponse.code() + " - GET request failed.");
                    }
                }
            }
        }
    }
}