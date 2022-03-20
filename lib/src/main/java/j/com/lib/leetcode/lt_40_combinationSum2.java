package j.com.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class lt_40_combinationSum2 {

    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,7,6,1,5};
        lt_40_combinationSum2 combine = new lt_40_combinationSum2();
        combine.combinationSum2(arr, 8);
        combine.res.forEach(integers -> System.out.println(Arrays.toString(integers.toArray())));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        //candidates 可能存在重复元素，且其中的每个数字最多只能使用一次。
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
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
            // 剪枝逻辑，值相同的树枝，只遍历第一条
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            track.addLast(arr[i]);
            trackSum += arr[i];
            backtrack(arr, i+1, target);
            track.removeLast();
            trackSum -= arr[i];
        }
    }
}
