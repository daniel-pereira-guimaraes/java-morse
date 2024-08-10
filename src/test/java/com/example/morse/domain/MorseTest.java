package com.example.morse.domain;

import com.example.morse.fixture.MorseFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MorseTest {

    @Test
    void toMorseMustReturnsTextAsMorseCodes() {
        var text = MorseFixture.TEXT_CHARS;

        var morse = Morse.toMorse(text);

        assertEquals(MorseFixture.MORSE_CODES, morse);
    }

    @Test
    void toMorseMustIgnoreCharacterCase() {
        var text = MorseFixture.TEXT_CHARS.toLowerCase();

        var morse = Morse.toMorse(text);

        assertEquals(MorseFixture.MORSE_CODES, morse);
    }

    @Test
    void toMorseMustIgnoreUnknownChars() {
        var text = "#A$";

        var morse = Morse.toMorse(text);

        assertEquals(".-", morse);
    }

    @Test
    void toTextMustReturnsMorseAsText() {
        var text = Morse.toText(MorseFixture.MORSE_CODES);

        assertEquals(MorseFixture.TEXT_CHARS, text);
    }

    @Test
    void toTextMustIgnoreInvalidMorseCodes() {
        var morse = "X .- Y -... 123";

        var text = Morse.toText(morse);

        assertEquals("AB", text);
    }

    @Test
    void toTextMustIgnoreExtraWhitespace() {
        var morse = "   .-   -...   ";

        var text = Morse.toText(morse);

        assertEquals("AB", text);
    }

    @Test
    void toTestInJenkins() {
        fail();
    }

}
