package com.medirecords.weather.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirQualityDto {
    private Double co;
    private Double no2;
    private Double o3;
    private Double so2;
    private Double pm2_5;
    private Double pm10;

    @JsonProperty("us-epa-index")
    private Integer us_epa_index;

    @JsonProperty("gb-defra-index")
    private Integer gb_defra_index;
}
