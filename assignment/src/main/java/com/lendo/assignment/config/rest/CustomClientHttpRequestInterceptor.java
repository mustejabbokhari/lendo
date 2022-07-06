package com.lendo.assignment.config.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomClientHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        logRestRequests(httpRequest);
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }

    private void logRestRequests(HttpRequest httpRequest) {
     LOGGER.info("Header: {}", httpRequest.getHeaders());
     LOGGER.info("Request Method: {}", httpRequest.getMethod());
     LOGGER.info("Request URI: {}", httpRequest.getURI());

    }
}
