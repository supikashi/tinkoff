package edu.hw5.Task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class MySubstring {
    private MySubstring() {
    }

    public static boolean isSubstring(@NotNull String s, @NotNull String t) {
        StringBuilder sb = new StringBuilder();
        if (!s.isEmpty()) {
            sb.append(s.charAt(0));
        }
        for (int i = 1; i < s.length(); i++) {
            sb.append(".*").append(s.charAt(i));
        }
        Pattern pattern = Pattern.compile(sb.toString());
        Matcher matcher = pattern.matcher(t);
        return matcher.find();
    }
}
