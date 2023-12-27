package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chess {

    public static int findMinimumMoves(int count, String start, String finish, List<String> movesAlreadyCheck) {
        final List<String> possibleMoves = possibleMove(start).stream().filter(move -> !movesAlreadyCheck.contains(move)).collect(Collectors.toList());
        System.out.print(count);
        System.out.println(Arrays.toString(possibleMoves.toArray()));
        for (String move : possibleMoves) {
            if (move.equals(finish)) {
                System.out.println(move);
                return count;
            }
            movesAlreadyCheck.add(move);
        }
        for (String move : possibleMoves) {
            final int minimumMoves = findMinimumMoves(count + 1, move, finish, movesAlreadyCheck);
            if (count > 0) {
                return minimumMoves;
            }
        }
        return 0;
    }

    public static int knight(String start, String finish) {
        return findMinimumMoves(1, start, finish, new ArrayList<>());
    }

    private static List<String> possibleMove(String position) {
        final char[] chars = position.toCharArray();
        char files = chars[0];
        char ranks = chars[1];
        String[] movs = new String[8];
        movs[0] = Character.toString(files + 1) + Character.toString(ranks + 2);
        movs[1] = Character.toString(files + 1) + Character.toString(ranks - 2);
        movs[2] = Character.toString(files - 1) + Character.toString(ranks - 2);
        movs[3] = Character.toString(files - 1) + Character.toString(ranks + 2);
        movs[4] = Character.toString(files + 2) + Character.toString(ranks + 1);
        movs[5] = Character.toString(files + 2) + Character.toString(ranks - 1);
        movs[6] = Character.toString(files - 2) + Character.toString(ranks - 1);
        movs[7] = Character.toString(files - 2) + Character.toString(ranks + 1);

        return Arrays.stream(movs)
                .filter(Chess::isMovePossible)
                .collect(Collectors.toList());
    }

    private static boolean isMovePossible(String position) {
        final char[] chars = position.toCharArray();
        char files = chars[0];
        char ranks = chars[1];

        return files > '`' && files < 'i' && ranks > '0' && ranks < '9';
    }
}
