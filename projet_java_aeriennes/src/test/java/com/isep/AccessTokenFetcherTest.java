package com.isep;

import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccessTokenFetcherTest {

    @Test
    public void testGetAccessTokenSuccess() throws IOException {
        // Mock OkHttpClient and Response
        OkHttpClient mockClient = mock(OkHttpClient.class);
        Call mockCall = mock(Call.class);
        Response mockResponse = mock(Response.class);
        ResponseBody mockResponseBody = mock(ResponseBody.class);

        // Mock the response body
        Map<String, String> tokenData = new HashMap<>();
        tokenData.put("access_token", "mock_access_token");
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(tokenData);

        when(mockResponseBody.string()).thenReturn(jsonResponse);
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body()).thenReturn(mockResponseBody);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        // Inject the mock client into the AccessTokenFetcher
        AccessTokenFetcher fetcher = new AccessTokenFetcher() {
            @Override
            protected OkHttpClient createClient() {
                return mockClient;
            }
        };

        // Call the method and assert the result
        String accessToken = fetcher.getAccessToken();
        assertEquals("mock_access_token", accessToken);
    }

    @Test
    public void testGetAccessTokenFailure() throws IOException {
        // Mock OkHttpClient and Response
        OkHttpClient mockClient = mock(OkHttpClient.class);
        Call mockCall = mock(Call.class);
        Response mockResponse = mock(Response.class);

        when(mockResponse.isSuccessful()).thenReturn(false);
        when(mockResponse.code()).thenReturn(400);
        when(mockResponse.message()).thenReturn("Bad Request");
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        // Inject the mock client into the AccessTokenFetcher
        AccessTokenFetcher fetcher = new AccessTokenFetcher() {
            @Override
            protected OkHttpClient createClient() {
                return mockClient;
            }
        };

        // Call the method and assert the exception
        IOException exception = assertThrows(IOException.class, fetcher::getAccessToken);
        assertEquals("Failed to fetch access token: 400 - Bad Request", exception.getMessage());
    }
}
