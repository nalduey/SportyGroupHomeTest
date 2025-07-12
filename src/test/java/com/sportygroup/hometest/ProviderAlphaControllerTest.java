package com.sportygroup.hometest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportygroup.hometest.controller.ProviderAlphaController;
import com.sportygroup.hometest.service.ProviderAlphaFeedTransformerService;
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

@WebMvcTest(ProviderAlphaController.class)
class ProviderAlphaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProviderAlphaFeedTransformerService transformerService;

    @Test
    @DisplayName("POST /provider-alpha/feed - Odds Update")
    void testProviderAlphaOdds() throws Exception {
        String requestJson = """
        {
          "msg_type": "odds_update",
          "event_id": "ev123",
          "values": {
            "1": 2.0,
            "X": 3.1,
            "2": 3.8
          }
        }
        """;

        mockMvc.perform(post("/provider-alpha/feed")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Processed Alpha"));
    }

    @Test
    @DisplayName("POST /provider-alpha/feed - Settlement")
    void testProviderAlphaSettlement() throws Exception {
        String requestJson = """
        {
          "msg_type": "settlement",
          "event_id": "ev123",
          "outcome": "1"
        }
        """;

        mockMvc.perform(post("/provider-alpha/feed")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Processed Alpha"));
    }
}
