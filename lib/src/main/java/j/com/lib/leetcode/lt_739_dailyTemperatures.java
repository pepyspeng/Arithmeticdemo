package j.com.lib.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 */
public class lt_739_dailyTemperatures {

    public static void main(String[] args) {
        lt_739_dailyTemperatures temperatures = new lt_739_dailyTemperatures();
        int[] arr = new int[]{2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(temperatures.nextGreaterElement(arr)));

        int[] arr1 = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(temperatures.dailyTemperatures(arr1)));
    }

    /**
     * * 每日温度
     * * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
     * * 其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
     * * <p>
     * * <p>
     * * 示例 1:
     * * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * * 输出: [1,1,4,2,1,1,0,0]
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        //这个问题其实还是找 next greater number, 只不过要找到 当前距离下一个的距离
        // 这个时候 栈里面存着的就不能是下一个最大数了。而是存最大的索引了。
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            // 得到索引间距
            res[i] = stack.isEmpty() ? -1 : (stack.peek() - i);
            // 将索引入栈，而不是元素
            stack.push(i);
        }
        return res;
    }

    /**
     * 给你一个数组 nums，请你返回一个等长的结果数组，
     * 结果数组中 对应索引 存储着下一个更大元素，如果没有更大的元素，就存 -1。
     * 比如说，输入一个数组
     * nums = [2,1,2,4,3]，
     * 你返回数组 [4,2,4,-1,-1]。
     * <p>
     * 这个问题可以换个思路考虑，把数组的元素想象成并列站立的人，元素大小想象成人的身高。
     * 这些人面对你站成一列，如何求元素「2」的 Next Greater Number 呢？
     * 如果能够看到元素「2」，那么他后面可见的第一个人就是「2」的 Next Greater Number，
     * 因为比「2」小的元素身高不够，都被「2」挡住了，第一个露出来的就是答案。
     *
     * @param arr
     * @return
     */
    public int[] nextGreaterElement(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        //可以从后往前走，借助的是栈的结构，倒着往栈里放，其实是正着出栈。
        for (int i = arr.length - 1; i >= 0; i--) {
            //判断个子的高矮
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                //如果栈内存着的，比当前值小，其实可以丢弃，因为往后也看不见他
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return res;
    }
}
