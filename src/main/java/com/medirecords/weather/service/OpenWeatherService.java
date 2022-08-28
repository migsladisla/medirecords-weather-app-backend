package com.medirecords.weather.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medirecords.weather.dtos.CityWeatherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenWeatherService {
    public CityWeatherDto callOpenWeatherByCityNameApi(String cityName, String apiKey) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.MINUTES)
                .writeTimeout(60, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.MINUTES)
                .build();

        CityWeatherDto cityWeatherDto = null;
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + apiKey)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                String weatherData = response.body().string();
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                cityWeatherDto = mapper.readValue(weatherData, CityWeatherDto.class);
                cityWeatherDto.setCity(cityName);
                cityWeatherDto.setResponseStatus("success");
            } else {
                cityWeatherDto = CityWeatherDto.builder().build();
                cityWeatherDto.setException("Failed to fetch weather for city " + cityName);
                if (response.message().equals("Unauthorized")) {
                    cityWeatherDto.setException("Invalid apiKey provided");
                }
                log.error("Open Weather Fetch Error Encountered with {} - {} - for API Key {}", response.code(), response.message(), apiKey);
            }

            response.body().close();
            return cityWeatherDto;
        } catch (IOException e) {
            log.error("Unable to execute Open Weather Fetch Data for City - {} with API Key {} from {}", cityName, apiKey, request.url());
            cityWeatherDto.setException("error");
            return cityWeatherDto;
        }
    }
}
