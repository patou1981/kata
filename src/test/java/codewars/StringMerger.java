package codewars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class StringMerger {
    public static Boolean isMerge(String s, String part1, String part2) {
        System.out.println(part1);
        System.out.println(part2);
        int count = Math.max(part1.length(), part2.length());
        List<List<String>> lst = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<String> l = new ArrayList<>();
            if (part1.length() > i) {
                l.add(String.valueOf(part1.charAt(i)));
            }
            if (part2.length() > i) {
                l.add(String.valueOf(part2.charAt(i)));
            }
            lst.add(l);
        }
        final String toCheck = lst.stream().flatMap(Collection::stream).map(Objects::toString).reduce("", String::concat);
        System.out.println(toCheck);
        return s.equals(part1 + part2) || s.equals(toCheck);
    }
}
