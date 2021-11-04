package j.com.lib.offer;

/**
 *  顺时针打印矩阵
 *  输入：matrix =
 *  [[1,2,3],
 *   [4,5,6],
 *   [7,8,9]]
 *
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class offer_29_spiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int[] result = new int[matrix[0].length * matrix.length];
        int index = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >=left ; i--) {
                result[index++] = matrix[bottom][i];
            }
            bottom--;
            if(top > bottom){
                break;
            }
            for (int i = bottom; i >=top ; i++) {
                result[index++] = matrix[i][left];
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return  result;
    }
}
