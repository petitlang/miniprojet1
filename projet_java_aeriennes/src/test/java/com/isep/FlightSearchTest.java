package com.isep;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

public class FlightSearchTest {

    @Test
    public void testFlightSearch() throws IOException {
        MockWebServer server = new MockWebServer();
        server.start();

        String mockResponse = "{ \"data\": [ { \"type\": \"flight-offer\", \"id\": \"1\" } ] }";
        server.enqueue(new MockResponse().setBody(mockResponse).setResponseCode(200));

        FlightSearch.API_URL = server.url("/v2/shopping/flight-offers").toString();

        String[] args = {};
        FlightSearch.main(args);

        server.shutdown();
    }
}