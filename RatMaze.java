public class RatMaze {
    final int N = 4;

    // Prints the solution matrix
    void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    // Checks if a cell is within bounds and is not blocked
    boolean isSafe(int[][] maze, int row, int col) {
        return (row >= 0 && row < N && col >= 0 && col < N && maze[row][col] == 1);
    }

    // Solves the maze problem
    boolean solveMaze(int[][] maze) {
        int[][] sol = new int[N][N];
        
        // Initialize solution matrix to 0
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sol[i][j] = 0;

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    // Utility method to solve the maze using backtracking
    boolean solveMazeUtil(int[][] maze, int row, int col, int[][] sol) {
        // Check if (row, col) is the goal
        if (row == N - 1 && col == N - 1) {
            sol[row][col] = 1;
            return true;
        }

        // Check if maze[row][col] is a valid cell
        if (isSafe(maze, row, col)) {
            sol[row][col] = 1;

            // Move forward in row direction
            if (solveMazeUtil(maze, row + 1, col, sol))
                return true;

            // Move down in column direction
            if (solveMazeUtil(maze, row, col + 1, sol))
                return true;

            // Backtrack: unmark (row, col) as part of the solution path
            sol[row][col] = 0;
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        RatMaze rat = new RatMaze();
        int[][] maze = { 
            { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } 
        };
        rat.solveMaze(maze);
    }
}

	