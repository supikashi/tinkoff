package edu.hw3.Task2;

import java.util.ArrayList;

public class Cluster {
    private Cluster() {
    }

    public static String[] clusterize(String str) {
        if (str == null) {
            return null;
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            cnt = cnt + switch (str.charAt(i)) {
                case '(' -> 1;
                case ')' -> -1;
                default -> 0;
            };
            if (cnt == -1 || (cnt == 0 && str.charAt(i) != ')')) {
                return new String[0];
            }
            sb.append(str.charAt(i));
            if (cnt == 0) {
                out.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return out.toArray(new String[0]);
    }
}
