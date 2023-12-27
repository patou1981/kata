package codewars;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringMergeTest {
   @Test
    public void test1(){
      assertEquals("pere", KataStringMerge.stringMerge("person","here", 'e'));
    }
    @Test
    public void test2(){
      assertEquals("apowiejouh", KataStringMerge.stringMerge("apowiejfoiajsf","iwahfeijouh", 'j'));
    }
    @Test
    public void test3(){
      assertEquals("abcdefxxxyyyxyzz", KataStringMerge.stringMerge("abcdefxxxyzz","abcxxxyyyxyzz", 'x'));
    } 
}