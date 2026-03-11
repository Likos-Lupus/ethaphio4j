package top.likoslupus.ethaphio4j.api.value;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapValueStore implements ValueStore {

    private final ConcurrentHashMap<String, Value> backing = new ConcurrentHashMap<>();

    @Override
    public Value get(String key) {
        return backing.getOrDefault(key, Value.nullValue());
    }

    @Override
    public void set(String key, Value value) {
        backing.put(key, value == null ? Value.nullValue() : value);
    }

    @Override
    public boolean contains(String key) {
        return backing.containsKey(key);
    }

    @Override
    public Map<String, Value> snapshot() {
        return Map.copyOf(backing);
    }

}
