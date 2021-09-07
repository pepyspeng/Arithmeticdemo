package j.com.lib.offer;

import java.util.ArrayList;

/**
 * @author : zhupp
 * @date : 2021/9/6
 * description : 和为s的两个数字
 */
public class offer_52_FindNumbersWithSum {
    public static void main(String[] args) {
//        System.out.println(FindNumbersWithSum(9));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return result;
        }
        int left = 0;
        int right = array.length - 1;
        int temp = Integer.MAX_VALUE;
        while (left < right) {
            int count = array[left] + array[right];
            if (count == sum && array[left] * array[right] < temp) {
                temp = array[left] * array[right];
                result.add(array[left]);
                result.add(array[right]);
                return result;
            } else if (count < sum) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
