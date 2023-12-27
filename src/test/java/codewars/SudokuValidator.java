package codewars;

import java.util.Arrays;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
        System.out.println(Arrays.deepToString(sudoku));
        for(int i = 0; i<9; i++){
            if (!containsAll(sudoku[i])) {
                return false;
            }
        }
        for(int i = 0; i<9; i++){
            int[] data = new int[9];
            for(int y = 0; y<9; y++) {
                data[y] = sudoku[y][i];
            }
            if (!containsAll(data)) {
                return false;
            }
        }

        for(int i = 0; i<9; i = i+3){
            for(int x = 0; x<9; x = x+3){
                int[] data = new int[9];
                int count = 0;
            for(int y=0; y<3; y++ ) {
                for(int z=0; z<3; z++) {
                    data[count] = sudoku[i+y][z];
                    count++;
                }
            }
                if (!containsAll(data)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean containsAll(int[] toCheck){
        final int[] clone = toCheck.clone();
        Arrays.sort(clone);
        for(int i = 0; i<9; i++){
            if (clone[i] != i+1) {
                return false;
            }
        }
        return true;
    }
}
