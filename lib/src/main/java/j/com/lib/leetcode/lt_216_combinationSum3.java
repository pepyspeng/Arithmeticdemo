package j.com.lib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * <p>
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 */
public class lt_216_combinationSum3 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,7,6,1,5};
        lt_216_combinationSum3 combine = new lt_216_combinationSum3();
        combine.combinationSum3(3, 9);
        combine.res.forEach(integers -> System.out.println(Arrays.toString(integers.toArray())));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtrack(arr, 0, k, n);
        return res;
    }

    public void backtrack(int[] arr, int start, int size, int target) {
        //得到了，就加入
        if (track.size() == size && trackSum == target) {
            res.add(new ArrayList<>(track));
        }

        for (int i = start; i < arr.length; i++) {
            track.addLast(arr[i]);
            trackSum += arr[i];
            backtrack(arr, i + 1, size, target);
            track.removeLast();
            trackSum -= arr[i];
        }
    }

}
