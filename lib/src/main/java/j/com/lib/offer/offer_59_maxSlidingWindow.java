package j.com.lib.offer;

import java.util.Arrays;
import java.util.LinkedList;

public class offer_59_maxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * @param nums
     * @param k
     * @return 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * <p>
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        MonotonicQueue deque = new MonotonicQueue();
        //还没有形成窗口时
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //还没有形成窗口
                deque.push(nums[i]);
            } else {
                //形成窗口了。
                //先加入元素
                deque.push(nums[i]);
                res[index++] = deque.getMax();
                deque.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    static class MonotonicQueue {
        //单调队列，尾巴是最大的，
        LinkedList<Integer> deque = new LinkedList<>();


        void push(int n) {
            while (!deque.isEmpty() && deque.peekLast() < n) {
                deque.pollLast();
            }
            deque.addLast(n);
        }

        int getMax() {
            //队头的元素是最大的
            return deque.getFirst();
        }

        public void pop(int n) {
            //要移除队头的
            //只有当队头的和要滑出窗口的一样大时，才会移除。
            if (n == deque.getFirst()) {
                deque.pollFirst();
            }
        }
    }
}
