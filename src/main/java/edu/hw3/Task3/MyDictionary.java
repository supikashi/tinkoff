package edu.hw3.Task3;

import java.util.ArrayList;
import java.util.HashMap;

public class MyDictionary {
    private MyDictionary() {
    }

    public static <T> HashMap<T, Integer> freqDict(ArrayList<T> list) {
        if (list == null) {
            return null;
        }
        HashMap<T, Integer> map = new HashMap<>();
        for (T t : list) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        return map;
    }
}
