package com.sportygroup.hometest.dto.standard;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class StandardSettlementDto {
    protected String msgType;
    protected String eventId;
    protected String result;
}
