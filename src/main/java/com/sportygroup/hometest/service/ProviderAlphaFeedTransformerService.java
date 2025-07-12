package com.sportygroup.hometest.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportygroup.hometest.dto.alpha.ProviderAlphaOddsChangeDto;
import com.sportygroup.hometest.dto.alpha.ProviderAlphaSettlementDto;
import com.sportygroup.hometest.dto.standard.StandardGenericMessageDto;

import com.sportygroup.hometest.dto.standard.StandardSettlementDto;
import com.sportygroup.hometest.enums.ProviderAlphaEnum;
import com.sportygroup.hometest.enums.ProviderBetaEnum;
import com.sportygroup.hometest.enums.ProviderStandardEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import static com.sportygroup.hometest.mapper.ProviderAlphaMapper.INSTANCE;

@Service
@Slf4j
public class ProviderAlphaFeedTransformerService extends ProviderStandardFeedTransformerService {

    @SneakyThrows
    public void processGenericRequest(StandardGenericMessageDto genericMessageDto) {
        log.info("Alpha JSON: {}", new ObjectMapper().writeValueAsString(genericMessageDto));
        if (genericMessageDto.getMsgType().equals(ProviderAlphaEnum.MSG_TYPE_ODDS.toString())) {
            ProviderAlphaOddsChangeDto providerAlphaOddsChangeDto = INSTANCE.toOddsChange(genericMessageDto);
            transformOdds(providerAlphaOddsChangeDto);
        } else if (genericMessageDto.getMsgType().equals(ProviderAlphaEnum.MSG_TYPE_SETTLEMENT.toString())) {
            ProviderAlphaSettlementDto providerAlphaSettlementDto = INSTANCE.toSettlement(genericMessageDto);
            transformSettlement(providerAlphaSettlementDto);
        } else {
            throw new IllegalArgumentException("The Msg Type is not supported");
        }
    }

    public StandardSettlementDto transformSettlement(StandardSettlementDto standardSettlementDto) {

        log.info("Result Value {}", standardSettlementDto.getResult());

        StandardSettlementDto standardSettlementDtoBuilded = StandardSettlementDto.
                builder().
                result( ProviderAlphaEnum.fromString(standardSettlementDto.getResult())
                        .toStandard()
                        .toString()).
                msgType(ProviderStandardEnum.MSG_TYPE_SETTLEMENT.toString()).
                eventId(standardSettlementDto.getEventId()).
                build();

        sendToQueue(standardSettlementDtoBuilded);
        return standardSettlementDto;
    }

}
