package com.medirecords.weather.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentDto {
    private String last_updated;
    private Double temp_c;
    private Double temp_f;
    private Integer is_day;
    private CurrentConditionDto condition;
    private Double wind_mph;
    private Double wind_kph;
    private Integer wind_degree;
    private String wind_dir;
    private Double pressure_mb;
    private Double pressure_in;
    private Double precip_mm;
    private Double precip_in;
    private Integer humidity;
    private Integer cloud;
    private Double feelslike_c;
    private Double feelslike_f;
    private Double windchill_c;
    private Double windchill_f;
    private Double heatindex_c;
    private Double heatindex_f;
    private Double dewpoint_c;
    private Double dewpoint_f;
    private Integer will_it_rain;
    private Integer chance_of_rain;
    private Integer will_it_snow;
    private Integer chance_of_snow;
    private Double vis_km;
    private Double vis_miles;
    private Double gust_mph;
    private Double gust_kph;
    private Double uv;
    private AirQualityDto air_quality;
}
