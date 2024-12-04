package adventofcode_2024;

import java.nio.file.Files;
import java.nio.file.Path;

public class Util {

    /**
     * Read the file from the given path
     * @param filePath The path to the file
     * @return The content of the file
     * @throws Exception If the file could not be read
     */
    public static String readFile(String filePath) throws Exception {
        return Files.readString(Path.of(filePath));
    }

}
