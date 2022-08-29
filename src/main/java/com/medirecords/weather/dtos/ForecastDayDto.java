package com.medirecords.weather.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDayDto {
    private String date;
    private Integer date_epoch;
    private AstroDto astro;
    private DailyForecastDto day;
    private List<HourlyForecastDto> hour;
}
