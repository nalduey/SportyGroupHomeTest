package com.sportygroup.hometest.dto.beta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sportygroup.hometest.dto.standard.StandardOddsValuesDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor

 public class ProviderBetaOddsValuesDto extends StandardOddsValuesDto {
        @JsonProperty("home")
        private Double home;

        @JsonProperty("draw")
        private Double draw;

        @JsonProperty("away")
        private Double away;
}