package com.medirecords.weather.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityWeatherMainDto {
    private Integer temp;
    private Integer feels_like;
    private Integer temp_min;
    private Integer temp_max;
    private Integer pressure;
    private Integer humidity;
}
