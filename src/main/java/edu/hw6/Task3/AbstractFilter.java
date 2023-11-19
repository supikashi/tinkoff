package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    default AbstractFilter and(AbstractFilter other) {
        return entry -> AbstractFilter.this.accept(entry) && other.accept(entry);
    }

    @SuppressWarnings("ConstantName")
    AbstractFilter regularFile = Files::isRegularFile;
    @SuppressWarnings("ConstantName")
    AbstractFilter readable = Files::isReadable;

    static AbstractFilter largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    /*static AbstractFilter magicNumber(int... magicNumbers) {
        return path -> {
            try {
                byte[] bytes = Files.readAllBytes(path);
                if (bytes.length < magicNumbers.length) {
                    return false;
                }
                for (int i = 0; i < magicNumbers.length; i++) {
                    if (bytes[i] != magicNumbers[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }*/

    static AbstractFilter extensionFilter(String extension) {

        return path -> Pattern.compile(extension + "$")
            .matcher(path.toString()).find();
    }

    static AbstractFilter regexContains(String regex) {
        return path -> Pattern.compile(regex)
            .matcher(path.toString()).find();
    }
}


