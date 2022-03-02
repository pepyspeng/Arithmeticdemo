package j.com.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lt_46_permute {

    public static void main(String[] args) {
        lt_46_permute permute = new lt_46_permute();
        permute.permute(new int[]{0, 1});
        System.out.println("结束");
    }


    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     *
     * @param nums
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        path(nums, list);
        return res;
    }

    public void path(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            path(nums, list);
            list.removeLast();
        }
    }

}
