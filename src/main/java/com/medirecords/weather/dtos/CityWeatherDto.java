package com.medirecords.weather.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityWeatherDto {
    private LocationDto location;
    private CurrentDto current;
    private ForecastDto forecast;
    private String responseStatus;
    private String exception;
}
