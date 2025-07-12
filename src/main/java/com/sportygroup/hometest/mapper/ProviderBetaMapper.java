package com.sportygroup.hometest.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportygroup.hometest.dto.beta.ProviderBetaOddsChangeDto;
import com.sportygroup.hometest.dto.beta.ProviderBetaOddsValuesDto;
import com.sportygroup.hometest.dto.beta.ProviderBetaSettlementDto;
import com.sportygroup.hometest.dto.standard.StandardGenericMessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {ObjectMapper.class})
public interface ProviderBetaMapper {

    ProviderBetaMapper INSTANCE = Mappers.getMapper(ProviderBetaMapper.class);

    @Mapping(target = "oddsValues", source = "payload", qualifiedByName = "mapPayloadToOddsValues")
    ProviderBetaOddsChangeDto toOddsChange(StandardGenericMessageDto genericMessage);


    @Mapping(target = "result", source = "payload", qualifiedByName = "extractOutcome")
    ProviderBetaSettlementDto toSettlement(StandardGenericMessageDto genericMessage);

    @Named("mapPayloadToOddsValues")
    static ProviderBetaOddsValuesDto mapPayloadToOddsValues(JsonNode payload) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(payload, ProviderBetaOddsValuesDto.class);
    }


    @Named("extractOutcome")
    static String extractOutcome(JsonNode payload) {
        return payload != null && payload.has("result")
                ? payload.get("result").asText()
                : payload.asText();
    }
}
