package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class Task4 {
    private Task4() {
    }

    public static void composedWrite() throws IOException {
        File f = Path.of("aboba.txt").toFile();
        try (OutputStream os = new FileOutputStream(f);
            CheckedOutputStream cos = new CheckedOutputStream(os, new CRC32());
            BufferedOutputStream bos = new BufferedOutputStream(cos);
            OutputStreamWriter osw = new OutputStreamWriter(bos, StandardCharsets.UTF_8);
            PrintWriter pw = new PrintWriter(osw)) {
            pw.write("Programming is learned by writing programs. ― Brian Kernighan");
        }
    }
}
