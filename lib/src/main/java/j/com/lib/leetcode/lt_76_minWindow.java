package j.com.lib.leetcode;

import java.util.HashMap;


/**
 * 最小覆盖子串,给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 */
public class lt_76_minWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String  minWindow(String s, String t) {
        //首先声明 窗口map 和 目标 map
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            //把目标值全部放入
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        //窗口中是否全部满足need。
        int count = 0;
        int n = s.length();

        int starIndex = 0;
        int length = Integer.MAX_VALUE;

        while (right < n) {
            //需要放入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //如果目标里中有这个字符，那就要更新滑动窗口
            if (need.containsKey(c)) {
                //放入滑动窗口
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果滑动窗口和目标中都有这个数，更新一下满足条件的数量。
                if (need.get(c).equals(window.get(c))) {
                    count++;
                }
            } else {
                //不满足，就继续右移窗口
            }
            System.out.printf("window:[%d,%d)", left, right);
            //如果总数满足了，那么就可以移动窗口的左移
            while (count == need.size()) {
                //更新最小子串
                if (right - left < length) {
                    starIndex = left;
                    length = right - left;
                }

                //即将删除的字符
                char d = s.charAt(left);
                //窗口左移
                left++;
                //如果移除的字符在目标内，就要更新窗口值了
                if (need.containsKey(d)) {
                    //如果滑动窗口和目标中都有这个数，更新一下满足条件的数量。
                    if (need.get(d).equals(window.get(d))) {
                        count--;
                    }
                    //更新窗口内数据
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }

        }
        return length == Integer.MAX_VALUE ? "" : s.substring(starIndex, starIndex + length);
    }
}
