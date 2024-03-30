package exercise;

//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        var map = storage.toMap();
        for (var entry : map.entrySet()) {
            storage.unset(entry.getKey());
            var swappedKey = entry.getValue();
            var swappedValue = entry.getKey();
            storage.set(swappedKey, swappedValue);
        }
    }
}
// END
