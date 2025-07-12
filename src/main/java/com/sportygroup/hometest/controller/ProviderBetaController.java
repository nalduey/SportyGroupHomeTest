package com.sportygroup.hometest.controller;

import com.sportygroup.hometest.dto.beta.ProviderBetaGenericMessageDto;
import com.sportygroup.hometest.service.ProviderBetaFeedTransformerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider-beta")
@AllArgsConstructor
public class ProviderBetaController {

    private final ProviderBetaFeedTransformerService providerBetaFeedTransformerService;


    @PostMapping("/feed")
    public ResponseEntity<String> handleBetaFeed(@RequestBody ProviderBetaGenericMessageDto genericRequest) {
        providerBetaFeedTransformerService.processGenericRequest(genericRequest);
        return ResponseEntity.ok("Processed Beta");
    }
}
