package j.com.lib.leetcode;

/**
 * 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * <p>
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
 */
public class lt_304_NumMatrix {
    // 定义：preSum[i][j]
    // 记录 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
    int[][] preSum;

    /**
     * 其实优化解法同理，提前计算好。
     *
     * @param matrix
     */
    public lt_304_NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (row == 0 || column == 0) return;
        preSum = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                //// 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    /**
     * // 计算子矩阵 [x1, y1, x2, y2] 的元素和
     * 拿出从 0->x2 0->y2 的前缀和 减去 0->x1 0->y2 再减去 0->x2 0->y1 再加上 0->x1 0-y1的前缀和就是结果
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public int sumRegion(int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
}
