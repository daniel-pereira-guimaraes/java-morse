package com.example.morse.infrastructure.api;

import com.example.morse.domain.Morse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseApi {

    @PostMapping("/to-morse")
    public String toMorse(@RequestBody String text) {
        return Morse.toMorse(text);
    }

    @PostMapping("/to-text")
    public String toText(@RequestBody String morse) {
        return Morse.toText(morse);
    }
}