package j.com.lib.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import j.com.lib.bean.TreeNode;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class offer2_3_findRepeatNumber {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,4,4,4,4,7};
        System.out.println(search(array,4));
    }

    public static int search(int[] array, int target) {
        int left = binarySearch(array, target, true);
        int right = binarySearch(array, target, false) - 1;
        if (left <= right && right < array.length
                && array[left] == target && array[right] == target) {
            return right - left + 1;
        }
        return 0;
    }

    public static int binarySearch(int[] array, int target, boolean isLow) {
        int left = 0;
        int right = array.length - 1;
        int result = array.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target || (isLow && array[mid] >= target)) {
                right = mid - 1;
//                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    static HashMap<Integer, Integer> map = new HashMap<>();
    static int result = -1;

    public static int findRepeatNumber(int[] nums) {
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        map.forEach((key, value) -> {
            System.out.println("key:" + key + "----value:" + value);
            if (value > 1) {
                result = key;
            }
        });
        return result;
    }


    public static int findRepeatNumber1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (num == i) {
                //说明num在正确的位置上
                continue;
            }
            if (array[num] == num) {
                //说明当前位置已经有这个数字。
                return num;
            }
            //下标循环移位，将num放到自己所在的位置上。
            int position = num;
            while (array[position] != position) {
                int temp = array[position];
                array[position] = position;
                position = temp;
            }
        }
        return 0;
    }

    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
        int[] reuslt1 = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            reuslt1[i] = result.get(i);
        }
        return reuslt1;
    }
}
