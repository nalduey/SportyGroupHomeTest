package com.sportygroup.hometest.dto.alpha;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonAlias;

import com.sportygroup.hometest.dto.standard.StandardGenericMessageDto;
import lombok.Data;

@Data
public class ProviderAlphaGenericMessageDto extends StandardGenericMessageDto {

    @JsonProperty("msg_type")
    private String msgType;

    @JsonProperty("event_id")
    private String eventId;

    @JsonAlias({ "values", "outcome" })
    private JsonNode payload;

}
