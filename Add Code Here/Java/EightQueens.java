public class EightQueens {
    static final int N = 8;

    // A utility function to print the solution
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // A utility function to check if a queen can be placed on board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check the left side of the row
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper diagonal on the left
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower diagonal on the left
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // A recursive utility function to solve the 8-Queens problem
    static boolean solveNQueensUtil(int[][] board, int col) {
        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueensUtil(board, col + 1)) {
                    return true;
                }

                // If placing a queen in board[i][col] doesn't lead to a solution,
                // then remove the queen (backtrack)
                board[i][col] = 0;
            }
        }

        return false;
    }

    // Main function to solve the 8-Queens problem
    static boolean solveNQueens() {
        int[][] board = new int[N][N];

        if (!solveNQueensUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        solveNQueens();
    }
}
