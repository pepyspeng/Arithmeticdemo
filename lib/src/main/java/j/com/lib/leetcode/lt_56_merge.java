package j.com.lib.leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class lt_56_merge {

    public static void main(String[] args) {
        lt_56_merge merge = new lt_56_merge();
        int[][] res = merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    /**
     * 可以按照[start,end]中start进行排序，这样对于区间 x.start是固定的。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        //按照起始位置排序。
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //得到当前的数组
            int[] cur = intervals[i];
            //res中最后一个
            int[] last = res.getLast();
            if (cur[0] <= last[1]) {
                //说明有交集,取大的
                last[1] = Math.max(cur[1], last[1]);
            } else {
                //没有交集，就把当前的入队，再处理下一个，
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);
    }
}
