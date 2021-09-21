package j.com.lib.offer;

import java.util.HashMap;

/**
 * 最长不含重复字符的子字符串
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class offer_58_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int left = map.getOrDefault(c, -1);
            map.put(c, i);
            // dp[j - 1] -> dp[j]
            temp = temp < i - left ? temp + 1 : i - left;
            result = Math.max(temp, result);

        }
        return result;
    }
}
