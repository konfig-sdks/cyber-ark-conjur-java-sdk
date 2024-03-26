package com.konfigthis.client;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class SimpleTest {
    final String MOCK_SERVER_URL = "http://localhost:4010";

    @Test
    public void initClientTest() {
        Configuration configuration = new Configuration();
        configuration.host = "http://localhost";
        
        // Configure HTTP basic authorization: basicAuth
        configuration.username = "YOUR USERNAME";
        configuration.password = "YOUR PASSWORD";
        
        configuration.conjurAuth  = "YOUR API KEY";
        
        CyberArkConjur client = new CyberArkConjur(configuration);
        assertNotNull(client);
    }
}
