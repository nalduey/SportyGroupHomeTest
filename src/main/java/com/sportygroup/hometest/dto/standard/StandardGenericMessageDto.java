package com.sportygroup.hometest.dto.standard;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class StandardGenericMessageDto {

    protected String msgType;

    protected String eventId;

    protected JsonNode payload;

}
