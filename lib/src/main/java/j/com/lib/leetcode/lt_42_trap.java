package j.com.lib.leetcode;

/**
 * 接雨水
 */
public class lt_42_trap {


    public static void main(String[] args) {
        lt_42_trap trap = new lt_42_trap();
        System.out.println(trap.trapDp(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 暴力解法，
     * 只计算当前格子所能承受的最大雨水量，也就是  min(l_max,r_max)-height(i)
     * 时间复杂度 O(N^2)，空间复杂度 O(1)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        //起始和结尾起始没有意义，都是0
        for (int i = 1; i < height.length - 1; i++) {
            int l_max = 0;
            int r_max = 0;
            //计算左边的最大值,注意右边界，是否要包括i,
            //要包括 i 自己，答案看计算的地方
            for (int j = 0; j <= i; j++) {
                l_max = Math.max(l_max, height[j]);
            }
            //计算右边的最大值,注意右边界，要包含最后一个
            for (int l = i; l < height.length; l++) {
                r_max = Math.max(r_max, height[l]);
            }
            //上面的边界必须包括自己，因为如果自己是最高的，那么当前位置的雨水应该是0
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }

    /**
     * 上面是暴力解法，如果要优化的话，可以把l_max 和 r_max 记录下来
     * l_max[i] 表示位置 i 左边最高的柱子高度，r_max[i] 表示位置 i 右边最高的柱子高度。预先把这两个数组计算好，避免重复计算：
     * 优化其实和暴力解法思路差不多，就是避免了重复计算，把时间复杂度降低为 O(N)，已经是最优了，但是空间复杂度是 O(N)。
     *
     * @param height
     * @return
     */
    public int trapDp(int[] height) {
        int res = 0;
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        l_max[0] = height[0];
        r_max[height.length - 1] = height[height.length - 1];
        //注意，计算左边的应该是从左往右算
        for (int i = 1; i < height.length; i++) {
            //先循环，计算一遍左边的各个位置最大值
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        //注意，计算右边的应该是 从右往左算
        for (int i = height.length - 2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        //最后计算答案
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    /**
     * 解法和备忘录是一致的，我们这次也不要用备忘录提前计算了，而是用双指针边走边算，节省下空间复杂度。
     *
     * @param height
     * @return
     */
    public int trapDouble(int[] height) {
        int n = height.length;
        //左右指针
        int left = 0;
        int right = n - 1;
        //表示 0->left 之间 柱子最大值
        int l_max = 0;
        //表示 right->n 之间 柱子的最大值
        int r_max = 0;
        int res = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            //// res += min(l_max, r_max) - height[i]
            //其实还是找到最小值
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;

    }


}
