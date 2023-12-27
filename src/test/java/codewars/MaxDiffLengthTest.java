package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxDiffLengthTest {
    
    @Test
     void test() {
        System.out.println("mxdiflg Fixed Tests");
        String[] s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        assertEquals(13, MaxDiffLength.mxdiflg(s1, s2)); // 13
    }
}
