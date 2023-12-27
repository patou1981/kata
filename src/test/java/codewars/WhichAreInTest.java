package codewars;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/*
Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.

    Example 1:
    a1 = ["arp", "live", "strong"]

    a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

    returns ["arp", "live", "strong"]

    Example 2:
    a1 = ["tarp", "mice", "bull"]

    a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

    returns []

    Notes:
    Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
    In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
    Beware: r must be without duplicates.
*/

class WhichAreInTest {

  @Test
  void test1() {
    String a[] = new String[]{"arp", "live", "strong"};
    String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
    String r[] = new String[]{"arp", "live", "strong"};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

  @Test
  void test2() {
    String a[] = new String[]{"arp", "mice", "bull"};
    String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
    String r[] = new String[]{"arp"};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

  @Test
  void test3() {
    String a[] = new String[]{"cod", "code", "wars", "ewar", "pillow", "bed", "phht"};
    String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong", "codewars"};
    String r[] = new String[]{"cod", "code", "ewar", "wars"};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

  @Test
  void test4() {
    String a[] = new String[]{"cod", "code", "wars", "ewar", "ar"};
    String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong", "codewars"};
    String r[] = new String[]{"ar", "cod", "code", "ewar", "wars"};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

  @Test
  void test5() {
    String a[] = new String[]{"cod", "code", "wars", "ewar", "ar"};
    String b[] = new String[]{};
    String r[] = new String[]{};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

  @Test
  void test6() {
    String a[] = new String[]{"1295", "code", "1346", "1028", "ar"};
    String b[] = new String[]{"12951295", "ode", "46", "10281066", "par"};
    String r[] = new String[]{"1028", "1295", "ar"};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

  @Test
  void test7() {
    String a[] = new String[]{"&()", "code", "1346", "1028", "ar"};
    String b[] = new String[]{"12&()95", "coderange", "46", "1066", "par"};
    String r[] = new String[]{"&()", "ar", "code"};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

  @Test
  void test8() {
    String a[] = new String[]{"ohio", "code", "1346", "1028", "art"};
    String b[] = new String[]{"Carolina", "Ohio", "4600", "NY", "California"};
    String r[] = new String[]{};
    assertArrayEquals(r, WhichAreIn.inArray(a, b));
  }

}