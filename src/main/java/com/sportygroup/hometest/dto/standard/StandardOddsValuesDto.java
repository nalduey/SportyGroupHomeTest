package com.sportygroup.hometest.dto.standard;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor

public class StandardOddsValuesDto {
    private Double home;

    private Double draw;

    private Double away;
}