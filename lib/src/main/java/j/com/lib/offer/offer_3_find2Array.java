package j.com.lib.offer;


/**
 * Created by pepys on 2019/6/25
 * description:二维数组中的查找
 * <p>
 * 1   2   8   9
 * 2   4   9   12
 * 4   7   10  13
 * 6   8   11  15
 */
public class offer_3_find2Array {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
//        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
//        find2Array(array, 11);
        System.out.println("没找到结果-"+tableSizeFor(1000));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static void find2Array(int[][] array, int target) {
        int row = 0;
        int column = array[0].length - 1;
        int rowLength = array.length;
        while (row < rowLength && column > 0) {
            int currentData = array[row][column];
            if (currentData == target) {
                System.out.println("找到结果,位于第" + (row + 1) + "行,第" + (column + 1) + "列");
                return;
            } else if (currentData < target) {
                row++;
            } else if (currentData > target) {
                column--;
            }
        }
        System.out.println("没找到结果");

    }


//    public static void find2Array(int[][] array, int target) {
//        int row = 0;
//        int colum = array[0].length - 1;
//
//        while (row < array.length && colum >= 0) {
//            if (array[row][colum] == target) {
//                System.out.println("找到结果,位于第" + (row + 1) + "行,第" + (colum + 1) + "列");
//                return;
//            } else if (array[row][colum] > target) {
//                //说明当前行的所有数据都比目标值小，因为排除当前行
//                colum--;
//            } else if (array[row][colum] < target) {
//                //说明当前列的所有数据都比目标值大，因为排除当前列
//                row++;
//            }
//        }
//        System.out.println("没找到结果");
//    }


    public void find(int[][] array, int row, int colum, int target) {

    }

}
