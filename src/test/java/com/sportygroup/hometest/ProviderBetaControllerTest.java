package com.sportygroup.hometest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportygroup.hometest.controller.ProviderBetaController;
import com.sportygroup.hometest.service.ProviderBetaFeedTransformerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ProviderBetaController.class)
class ProviderBetaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProviderBetaFeedTransformerService transformerService;

    @Test
    @DisplayName("POST /provider-beta/feed - Odds Change")
    void testProviderBetaOddsChange() throws Exception {
        String requestJson = """
        {
          "type": "ODDS",
          "event_id": "ev456",
          "odds": {
            "home": 1.95,
            "draw": 3.2,
            "away": 4.0
          }
        }
        """;

        mockMvc.perform(post("/provider-beta/feed")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Processed Beta"));
    }

    @Test
    @DisplayName("POST /provider-beta/feed - Settlement")
    void testProviderBetaSettlement() throws Exception {
        String requestJson = """
        {
          "type": "SETTLEMENT",
          "event_id": "ev456",
          "result": "away"
        }
        """;

        mockMvc.perform(post("/provider-beta/feed")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Processed Beta"));
    }
}
