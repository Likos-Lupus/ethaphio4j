package top.likoslupus.ethaphio4j.api.value;

import java.util.Map;

public interface ValueStore {

    Value get(String key);

    void set(String key, Value value);

    boolean contains(String key);

    Map<String, Value> snapshot();

}

