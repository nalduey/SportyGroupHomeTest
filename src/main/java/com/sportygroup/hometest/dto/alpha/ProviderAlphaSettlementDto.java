package com.sportygroup.hometest.dto.alpha;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sportygroup.hometest.dto.standard.StandardSettlementDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ProviderAlphaSettlementDto extends StandardSettlementDto {
    @JsonProperty("msg_type")
    private String msgType;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("outcome")
    private String result;

}
