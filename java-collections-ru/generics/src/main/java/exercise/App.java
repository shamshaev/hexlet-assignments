package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        var result = new ArrayList<Map<String, String>>();
        for (var book : books) {
            if (isBookMatches(book, where)) {
                result.add(book);
            }
        }
        return result;
    }

    public static boolean isBookMatches(Map<String, String> book, Map<String, String> where) {
        for (var entry : where.entrySet()) {
            if (!(book.containsKey(entry.getKey()) && book.containsValue(entry.getValue()))) {
                return false;
            }
        }
        return true;
    }
}
//END
