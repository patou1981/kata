package codewars;

import java.util.Arrays;

public class MaxDiffLength {
    public static int mxdiflg(String[] a1, String[] a2) {
        return Arrays.stream(a1)
                .flatMap(str1 -> Arrays.stream(a2)
                        .map(str2 -> Math.abs(str1.length() - str2.length())))
                .max(Integer::compare).orElse(-1);
    }
}
