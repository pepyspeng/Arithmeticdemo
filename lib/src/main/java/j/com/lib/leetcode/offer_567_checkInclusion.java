package j.com.lib.leetcode;

import java.util.HashMap;

/**
 * 字符串的排列
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class offer_567_checkInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab",
                "eidboaoo"));
    }

    /**
     * @param t
     * @param s
     * @return
     */
    public static boolean checkInclusion(String t, String s) {
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
            //判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                //如果总数满足了，那么就可以移动窗口的左移
                if (count == need.size()) {
                    return true;
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
        return false;
    }
}
