package j.com.lib.leetcode.top;

/**
 * 最长回文子串
 */
public class lt_top_5_longestPalindrome {
    public static void main(String[] args) {
        lt_top_5_longestPalindrome palindrome = new lt_top_5_longestPalindrome();
        System.out.println(palindrome.longestPalindrome("abcb"));
    }

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //回文是奇数的情况
            String s1 = palindrome(s, i, i);
            //回文是偶数的情况
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int left, int right) {
        while (
            //防止越界
                left >= 0 && right < s.length()
                        //相等
                        && s.charAt(left) == s.charAt(right)) {
            //从中间忘两边移动
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
