package j.com.lib.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找到字符串中所有字母异位词
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class lt_438_findAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("baa"
                , "aa"));
    }

    public static List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int n = s.length();
        int tLength = t.length();
        List<Integer> result = new ArrayList<>();
        while (right < n) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                //如果目标需要，更新窗口数据
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果目标和滑动窗口都有
                if (window.getOrDefault(c, 0).equals(need.getOrDefault(c, 0))) {
                    count++;
                }
            }
            //是否需要更新窗口左侧
            while (right - left >= tLength) {
                if (count == need.size()) {
                    //符合条件
                    result.add(left);

                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.getOrDefault(d, 0).equals(need.getOrDefault(d, 0))) {
                        count--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return result;

    }
}
