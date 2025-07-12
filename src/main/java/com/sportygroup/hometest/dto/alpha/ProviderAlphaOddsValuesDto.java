package com.sportygroup.hometest.dto.alpha;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sportygroup.hometest.dto.standard.StandardOddsValuesDto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor

 public class ProviderAlphaOddsValuesDto extends StandardOddsValuesDto {
        @JsonProperty("1")
        private Double home;

        @JsonProperty("X")
        private Double draw;

        @JsonProperty("2")
        private Double away;
    }