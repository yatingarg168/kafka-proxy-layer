package org.messaging.kafkaproxylayer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class SyncRestClient {

    private static final Logger LOG = LoggerFactory.getLogger(SyncRestClient.class);

    @Value("${service.full.url}")
    private String apiUrl;

    private final RestOperations restTemplate;

    @Autowired
    public SyncRestClient(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object postMessage(String message) {
        LOG.info("Sending data to service synchronously...");

        Object object = restTemplate.postForObject(apiUrl, message, Object.class);
        LOG.info("Response string: {}" , object);


        return object;
    }


    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }
}