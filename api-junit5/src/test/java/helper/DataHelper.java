package helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataHelper {
    public static String loadResource(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/" + path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
