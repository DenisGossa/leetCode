public class Solution {
    private static boolean[][] vizited;
    private static int curcnt = 0;

    public int maxAreaOfIsland(int[][] grid) {
        vizited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (vizited[i][j] == true) {
                    continue;
                } else {
                    curcnt = vizit(i, j, grid);
                    if (curcnt > maxArea) {
                        maxArea = curcnt;
                    }
                    curcnt = 0;
                }
            }
        }
        return maxArea;
    }

    private int vizit(int i, int j, int[][] grid) {
        //check the borders or has visited
        if (j < 0 || j > grid[0].length - 1 || i < 0 || i > grid.length - 1 || vizited[i][j]) {
            return 0;
        }
        //mark field as vizited
        vizited[i][j] = true;
        if (grid[i][j] == 0) {
            return 0;
        }
        // find near fields if its present (left,right,up,down) and + one current
        return 1 + vizit(i, j - 1, grid) +
                vizit(i, j + 1, grid) +
                vizit(i - 1, j, grid) +
                vizit(i + 1, j, grid);
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        int[][] grid2 = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        Solution solution = new Solution();
        int res = solution.maxAreaOfIsland(grid2);
        System.out.println(res);
    }
}
