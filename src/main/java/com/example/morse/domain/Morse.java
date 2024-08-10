package com.example.morse.domain;

import java.util.HashMap;
import java.util.Map;

public class Morse {

    private static final Map<Character, String> TEXT_TO_MORSE =
            new MapBuilder<Character, String>(new HashMap<>())
                    .put('A', ".-")
                    .put('B', "-...")
                    .put('C', "-.-.")
                    .put('D', "-..")
                    .put('E', ".")
                    .put('F', "..-.")
                    .put('G', "--.")
                    .put('H', "....")
                    .put('I', "..")
                    .put('J', ".---")
                    .put('K', "-.-")
                    .put('L', ".-..")
                    .put('M', "--")
                    .put('N', "-.")
                    .put('O', "---")
                    .put('P', ".--.")
                    .put('Q', "--.-")
                    .put('R', ".-.")
                    .put('S', "...")
                    .put('T', "-")
                    .put('U', "..-")
                    .put('V', "...-")
                    .put('W', ".--")
                    .put('X', "-..-")
                    .put('Y', "-.--")
                    .put('Z', "--..")
                    .put('1', ".----")
                    .put('2', "..---")
                    .put('3', "...--")
                    .put('4', "....-")
                    .put('5', ".....")
                    .put('6', "-....")
                    .put('7', "--...")
                    .put('8', "---..")
                    .put('9', "----.")
                    .put('0', "-----")
                    .put(' ', "/")
                    .build();

    private static final Map<String, Character> MORSE_TO_TEXT =
            new MapBuilder<>(TEXT_TO_MORSE).buildReversed();

    public static String toMorse(String text) {
        var morse = new StringBuilder();
        for (char c : text.toCharArray()) {
            var morseCode = TEXT_TO_MORSE.get(Character.toUpperCase(c));
            if (morseCode != null) {
                morse.append(morseCode).append(' ');
            }
        }
        return morse.toString().trim();
    }

    public static String toText(String morse) {
        var text = new StringBuilder();
        for (String morseCode : morse.split(" ")) {
            var c = MORSE_TO_TEXT.get(morseCode);
            if (c != null) {
                text.append(c);
            }
        }
        return text.toString();
    }

}
