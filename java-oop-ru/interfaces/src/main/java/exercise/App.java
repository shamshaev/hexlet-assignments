package exercise;

import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, long n) {
        return apartments.stream()
                .sorted(Home::compareTo)
                .limit(n)
                .map(Home::toString)
                .toList();
    }
}
// END
