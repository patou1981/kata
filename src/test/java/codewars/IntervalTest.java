package codewars;

import static codewars.Interval.sumIntervals;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class IntervalTest {

  private int[][] shuffle(int[][] a) {
    List<int[]> list = new ArrayList<>(a.length);
    Collections.addAll(list, a);
    Collections.shuffle(list);
    return list.toArray(new int[a.length][2]);
  }

  private int shuffleAndSumIntervals(int[][] arg) {
    return sumIntervals(shuffle(arg));
  }

  @Test
  void shouldHandleNullOrEmptyIntervals() {
    assertEquals(0, sumIntervals(null));
    assertEquals(0, sumIntervals(new int[][]{}));
    assertEquals(0, shuffleAndSumIntervals(new int[][]{{4, 4}, {6, 6}, {8, 8}}));
  }

  @Test
  void shouldAddDisjoinedIntervals() {
    assertEquals(9, shuffleAndSumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
    assertEquals(11, shuffleAndSumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
    assertEquals(7, shuffleAndSumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
    assertEquals(78, shuffleAndSumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
  }

  @Test
  void shouldAddAdjacentIntervals() {
    assertEquals(54, shuffleAndSumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
    assertEquals(23, shuffleAndSumIntervals(new int[][]{{-2, -1}, {-1, 0}, {0, 21}}));
  }

  @Test
  public void shouldAddOverlappingIntervals() {
    assertEquals(7, shuffleAndSumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
    assertEquals(6, shuffleAndSumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
    assertEquals(19,
        shuffleAndSumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
  }

  @Test
  void shouldHandleMixedIntervals() {
    assertEquals(13, shuffleAndSumIntervals(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}}));
    assertEquals(1234, shuffleAndSumIntervals(
        new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}));
    assertEquals(158, shuffleAndSumIntervals(
        new int[][]{{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26},}));
  }

  @Test
  void shouldHandleRandomIntervals() {
    final int totalTests = 1000;
    IntStream.rangeClosed(1, totalTests)
        .mapToObj(i -> generateRandomSeq())
        .forEach(test -> {
          final String msg = String.format("testing: %s%n", stringifyInterval(test));
          final int expected = expect(test);
          final int actual = sumIntervals(test);
          assertEquals(expected, actual, msg);
        });
  }

  private int[][] generateRandomSeq() {
    final int total = ((int) (Math.random() * 30) + 10) * 2;
    final int[] seq = new Random().ints(total, -10000, 10000).toArray();
    final int[][] intervals = new int[total / 2][2];
    for (int i = 1; i < total; i += 2) {
      final int a = Math.min(seq[i], seq[i - 1]);
      final int b = Math.max(seq[i], seq[i - 1]);
      final int idx = i / 2;
      intervals[idx][0] = a;
      intervals[idx][1] = b;
    }
    return intervals;
  }

  private String stringifyInterval(int[][] i) {
    return Arrays.stream(i).map(Arrays::toString).collect(joining(", "));
  }

  private int expect(int[][] intervals) {
    if (intervals == null) {
      return 0;
    }
    int[][] sortedIntervals = Arrays.stream(intervals)
        .filter(i -> i.length == 2 && i[0] < i[1])
        .sorted((a, b) -> {
          int diff = a[0] - b[0];
          return diff != 0 ? diff : b[1] - a[1];
        })
        .toArray(int[][]::new);
    if (sortedIntervals.length == 0) {
      return 0;
    }
    int lastHi = sortedIntervals[0][0], sum = 0;
    for (int[] interval : sortedIntervals) {
      if (interval[1] <= lastHi) {
        continue;
      }
      if (interval[0] >= lastHi) {
        sum += interval[1] - interval[0];
      } else {
        sum += interval[1] - lastHi;
      }
      lastHi = interval[1];
    }
    return sum;
  }
}
