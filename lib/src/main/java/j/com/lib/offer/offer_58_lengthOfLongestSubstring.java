package j.com.lib.offer;

import java.util.HashMap;

/**
 * 最长不含重复字符的子字符串
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class offer_58_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        //是否有效，window 中是否有全部的 target
        int valid = 0;
        //记录最小子串的起始索引和长度
        int start = 0;
        int length = Integer.MAX_VALUE;
        while (right < s.length()) {
            //即将放入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //如果目标中有这个字符，窗口内数据要移动
            if (need.containsKey(c)) {
                //先把当前字符放入窗口
                window.put(c, window.getOrDefault(c, 0) + 1);
                //如果目标和窗口中都有这个字符。
                if (need.get(c).equals(window.get(c))) {
                    //那么字符有效。
                    valid++;
                }
            }

            System.out.printf("window:[%d,%d)%n", left, right);
            //判断左边窗口是否要收缩。
            while (valid == need.size()) {
                //在这更新最小覆盖子串
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                //d 是即将移除窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;
                //进行窗口数据的更新
                if (need.containsKey(d)) {
                    //如果目标和窗口中都有这个字符。
                    if (window.getOrDefault(d, 0).equals(need.getOrDefault(d, 0))) {
                        //那么字符有效。
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, length);
    }




    public int lengthOfLongestSubstring1(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        //划定当前窗口的坐标为(start,i],左开右闭,所以start的初始值为-1，而非0。
        int start = -1;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //当字符在map中已经存储时，需要判断其索引值index和当前窗口start的大小以确定是否需要对start进行更新:
            if (map.containsKey(c)) {
                //当index>start时，start更新为当前的index,否则保持不变。
                //注意若index作为新的start，计算当前滑动空间的长度时也是不计入的，左开右闭，右侧s[i]会计入，这样也是防止字符的重复计入。
                start = Math.max(map.getOrDefault(c, 0), start);
            }
            map.put(c, i);
            //i-start,为当前滑动空间(start,i]的长度，若其大于max，则需要进行更新。
            max = Math.max(max, i - start);
        }
        return max;


    }

    public int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = -1;
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
