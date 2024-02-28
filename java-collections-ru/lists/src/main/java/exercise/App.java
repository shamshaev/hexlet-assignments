package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String chars, String word) {
        var charsList = new ArrayList<String>(List.of(chars.split("")));
        var wordList = new ArrayList<String>(List.of(word.split("")));
        for (var wordLetter : wordList) {
            if (!charsList.contains(wordLetter.toLowerCase())) {
                return false;
            }
            charsList.remove(wordLetter.toLowerCase());
        }
        return true;
    }
}
//END
