package com.gestionnaire.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CompteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateCompteAndHidePasswordInResponse() throws Exception {
        String payload = """
            {
              \"siteWeb\": \"https://github.com\",
              \"identifiant\": \"haitam\",
              \"motDePasseChiffre\": \"MonPassword123\",
              \"notePrivee\": \"Compte de test\"
            }
            """;

        mockMvc.perform(post("/api/comptes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.siteWeb").value("https://github.com"))
            .andExpect(jsonPath("$.identifiant").value("haitam"))
            .andExpect(jsonPath("$.motDePasseChiffre").doesNotExist());
    }

    @Test
    void shouldReturnComptesList() throws Exception {
        mockMvc.perform(get("/api/comptes"))
            .andExpect(status().isOk());
    }
}
