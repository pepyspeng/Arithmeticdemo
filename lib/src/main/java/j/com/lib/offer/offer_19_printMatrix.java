package j.com.lib.offer;

import java.util.ArrayList;

/**
 * @author     : zhupp
 * @date       : 2021/7/31
 * description : 顺时针打印矩阵
 */
public class offer_19_printMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[2][];
        matrix[0] = new int[]{1,2};
        matrix[1] = new int[]{3,4};
        ArrayList<Integer> result = printMatrix(matrix);
        for (int i:result){
            System.out.println(i);
        }
    }


    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (up <= down && left <= right) {
            //向右
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            if(up>down){
                break;
            }
            //向下
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if(left>right){
                break;
            }
            //向左
            for (int i = right ; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            if(up>down){
                break;
            }
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if(left>right){
                break;
            }
        }
        return result;
    }
}
