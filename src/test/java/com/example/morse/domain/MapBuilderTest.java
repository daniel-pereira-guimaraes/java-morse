package com.example.morse.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MapBuilderTest {

    @Test
    void mustBuildMap() {
        var map = new MapBuilder<>(new HashMap<Integer,String>())
                .put(1, "a")
                .put(2, "b")
                .build();

        assertNotNull(map);
        assertEquals(2, map.size());
        assertEquals("a", map.get(1));
        assertEquals("b", map.get(2));
    }

    @Test
    void mustBuildReversedMap() {
        var map = new MapBuilder<>(new HashMap<Integer,String>())
                .put(1, "a")
                .put(2, "b")
                .put(3, "b")
                .buildReversed();

        assertNotNull(map);
        assertEquals(2, map.size());
        assertEquals(1, map.get("a"));
        assertEquals(3, map.get("b"));
    }
}
