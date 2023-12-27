package codewars;

import java.util.Arrays;

public class PossibleArray {
    public static boolean isAllPossibilities(int[] arg) {
        if(Arrays.stream(arg).max().isEmpty()){
            return false;
        }
        final int max = Arrays.stream(arg).max().getAsInt();
        final int min = Arrays.stream(arg).min().getAsInt();
        return min == 0 && max == arg.length - 1;
    }
}
