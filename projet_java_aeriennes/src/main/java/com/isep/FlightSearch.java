package com.isep;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FlightSearch {
    public static String API_URL = "https://test.api.amadeus.com/v2/shopping/flight-offers";

    public static void main(String[] args) throws IOException {
        String accessToken = AccessTokenFetcher.getAccessToken();
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
        urlBuilder.addQueryParameter("originLocationCode", "JFK");
        urlBuilder.addQueryParameter("destinationLocationCode", "LAX");
        urlBuilder.addQueryParameter("departureDate", "2024-12-15");
        urlBuilder.addQueryParameter("adults", "1");

        Request request = new Request.Builder()
            .url(urlBuilder.build().toString())
            .addHeader("Authorization", "Bearer " + accessToken)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponse = response.body().string();
                System.out.println(jsonResponse);
            } else {
                System.err.println("Error: " + response.code() + " - " + response.message());
            }
        }
    }
}
