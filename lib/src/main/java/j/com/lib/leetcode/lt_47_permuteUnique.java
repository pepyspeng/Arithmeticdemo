package j.com.lib.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 */
public class lt_47_permuteUnique {
    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 2, 7};
        lt_47_permuteUnique combine = new lt_47_permuteUnique();
        combine.permuteUnique(arr);
        combine.res.forEach(integers -> System.out.println(Arrays.toString(integers.toArray())));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] isUsed;

    public List<List<Integer>> permuteUnique(int[] nums) {
        isUsed = new boolean[nums.length];
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] arr) {
        if (arr.length == track.size()) {
            res.add(new ArrayList<>(track));
        }
        for (int i = 0; i < arr.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            //剪枝
            if (i > 0 && arr[i] == arr[i - 1] && !isUsed[i - 1]) {
                continue;
            }
            isUsed[i] = true;
            track.addLast(arr[i]);
            backtrack(arr);
            isUsed[i] = false;
            track.removeLast();
        }
    }
}
