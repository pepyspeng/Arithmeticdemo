package j.com.lib.leetcode;

import java.util.Arrays;

public class lt_34_searchRange {


    public static void main(String[] args) {
        lt_34_searchRange range = new lt_34_searchRange();
        System.out.println(Arrays.toString(range.searchRange(new int[]{2, 2}, 3)));
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = getLeft(nums, target);
        int right = getRight(nums, target);
        return new int[]{left, right};
    }

    public int getLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                //找到的数比目标小，应该放弃右边的。
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                //要找左边界，当前位置有可能不是，移除右边界
                right = mid;
            }
        }
        //// target 比所有数都大
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int getRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
