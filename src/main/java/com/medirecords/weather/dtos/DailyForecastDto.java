package com.medirecords.weather.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyForecastDto {
    private Double maxtemp_c;
    private Double maxtemp_f;
    private Double mintemp_c;
    private Double mintemp_f;
    private Double avgtemp_c;
    private Double avgtemp_f;
    private Double maxwind_mph;
    private Double maxwind_kph;
    private Double totalprecip_mm;
    private Double totalprecip_in;
    private Double avgis_km;
    private Double avgis_miles;
    private Double avghumidity;
    private Integer daily_will_it_rain;
    private Integer daily_chance_of_rain;
    private Integer daily_will_it_snow;
    private Integer daily_chance_of_snow;
    private CurrentConditionDto condition;
    private Double uv;
    private AirQualityDto air_quality;
}
