package j.com.lib.leetcode;

/**
 * 盛最多水的容器
 *
 * @see j.com.lib.leetcode.lt_42_trap
 */
public class lt_11_maxArea {


    /**
     * 这题和接雨水问题很类似，可以完全套用前文的思路，而且还更简单。两道题的区别在于：
     * 用 left 和 right 两个指针从两端向中心收缩，一边收缩一边计算 [left, right] 之间的矩形面积，取最大的面积值即是答案。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int res = 0;
        while (left < right) {
            // Math.min(height[left],height[right])：求最小的长度
            // (right-left)： 宽度是固定值
            int curArea = Math.min(height[left], height[right]) * (right - left);
            //得到大面积的
            res = Math.max(curArea, res);
            //双指针应该怎么移动？
            //移动矮的一边，因为矮的可能移动之后变高的，可以得到更大面积
            //移动高的一边，矩形的高度是无论如何都不会变大的，
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
