package com.example.morse.domain;

import com.example.morse.fixture.MorseFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseTest {

    @Test
    void toMorseMustReturnsTextAsMorseCodes() {
        var text = MorseFixture.TEXT_CHARS;

        var morse = Morse.toMorse(text);

        Assertions.assertEquals(MorseFixture.MORSE_CODES, morse);
    }

    @Test
    void toMorseMustIgnoreCharacterCase() {
        var text = MorseFixture.TEXT_CHARS.toLowerCase();

        var morse = Morse.toMorse(text);

        Assertions.assertEquals(MorseFixture.MORSE_CODES, morse);
    }

    @Test
    void toMorseMustIgnoreUnknownChars() {
        var text = "#A$";

        var morse = Morse.toMorse(text);

        Assertions.assertEquals(".-", morse);
    }

    @Test
    void toTextMustReturnsMorseAsText() {
        var text = Morse.toText(MorseFixture.MORSE_CODES);

        Assertions.assertEquals(MorseFixture.TEXT_CHARS, text);
    }

    @Test
    void toTextMustIgnoreInvalidMorseCodes() {
        var morse = "X .- Y -... 123";

        var text = Morse.toText(morse);

        Assertions.assertEquals("AB", text);
    }

    @Test
    void toTextMustIgnoreExtraWhitespace() {
        var morse = "   .-   -...   ";

        var text = Morse.toText(morse);

        Assertions.assertEquals("AB", text);
    }

}
