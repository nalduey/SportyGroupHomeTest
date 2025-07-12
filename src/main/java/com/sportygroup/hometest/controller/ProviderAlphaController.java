package com.sportygroup.hometest.controller;

import com.sportygroup.hometest.service.ProviderAlphaFeedTransformerService;
import com.sportygroup.hometest.dto.alpha.ProviderAlphaGenericMessageDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/provider-alpha")
@AllArgsConstructor
@Slf4j
public class ProviderAlphaController {

    private final ProviderAlphaFeedTransformerService providerAlphaFeedTransformerService;


    @PostMapping("/feed")
    public ResponseEntity<String> handleAlphaFeed(@RequestBody ProviderAlphaGenericMessageDto genericRequest) {
        providerAlphaFeedTransformerService.processGenericRequest(genericRequest);
        return ResponseEntity.ok("Processed Alpha");
    }
}
