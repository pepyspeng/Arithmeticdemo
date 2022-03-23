package j.com.lib.leetcode;


/**
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * <p>
 *
 * @see lt_55_canJump
 */
public class lt_45_jump {

    public int jump(int[] nums) {
        //n
        int n = nums.length;
        //记录当前可跳跃最大长度
        int max = 0;
        //记录跳跃次数
        int jump = 0;
        //记录每一次跳跃中的最优选
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            //得到本次可跳跃最大距离
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                //说明已经到了最优选了,那么就标记下一次可跳跃距离
                end = max;
                //跳一次
                jump++;
            }
        }
        return jump;
    }
}
