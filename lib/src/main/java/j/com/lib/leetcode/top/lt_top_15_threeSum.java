package j.com.lib.leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class lt_top_15_threeSum {

    public static void main(String[] args) {
        lt_top_15_threeSum threeSum = new lt_top_15_threeSum();
        int[] nums = {2,2,2,2,2};
        List<List<Integer>> res = threeSum.fourSum(nums,8);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> temp = res.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + ",");
            }
            System.out.println("------------------");
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums,4,0,target);
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }

    /**
     * n 数之和
     *
     * @param nums   排序好的数组
     * @param n      n个数之和
     * @param start  从数组的哪个位置开始
     * @param target 目标值
     */
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        //至少是两数字和，并且n不能大于数组长度
        if (n < 2 || n > length) {
            return res;
        }
        if (n == 2) {
            //base case就是两数之和
            res = twoSum(nums, start, target);
        } else {
            // 大于两数之和的，想办法分解，
            // 也就是递归计算 n =(n-1) ,target = target-nums[i]
            for (int i = start; i < length; i++) {
                //得到递归的  n =(n-1) n数之和的数据
                List<List<Integer>> temp = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : temp) {
                    //得到的数组 + 当前数据，也就是当前的n个数之和
                    list.add(nums[i]);
                    res.add(list);
                }
                // 要防止出现第一个数字是重复的情况，也就是防止重复结果
                while (i < length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }

    /**
     * 两数字和
     *
     * @param nums   这里的数组必须是排好序
     * @param target 目标值
     * @return
     */
    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int leftValue = nums[left];
            int rightValue = nums[right];
            //计算sum
            int sum = leftValue + rightValue;
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(leftValue);
                temp.add(rightValue);
                res.add(temp);
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            } else if (sum < target) {
                //防止数组中有重复的数据
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
            } else {
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            }
        }
        return res;
    }

}
