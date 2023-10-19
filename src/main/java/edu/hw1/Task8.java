package edu.hw1;

public class Task8 {
    private static final int N = 8;
    private static final int[][] KNIGHT_MOVES = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
                                                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {

        boolean output = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < N; k++) {
                        if (0 <= i + KNIGHT_MOVES[k][0] && i + KNIGHT_MOVES[k][0] < N
                            && 0 <= j + KNIGHT_MOVES[k][1] && j + KNIGHT_MOVES[k][1] < N) {
                            if (board[i + KNIGHT_MOVES[k][0]][j + KNIGHT_MOVES[k][1]] == 1) {
                                output = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return output;
    }
}
