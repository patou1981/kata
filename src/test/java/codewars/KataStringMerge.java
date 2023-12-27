package codewars;

public class KataStringMerge {
    public static String stringMerge(String s1, String s2, char letter) {
        var occurenceS1 = s1.indexOf(letter);
        var occureanceS2 = s2.indexOf(letter);
        return s1.substring(0, occurenceS1 ) + s2.substring(occureanceS2);
    }
}
