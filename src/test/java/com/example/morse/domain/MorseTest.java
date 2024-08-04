package com.example.morse.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseTest {
    private static final String TEXT_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
    private static final String MORSE_CODES =
            ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- " +
            ".-- -..- -.-- --.. / ----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";

    @Test
    void toMorseMustReturnsTextAsMorseCodes() {
        var morse = Morse.toMorse(TEXT_CHARS);

        Assertions.assertEquals(MORSE_CODES, morse);
    }

    @Test
    void toMorseMustIgnoreCharacterCase() {
        var text = TEXT_CHARS.toLowerCase();

        var morse = Morse.toMorse(text);

        Assertions.assertEquals(MORSE_CODES, morse);
    }

    @Test
    void toMorseMustIgnoreUnknownChars() {
        var text = "#A$";

        var morse = Morse.toMorse(text);

        Assertions.assertEquals(".-", morse);
    }

    @Test
    void toTextMustReturnsMorseAsText() {
        var text = Morse.toText(MORSE_CODES);

        Assertions.assertEquals(TEXT_CHARS, text);
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
