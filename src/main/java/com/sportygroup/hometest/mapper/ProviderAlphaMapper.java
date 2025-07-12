package com.sportygroup.hometest.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportygroup.hometest.dto.alpha.ProviderAlphaOddsChangeDto;
import com.sportygroup.hometest.dto.alpha.ProviderAlphaOddsValuesDto;
import com.sportygroup.hometest.dto.alpha.ProviderAlphaSettlementDto;
import com.sportygroup.hometest.dto.standard.StandardGenericMessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {ObjectMapper.class})
public interface ProviderAlphaMapper {

    ProviderAlphaMapper INSTANCE = Mappers.getMapper(ProviderAlphaMapper.class);

    @Mapping(target = "oddsValues", source = "payload", qualifiedByName = "mapPayloadToOddsValues")
    ProviderAlphaOddsChangeDto toOddsChange(StandardGenericMessageDto genericMessage);


    @Mapping(target = "result", source = "payload", qualifiedByName = "extractOutcome")
    ProviderAlphaSettlementDto toSettlement(StandardGenericMessageDto genericMessage);

    @Named("mapPayloadToOddsValues")
    static ProviderAlphaOddsValuesDto mapPayloadToOddsValues(JsonNode payload) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(payload, ProviderAlphaOddsValuesDto.class);
    }


    @Named("extractOutcome")
    static String extractOutcome(JsonNode payload) {
        return payload != null && payload.has("outcome")
                ? payload.get("outcome").asText()
                : payload.asText();
    }
}
