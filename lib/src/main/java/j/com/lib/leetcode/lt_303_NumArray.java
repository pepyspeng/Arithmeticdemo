package j.com.lib.leetcode;

/**
 * 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 */
public class lt_303_NumArray {

    int[] preSum;

    /**
     * 1.最暴力的算法，就是每次调用sumRange，for循环计算一次。时间复杂度是O(n)，
     * 2.想在O(1)内得到，那么就直接计算好所有位置的前缀和，获取的直接可以直接拿到
     *
     * @param nums
     */
    public lt_303_NumArray(int[] nums) {
        //+1的目的是多算一位，方便计算
        preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /**
     * 因为左右都是闭区间，所有右边需要加1
     * right-left 就是需要的 区间内的 前缀和
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}
