package j.com.lib.offer;


import java.util.Arrays;

/**
 * @author : zhupp
 * @date : 2021/11/30
 * description : 调整数组顺序使奇数位于偶数前面
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class offer_21_exchange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange1(new int[]{1, 2, 3, 4})));
    }

    public static int[] exchange1(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            while (left < right && (nums[left] % 2) == 1) {
                //如果是奇数继续找
                left++;
            }
            while (left < right && (nums[right] % 2) == 0) {
                //如果是奇数继续找
                right--;
            }
            swap(nums, left, right);
        }
        return nums;
    }


    public static int[] exchange(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                //奇数
                swap(nums, slow++, fast);
                fast++;
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
