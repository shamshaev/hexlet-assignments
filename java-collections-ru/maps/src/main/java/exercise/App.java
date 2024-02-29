package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var words = sentence.isEmpty() ? new String[0] : sentence.split(" ");
        var wordsCount = new HashMap<String, Integer>();

        for (var word : words) {
            var count = wordsCount.getOrDefault(word, 0);
            wordsCount.put(word, count + 1);
        }

        return wordsCount;
    }
    public static String toString(Map<String, Integer> wordsCount) {
        var result = new StringBuilder(wordsCount.isEmpty() ? "{" : "{\n");

        for (var key : wordsCount.keySet()) {
            result.append("  ");
            result.append(key);
            result.append(": ");
            result.append(wordsCount.get(key));
            result.append("\n");
        }

        result.append("}");

        return result.toString();
    }
}
//END
