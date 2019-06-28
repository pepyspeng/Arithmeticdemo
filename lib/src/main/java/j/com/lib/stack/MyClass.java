package j.com.lib.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class MyClass {


    public static void main(String[] args) {
        searchInsert(new int[]{1,3,5,6},7);
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        if(target>nums[right])
            return right+1;
        if(target<nums[0])
            return 0;
        while (left <= right) {
            mid = (left+right) / 2;
            if (nums[mid] < target) {
                left = mid+1;
            }else if(nums[mid] == target){
                return mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    /**
     * 二分法求公共前缀
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    /**
     * 回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return x == rev || x == rev / 10;
    }

    /**
     * 验证二叉树的前序序列化
     * @param preorder
     * @return
     */
    /*public static boolean isValidSerialization(String preorder) {
        if(preorder.equals("#")){
            return true;
        }
        String[] pres = preorder.split(",");
        for (String pre : pres){
            if(){}
        }

    }
*/

    /**
     * 二叉树的锯齿形层次遍历(即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行)
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Queue<TreeNode> queue = new LinkedList<>();//临时队列，用于存储临时数据

        boolean isLeftstart = true;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode root1 = stack.pop();
                list.add(root1.val);
                if (isLeftstart) {
                    //从左边开始
                    if (root1.left != null) {
                        queue.offer(root1.left);
                    }

                    if (root1.right != null) {
                        queue.offer(root1.right);
                    }

                } else {
                    //从右边开始
                    if (root1.right != null) {
                        queue.offer(root1.right);
                    }
                    if (root1.left != null) {
                        queue.offer(root1.left);
                    }
                }
            }
            //把队列的数据丢给栈
            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }

            isLeftstart = !isLeftstart;
            result.add(list);
        }
        return result;

    }

    /**
     * 简化路径
     *
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.equals("") || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }


    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    /**
     * 使括号有效的最少添加
     *
     * @param S "())"       "()))(("
     * @return 1              4
     */
    public static int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char cs = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(cs);
            } else {
                if (cs == '(') {
                    stack.push(cs);
                } else if (cs == ')') {
                    char top = stack.peek();
                    if (top == '(') {
                        stack.pop();
                    } else {
                        stack.push(cs);
                    }
                }
            }
        }
        return stack.size();
    }

    /**
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     *
     * @param ops ["5","2","C","D","+"]
     * @return 30
     * 第1轮：你可以得到5分。总和是：5。
     * 第2轮：你可以得到2分。总和是：7。
     * 操作1：第2轮的数据无效。总和是：5。
     * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
     * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
     */
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            switch (s) {
                case "C":
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    break;
                case "D":
                    if (!stack.empty()) {
                        stack.push(stack.peek() * 2);
                    }
                    break;
                case "+":
                    int last1 = stack.pop();
                    int last2 = stack.peek();
                    stack.push(last1);
                    stack.push(last1 + last2);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     * @param S "ab#c"
     * @param T "ad#c"
     * @return true
     * S 和 T 都会变成 “ac”。
     */
    public boolean backspaceCompare(String S, String T) {
        return backspaceCompare(S).equals(backspaceCompare(T));
    }

    public static String backspaceCompare(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        return stack.toString();
    }


    /**
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * @param nums1 [4,1,2]
     * @param nums2 [1,3,4,2]
     * @return [-1,3,-1]
     * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     */
    static public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums2 == null || nums2.length == 0) return new int[]{};//如果数组2为空，则返回一个空数组

        Map<Integer, Integer> map = new HashMap<>();// map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {

            //1. 栈不为空
            //2. 栈顶元素，小于当前的nums2的元素
            while (!stack.isEmpty() && stack.peek() < num)
                //peek（）方法的源码会发现只是把数组的最后一个元素（就是栈顶）返回来了，而没有做删除。

                //map.put(栈顶元素，num)
                //可能会生成很多个不同的key对应同一个value
                map.put(stack.pop(), num);//满足条件的生生map表
            stack.push(num);////把元素num压栈  不满足的情况就压栈
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {

            //判断map里面是否有nums1的key，没有值则赋value为-1，有则不改变，最终并返回value
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }


}

