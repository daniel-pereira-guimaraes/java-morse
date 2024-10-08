package com.example.morse.domain;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<K,V> {

    private final Map<K,V> map;

    public MapBuilder(Map<K,V> map) {
        this.map = map;
    }

    public MapBuilder<K,V> put(K key, V value) {
        map.put(key, value);
        return this;
    }

    public Map<K,V> build() {
        return map;
    }

    public Map<V,K> buildReversed() {
        var reversed = new HashMap<V,K>();
        map.forEach((key, value) -> reversed.put(value, key));
        return reversed;
    }

}
