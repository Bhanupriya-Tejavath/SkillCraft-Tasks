public class SudokuSolver {

    static final int SIZE = 9;

    public static boolean solve(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board))
                                return true;

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {

        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num || board[x][col] == num)
                return false;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {3,0,6,5,0,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,0,6,3,0,0}
        };

        if (solve(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}