package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    Map<String, String> map = new HashMap<>();
    public InMemoryKV(Map<String, String> map) {
        this.map.putAll(map);
    }

    public void set(String key, String value) {
        map.put(key, value);
    }
    public void unset(String key) {
        map.remove(key);
    }
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END
