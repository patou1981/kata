package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void sampleTests() {
        assertEquals(1, Chess.knight("a3", "b5"));
        assertEquals(2, Chess.knight("a1", "c1"));
        assertEquals(3, Chess.knight("a1", "f1"));
        assertEquals(3, Chess.knight("a1", "f3"));
        assertEquals(4, Chess.knight("a1", "f4"));
        assertEquals(5, Chess.knight("a1", "f7"));
    }
}