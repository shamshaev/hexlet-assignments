package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String pathIn1, String pathIn2, String pathOut) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                var content1 = Files.readString(getPath(pathIn1));
                var content2 = Files.readString(getPath(pathIn2));
                Files.writeString(getPath(pathOut), content1 + content2, StandardOpenOption.CREATE);
                return Files.readString(getPath(pathOut));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });
    }

    public static Path getPath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        var pathIn1 = "src/main/resources/file11.txt";
        var pathIn2 = "src/main/resources/file2.txt";
        var pathOut = "src/main/resources/file3.txt";

        CompletableFuture<String> result = unionFiles(pathIn1, pathIn2, pathOut);

        System.out.println(result.get());
        // END
    }
}

