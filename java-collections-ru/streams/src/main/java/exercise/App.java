package exercise;

import java.util.List;
//import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .map(email -> email.split("@")[1])
                .filter(domain -> List.of("gmail.com", "yandex.ru", "hotmail.com").contains(domain))
                .count();
    }
}
// END
