package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filepath, Car car) throws IOException {
        var content = car.serialize();
        Files.writeString(filepath, content, StandardOpenOption.APPEND);
    }

    public static Car extract(Path filepath) throws IOException {
        var content = Files.readString(filepath);
        return Car.unserialize(content);
    }
}
// END
