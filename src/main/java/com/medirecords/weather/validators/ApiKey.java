package com.medirecords.weather.validators;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ApiKey {
    public boolean isValid(String apiKey) {
        log.debug("Validating API Key");

        if (apiKey.isEmpty()) {
            log.debug("Api Key Valid");
            return true;
        } else {
            log.info("Api Key Invalid");
            return false;
        }
    }
}
