package j.com.lib.leetcode;


import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 */
public class lt_503_nextGreaterElements {

    /**
     * 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），
     * 返回nums中每个元素的 下一个更大元素 。
     * <p>
     * 传统方法1：可以直接将数组直接扩容两倍。
     * 技巧解法：可以假装扩容，利用 数组的长度取模 来假装扩容
     */
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        //可以从后往前走，借助的是栈的结构，倒着往栈里放，其实是正着出栈。
        for (int i = 2 * n - 1; i >= 0; i--) {
            int temp = i % n;
            //判断个子的高矮
            while (!stack.isEmpty() && stack.peek() <= arr[temp]) {
                //如果栈内存着的，比当前值小，其实可以丢弃，因为往后也看不见他
                stack.pop();
            }
            res[temp] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[temp]);
        }
        return res;
    }
}
