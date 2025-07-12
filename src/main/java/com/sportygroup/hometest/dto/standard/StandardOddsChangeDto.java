package com.sportygroup.hometest.dto.standard;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor

public class StandardOddsChangeDto {
    protected String msgType;

    protected String eventId;

    protected StandardOddsValuesDto oddsValues;
}
