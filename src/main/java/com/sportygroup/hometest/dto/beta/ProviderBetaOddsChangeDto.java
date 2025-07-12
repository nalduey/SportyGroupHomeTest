package com.sportygroup.hometest.dto.beta;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sportygroup.hometest.dto.standard.StandardOddsChangeDto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class ProviderBetaOddsChangeDto extends StandardOddsChangeDto {
    @JsonProperty("msg_type")
    private String msgType;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("odds_values")
    private ProviderBetaOddsValuesDto oddsValues;

}
