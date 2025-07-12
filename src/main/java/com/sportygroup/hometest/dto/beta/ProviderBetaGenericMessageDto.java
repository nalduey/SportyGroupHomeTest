package com.sportygroup.hometest.dto.beta;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.sportygroup.hometest.dto.standard.StandardGenericMessageDto;
import lombok.Data;

@Data
public class ProviderBetaGenericMessageDto extends StandardGenericMessageDto {

    @JsonProperty("type")
    private String msgType;

    @JsonProperty("event_id")
    private String eventId;

    @JsonAlias({ "odds", "result" })
    private JsonNode payload;

}
