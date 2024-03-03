package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>();
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (var key : keys) {
            result.put(key, generateValue(data1, data2, key));
        }

        return result;
    }

    public static String generateValue(Map<String, Object> data1, Map<String, Object> data2, String key) {
        if (!data1.containsKey(key)) {
            return "added";
        } else if (!data2.containsKey(key)) {
            return "deleted";
        } else if (data1.get(key).equals(data2.get(key))) {
            return "unchanged";
        }
        return "changed";
    }
}
//END
