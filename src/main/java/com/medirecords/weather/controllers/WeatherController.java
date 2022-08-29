package com.medirecords.weather.controllers;

import com.medirecords.weather.service.OpenWeatherService;
import com.medirecords.weather.dtos.CityWeatherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import com.medirecords.weather.validators.ApiKey;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
@CrossOrigin(origins = "https://medirecords-weather-frontend.herokuapp.com/")
public class WeatherController {

    private final OpenWeatherService openWeatherService;
    private final ApiKey apiKeyValidator;

    @GetMapping("/city/{city}")
    public ResponseEntity<CityWeatherDto> getWeatherByCity(@PathVariable String city, @RequestParam("apiKey") String apiKey) throws Exception {
        try {
            return ResponseEntity.ok().body(openWeatherService.callOpenWeatherByCityNameApi(city, apiKey));
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity.badRequest().build();
        }
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParams(MissingServletRequestParameterException ex) {
        return ResponseEntity.badRequest().body(String.format("Missing parameter with name: %s", ex.getParameterName()));
    }
}
