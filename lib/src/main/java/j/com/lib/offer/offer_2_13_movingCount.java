package j.com.lib.offer;

/**
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class offer_2_13_movingCount {

    public int movingCount1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs1(0, 0, m, n, k, visited);
    }

    private int dfs1(int row, int column, int m, int n, int k, boolean[][] visited) {
        // 数组越界
        if (row < 0 || row >= m || column < 0 || column >= n
                //已经访问过的
                || visited[row][column]
                //限制不能进入的地方
                || sum1(row, column) > k) {
            return 0;
        }
        visited[row][column] = true;
        //沿着右边走
        int count1 = dfs1(row, column + 1, m, n, k, visited);
        //沿着下边走
        int count2 = dfs1(row + 1, column, m, n, k, visited);
        return count1 + count2 + 1;
    }

    private int sum1(int row, int column) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (column != 0) {
            sum += column % 10;
            column = column / 10;
        }
        return sum;
    }


    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0, 0, k);
    }

    private int dfs(int i, int j, int k) {
        if (i >= m || j >= n || visited[i][j]
                // k < sum(i, j)判断当前格子坐标是否满足条件
                || sum(i, j) > k) {
            return 0;
        }
        visited[i][j] = true;
        // 沿着当前格子的 右边 继续访问
        int count1 = dfs(i + 1, j, k);
        // 沿着当前 下边 继续访问
        int count2 = dfs(i, j + 1, k);
        return count1 + count2 + 1;
    }

    // 计算两个坐标数字的和
    private int sum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
