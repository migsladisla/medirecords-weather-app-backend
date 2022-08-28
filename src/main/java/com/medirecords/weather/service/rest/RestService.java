package com.medirecords.weather.service.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service

public class RestService {

    @Autowired(required = false)
    private RestTemplate restTemplate;

    public ResponseEntity<Void> post(@NonNull String uri, @NonNull HttpEntity<?> entity) {

        log.info("Sending POST request to {} ", uri);

        return restTemplate.exchange(uri, HttpMethod.POST, entity, Void.class);
    }

    public int delete(@NonNull String uri,@NonNull HttpEntity<?> entity) {

        log.info("Sending Delete request to {} ", uri);
        final var response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
        return response.getStatusCode().value();
    }

    public <T> T get(@NonNull String uri, @NonNull HttpEntity<?> entity, Class<T> returnedClass) {

        log.info("Sending GET request to {} ", uri);

        final var response = restTemplate.exchange(uri, HttpMethod.GET, entity, returnedClass);
        return response.getBody();
    }

    public <T> List<T> getList(@NonNull String uri, @NonNull HttpEntity<?> entity, ParameterizedTypeReference<List<T>> responseType) {
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                responseType).getBody();
    }

    public <T> T get(@NonNull String uri, Class<T> returnedClass) {

        log.info("Sending GET request to {} ", uri);

        final var response = restTemplate.getForEntity(uri, returnedClass);
        return response.getBody();
    }

    public <T> T post(@NonNull String uri, @Nullable HttpEntity<?> entity, ParameterizedTypeReference<T> responseType) {

        log.info("Sending POST request to {} ", uri);

        final var response = restTemplate.exchange(uri, HttpMethod.POST, entity, responseType);
        return response.getBody();
    }

    public <T> T post(@NonNull String uri, @Nullable HttpEntity<?> entity, Class<T> returnedClass) {

        log.info("Sending POST request to {} ", uri);

        final var response = restTemplate.exchange(uri, HttpMethod.POST, entity, returnedClass);
        return response.getBody();
    }

    public <T> T put(@NonNull String uri, @Nullable HttpEntity<?> entity, Class<T> returnedClass) {

        log.info("Sending PUT request to {} ", uri);

        final var response = restTemplate.exchange(uri, HttpMethod.PUT, entity, returnedClass);
        return response.getBody();
    }
}
