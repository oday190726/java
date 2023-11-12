
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    public void callBFS(char[][] grid, int i, int j) {
        // Base case: Check if indices are out of bounds or if the current cell is '0'
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited
        grid[i][j] = '0';

        // Recursive calls for adjacent cells
        callBFS(grid, i + 1, j); // up
        callBFS(grid, i - 1, j); // down
        callBFS(grid, i, j - 1); // left
        callBFS(grid, i, j + 1); // right
    }
}

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int islandCount = solution.numIslands(grid);
        System.out.println("Number of islands: " + islandCount);
    }
}