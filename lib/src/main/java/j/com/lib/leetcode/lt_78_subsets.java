package j.com.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class lt_78_subsets {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        lt_78_subsets subsets = new lt_78_subsets();
        subsets.subsets(arr);
        subsets.res.forEach(integers -> System.out.println(Arrays.toString(integers.toArray())));
    }

    // 记录结果
    List<List<Integer>> res = new ArrayList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    /**
     * 回溯算法核心函数，遍历子集问题的回溯树
     * 因为不能包含重复元素，那么需要用start去防止向前取值
     *
     * @param nums
     * @param start
     */
    public void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
