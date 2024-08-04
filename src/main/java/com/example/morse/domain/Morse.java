package com.example.morse.domain;

import java.util.HashMap;
import java.util.Map;

public class Morse {

    private static final Map<Character, String> TEXT_TO_MORSE = new HashMap<>();
    private static final Map<String, Character> MORSE_TO_TEXT = new HashMap<>();

    static {
        TEXT_TO_MORSE.put('A', ".-");
        TEXT_TO_MORSE.put('B', "-...");
        TEXT_TO_MORSE.put('C', "-.-.");
        TEXT_TO_MORSE.put('D', "-..");
        TEXT_TO_MORSE.put('E', ".");
        TEXT_TO_MORSE.put('F', "..-.");
        TEXT_TO_MORSE.put('G', "--.");
        TEXT_TO_MORSE.put('H', "....");
        TEXT_TO_MORSE.put('I', "..");
        TEXT_TO_MORSE.put('J', ".---");
        TEXT_TO_MORSE.put('K', "-.-");
        TEXT_TO_MORSE.put('L', ".-..");
        TEXT_TO_MORSE.put('M', "--");
        TEXT_TO_MORSE.put('N', "-.");
        TEXT_TO_MORSE.put('O', "---");
        TEXT_TO_MORSE.put('P', ".--.");
        TEXT_TO_MORSE.put('Q', "--.-");
        TEXT_TO_MORSE.put('R', ".-.");
        TEXT_TO_MORSE.put('S', "...");
        TEXT_TO_MORSE.put('T', "-");
        TEXT_TO_MORSE.put('U', "..-");
        TEXT_TO_MORSE.put('V', "...-");
        TEXT_TO_MORSE.put('W', ".--");
        TEXT_TO_MORSE.put('X', "-..-");
        TEXT_TO_MORSE.put('Y', "-.--");
        TEXT_TO_MORSE.put('Z', "--..");
        TEXT_TO_MORSE.put('1', ".----");
        TEXT_TO_MORSE.put('2', "..---");
        TEXT_TO_MORSE.put('3', "...--");
        TEXT_TO_MORSE.put('4', "....-");
        TEXT_TO_MORSE.put('5', ".....");
        TEXT_TO_MORSE.put('6', "-....");
        TEXT_TO_MORSE.put('7', "--...");
        TEXT_TO_MORSE.put('8', "---..");
        TEXT_TO_MORSE.put('9', "----.");
        TEXT_TO_MORSE.put('0', "-----");
        TEXT_TO_MORSE.put(' ', "/");

        TEXT_TO_MORSE.forEach((k,v) -> MORSE_TO_TEXT.put(v,k));
    }

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
