package j.com.lib.leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * 最长递增子序列
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 */
public class lt_300_lengthOfLIS {
    public static void main(String[] args) {
        lt_300_lengthOfLIS lis = new lt_300_lengthOfLIS();
        System.out.println(lis.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    /**
     * 可以用一个数组保存，当前位置 index 之前 比当前位置小的数有几个
     * index    0   1   2   3   4
     * nums     1   4   3   4   2
     * 在index:0时，arr[0]= nums中比1小的就自己有一个，也就是arr[0] = 1
     * 在index:1时，arr[1]= nums中比4小的包括自己有两个，就是arr[1] = 2
     * 在index:2时，arr[2]= nums中比3小的包括自己有两个，就是arr[2] = 2
     * 在index:3时，arr[3]= nums中比4小的保罗自己有三个，就是arr[3] = 3
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //首先需要一个数据保存结果
        int[] arr = new int[n];
        //初始值是1，因为需要算上自己
        Arrays.fill(arr, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //只有当在 第二重循环的数，小于，第一重循环的数，数量需要加1
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
        }
        int res = 1;
        for (int num : arr) {
            res = Math.max(res, num);
        }
        return res;
    }
}
