package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2File {
    private Task2File() {
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static void cloneFile(Path path) throws IOException {
        Path copied;
        String[] s = path.getFileName().toString().split("\\.");
        if (path.resolveSibling(s[0] + " — копия." + s[1]).toFile().exists()) {
            int i = 2;
            while (path.resolveSibling(s[0] + " — копия (" + i + ")." + s[1]).toFile().exists()) {
                i++;
            }
            copied = path.resolveSibling(s[0] + " — копия (" + i + ")." + s[1]);
        } else {
            copied = path.resolveSibling(s[0] + " — копия." + s[1]);
        }
        Files.copy(path, copied);
    }
}
