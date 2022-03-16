package j.com.lib.leetcode;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 示例 1：
 * matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class lt_48_rotate {
    /**
     * 我们可以先将 n x n 矩阵 matrix 按照左上到右下的对角线进行镜像对称：
     * <p>
     * 然后再对矩阵的每一行进行反转：
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        /**
         * 我们可以先将 n x n 矩阵 matrix 按照左上到右下的对角线进行镜像对称：
         */
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /**
         * 在反转每一行
         */
        for (int i = 0; i < n; i++) {
            reverseArr(matrix[i]);
        }
    }

    public void reverseArr(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
