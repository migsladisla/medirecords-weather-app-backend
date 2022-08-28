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
    private String city;
    private Integer timezone;
    private Integer visibility;
    private CityCoordinatesDto coord;
    private CityWeatherDetailsDto[] weather;
    private CityWeatherMainDto main;
    private CityWindDto wind;
    private CityCloudsDto clouds;
    private CityDetailsDto sys;
    private String responseStatus;
    private String exception;
}
