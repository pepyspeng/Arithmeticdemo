package j.com.lib.leetcode;

/**
 * 岛屿数量
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 */
public class lt_200_numIslands {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        lt_200_numIslands numIslands = new lt_200_numIslands();
        System.out.println(numIslands.numIslands(grid));
    }

    int res = 0;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //说明是岛屿
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * @param grid
     * @param m
     * @param n
     */
    public void dfs(char[][] grid, int m, int n) {
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length) {
            //越界了。
            return;
        }
        if (grid[m][n] == '0') {
            //说明是水，返回
            return;
        }
        //让当前地方变成水
        grid[m][n] = '0';
        //淹没四周的岛屿
        dfs(grid, m + 1, n);
        dfs(grid, m, n + 1);
        dfs(grid, m - 1, n);
        dfs(grid, m, n - 1);
    }
}
