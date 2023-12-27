package codewars;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Chess {

    public static int knight(String start, String end) {
        int startX = start.charAt(0) - 'a' + 1;
        int startY = Integer.parseInt(String.valueOf(start.charAt(1)));
        int endX = end.charAt(0) - 'a' + 1;
        int endY = Integer.parseInt(String.valueOf(end.charAt(1)));

        return calculateMoves(startX, startY, endX, endY);
    }

    private static int calculateMoves(int startX, int startY, int endX, int endY) {
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        int[][] distance = new int[9][9];

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(startX, startY));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> current = queue.poll();
            int x = current.getKey();
            int y = current.getValue();

            if (x == endX && y == endY) {
                return distance[x][y];
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && distance[nx][ny] == 0) {
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.offer(new Pair<>(nx, ny));
                }
            }
        }

        return -1; // Destination not reachable
    }

    private static boolean isValid(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }


    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
