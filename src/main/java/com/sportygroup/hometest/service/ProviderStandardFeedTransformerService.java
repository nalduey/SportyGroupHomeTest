package com.sportygroup.hometest.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.sportygroup.hometest.dto.standard.StandardGenericMessageDto;
import com.sportygroup.hometest.dto.standard.StandardOddsChangeDto;
import com.sportygroup.hometest.dto.standard.StandardOddsValuesDto;
import com.sportygroup.hometest.dto.standard.StandardSettlementDto;
import com.sportygroup.hometest.enums.ProviderStandardEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@Slf4j
public abstract class ProviderStandardFeedTransformerService {

    protected final Queue<Object> messageQueue = new ConcurrentLinkedQueue<>();

    protected abstract void processGenericRequest(StandardGenericMessageDto genericMessageDto);

    protected abstract StandardSettlementDto transformSettlement(StandardSettlementDto standardSettlementDto);

    protected  StandardOddsChangeDto transformOdds(StandardOddsChangeDto standardOddsChangeDto)  {

        StandardOddsValuesDto oddsValuesDto = StandardOddsValuesDto.builder().
                draw(standardOddsChangeDto.getOddsValues().getDraw()).
                home(standardOddsChangeDto.getOddsValues().getHome()).
                away(standardOddsChangeDto.getOddsValues().getAway()).
                build();

        StandardOddsChangeDto standardOddsChangeDtoBuilded = StandardOddsChangeDto.builder().
                msgType(ProviderStandardEnum.MSG_TYPE_ODDS.toString()).
                eventId(standardOddsChangeDto.getEventId()).
                oddsValues(oddsValuesDto)
                .build();
        sendToQueue(standardOddsChangeDtoBuilded);
        return standardOddsChangeDto;
    }
    @SneakyThrows
    protected void sendToQueue(Object message) {
        log.info("Standard JSON: {}", new ObjectMapper().writeValueAsString(message));
        messageQueue.offer(message);
        log.debug("Standard Message Sent");
    }
}
