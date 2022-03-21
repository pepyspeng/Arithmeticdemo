package j.com.lib.leetcode;

import java.util.HashMap;
import java.util.Stack;


/**
 * 496. 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素
 * <p>
 * <p>
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 */
public class lt_496_nextGreaterElement {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = nextGreaterElement1(nums2);
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public HashMap<Integer, Integer> nextGreaterElement1(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        //可以从后往前走，借助的是栈的结构，倒着往栈里放，其实是正着出栈。
        for (int i = arr.length - 1; i >= 0; i--) {
            //判断个子的高矮
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                //如果栈内存着的，比当前值小，其实可以丢弃，因为往后也看不见他
                stack.pop();

            }
            map.put(arr[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr[i]);
        }
        return map;
    }
}
