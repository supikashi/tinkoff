package edu.hw6.Task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class DiskMap extends HashMap<String, String> {
    private final String path;

    public DiskMap(String path) {
        this.path = path;
    }

    public void saveOnDisk() {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (var i: this.entrySet()) {
                writer.append(i.getKey())
                    .append(":")
                    .append(i.getValue())
                    .append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFromFile() {
        try (FileReader reader = new FileReader(path)) {
            int c;
            StringBuilder sb = new StringBuilder();
            String[] strEntry;
            while ((c = reader.read()) != -1) {
                if ((char) c == '\n') {
                    strEntry = sb.toString().split(":");
                    this.put(strEntry[0], strEntry[1]);
                    sb.delete(0, sb.length());
                } else {
                    sb.append((char) c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
