package codewars;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest3 {
    @Test
     void simpleTests() {
        assertEquals(true, PossibleArray.isAllPossibilities(new int[] {0, 1, 2, 3}));
        assertEquals(false, PossibleArray.isAllPossibilities(new int[] {1, 2, 3, 4}));
        assertEquals(false, PossibleArray.isAllPossibilities(new int[] {6, 0, 4}));
    }
}