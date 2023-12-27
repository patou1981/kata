package codewars;

import java.util.Arrays;
import java.util.Objects;

public class WhichAreIn {
    public static String[] inArray(String[] array1, String[] array2) {
        return Arrays.stream(array1).flatMap(str -> Arrays.stream(array2).map(str2 -> str2.contains(str) ? str : null))
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .peek(System.out::println).toArray(String[]::new);
    }
}
