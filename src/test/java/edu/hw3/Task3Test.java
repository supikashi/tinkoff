package edu.hw3;

import edu.hw3.Task3.MyDictionary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    static Arguments[] arguments() {
        ArrayList<String> list1 = new ArrayList<>(List.of(new String[] {"a", "bb", "a", "bb"}));
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("bb", 2);
        map1.put("a", 2);

        ArrayList<String> list2 = new ArrayList<>(List.of(new String[] {"this", "and", "that", "and"}));
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("that", 1);
        map2.put("and", 2);
        map2.put("this", 1);

        ArrayList<String> list3 = new ArrayList<>(List.of(new String[] {"код", "код", "код", "bug"}));
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("код", 3);
        map3.put("bug", 1);

        ArrayList<Integer> list4 = new ArrayList<>(List.of(new Integer[] {1, 1, 2, 2}));
        HashMap<Integer, Integer> map4 = new HashMap<>();
        map4.put(1, 2);
        map4.put(2, 2);

        return new Arguments[] {
            Arguments.of(list1, map1),
            Arguments.of(list2, map2),
            Arguments.of(list3, map3),
            Arguments.of(list4, map4)
        };
    }

    @ParameterizedTest
    @MethodSource("arguments")
    @DisplayName("Словарь")
    void myDictionaryTest(ArrayList<String> input, HashMap<String, Integer> expected) {
        // given
        // input

        // when
        HashMap<String, Integer> map = MyDictionary.freqDict(input);

        // then
        assertThat(map).isEqualTo(expected);
    }
}
