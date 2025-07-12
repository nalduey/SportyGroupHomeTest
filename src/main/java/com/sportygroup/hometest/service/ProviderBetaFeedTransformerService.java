package com.sportygroup.hometest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportygroup.hometest.dto.beta.ProviderBetaOddsChangeDto;
import com.sportygroup.hometest.dto.beta.ProviderBetaSettlementDto;
import com.sportygroup.hometest.dto.standard.StandardGenericMessageDto;

import com.sportygroup.hometest.dto.standard.StandardSettlementDto;
import com.sportygroup.hometest.enums.ProviderBetaEnum;
import com.sportygroup.hometest.enums.ProviderStandardEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.sportygroup.hometest.mapper.ProviderBetaMapper.INSTANCE;

@Service
@Slf4j
public class ProviderBetaFeedTransformerService extends ProviderStandardFeedTransformerService {

    @SneakyThrows
    public void processGenericRequest(StandardGenericMessageDto genericMessageDto) {
        log.info("Beta JSON: {}", new ObjectMapper().writeValueAsString(genericMessageDto));
        if (genericMessageDto.getMsgType().equals(ProviderBetaEnum.MSG_TYPE_ODDS.toString())) {
            ProviderBetaOddsChangeDto providerBetaOddsChangeDto = INSTANCE.toOddsChange(genericMessageDto);
            transformOdds(providerBetaOddsChangeDto);
        } else if (genericMessageDto.getMsgType().equals(ProviderBetaEnum.MSG_TYPE_SETTLEMENT.toString())) {
            ProviderBetaSettlementDto providerBetaSettlementDto = INSTANCE.toSettlement(genericMessageDto);
            transformSettlement(providerBetaSettlementDto);
        } else {
            throw new IllegalArgumentException("The Msg Type is not supported");
        }
    }

    public StandardSettlementDto transformSettlement(StandardSettlementDto standardSettlementDto) {

        log.info("Result Value {}", standardSettlementDto.getResult());


        StandardSettlementDto standardSettlementDtoBuilded = StandardSettlementDto.
                builder().
                result( ProviderBetaEnum.fromString(standardSettlementDto.getResult())
                        .toStandard()
                        .toString()).
                msgType(ProviderStandardEnum.MSG_TYPE_SETTLEMENT.toString()).
                eventId(standardSettlementDto.getEventId()).
                build();


        sendToQueue(standardSettlementDtoBuilded);
        return standardSettlementDto;
    }
}
