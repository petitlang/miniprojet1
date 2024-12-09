package com.isep;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessTokenFetcher {
    private static final String API_KEY = "44No1AWPjkTVIlmLp9ohGNbyKKkjzJWt";
    private static final String API_SECRET = "PzzAaXRENd7BIv55";
    private static final String TOKEN_URL = "https://test.api.amadeus.com/v1/security/oauth2/token";

    public static String getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
            .add("grant_type", "client_credentials")
            .add("client_id", API_KEY)
            .add("client_secret", API_SECRET)
            .build();

        Request request = new Request.Builder()
            .url(TOKEN_URL)
            .post(body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> tokenData = mapper.readValue(response.body().string(), Map.class);
                return (String) tokenData.get("access_token");
            } else {
                throw new IOException("Failed to fetch access token: " + response.code() + " - " + response.message());
            }
        }
    }

    public static void main(String[] args) {
        try {
            String token = getAccessToken();
            System.out.println("Access Token: " + token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
