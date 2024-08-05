package com.example.morse.infrastructure.api;

import com.example.morse.fixture.MorseFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MorseApi.class)
class MorseApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mustConvertTextToMorse() throws Exception {
        var inputText = MorseFixture.TEXT_CHARS;
        var expectedMorseCode = MorseFixture.MORSE_CODES;

        mockMvc.perform(post("/to-morse")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(inputText))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedMorseCode));
    }

    @Test
    public void mustConvertMorseToText() throws Exception {
        var inputMorse = MorseFixture.MORSE_CODES;
        var expectedText = MorseFixture.TEXT_CHARS;

        mockMvc.perform(post("/to-text")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(inputMorse))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedText));
    }

}