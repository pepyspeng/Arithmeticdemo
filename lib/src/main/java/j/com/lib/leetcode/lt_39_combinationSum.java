package j.com.lib.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */
public class lt_39_combinationSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3,6,5,4,9};
        lt_39_combinationSum combine = new lt_39_combinationSum();
        combine.combinationSum(arr, 8);
        combine.res.forEach(integers -> System.out.println(Arrays.toString(integers.toArray())));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target);
        return  res;
    }

    public void backtrack(int[] arr, int start, int target) {
        //得到了，就加入
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
        }
        //由于在下面循环的时候，不会改变start,所以要想办法结束回溯。
        if (trackSum > target) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            track.addLast(arr[i]);
            trackSum += arr[i];
            backtrack(arr, i, target);
            track.removeLast();
            trackSum -= arr[i];
        }
    }


}
