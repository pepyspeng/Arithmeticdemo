package j.com.lib.offer;


/**
 * Created by pepys on 2019/6/25
 * description:二维数组中的查找
 */
public class offer_3_find2Array {


    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        find2Array(array, 7);
    }


    public static void find2Array(int[][] array, int target) {
        int row = 0;
        int colums = array.length - 1;

        while (row >= 0 || colums >= 0) {
            if (array[row][colums] == target) {
                System.out.println("找到结果,位于第" + (row + 1) + "行,第" + (colums + 1) + "列");
                return;
            } else if (array[row][colums] > target) {
                //说明当前行的所有数据都比目标值小，因为排除当前行
                colums--;
            } else if (array[row][colums] < target) {
                //说明当前列的所有数据都比目标值大，因为排除当前列
                row++;
            }
        }

    }


    public void find(int[][] array,int row,int colum,int target) {

    }

}
