package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Kata {
    public static int[] arrayDiff(int[] a, int[] b) {
        return IntStream.of(a).filter(value -> IntStream.of(b).noneMatch(x -> x == value))
                .toArray();
    }
}
