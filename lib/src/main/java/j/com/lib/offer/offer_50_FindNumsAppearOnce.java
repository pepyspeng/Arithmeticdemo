package j.com.lib.offer;

import java.util.HashMap;

/**
 * JZ40 数组中只出现一次的两个数字
 */
public class offer_50_FindNumsAppearOnce {

    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(firstUniqChar(str));
    }

    //第一个只出现一次的字符
    public static char firstUniqChar(String s) {
//        HashMap<Character, Boolean> dic = new HashMap<>();
//        char[] sc = s.toCharArray();
//        for (char c : sc)
//            //如果有，放入false,没有放入true
//            dic.put(c, !dic.containsKey(c));
//        for (char c : sc)
//            if (dic.get(c)) return c;
//        return ' ';

        HashMap<Character, Boolean> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, !map.containsKey(c));
        }

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }


    public int[] FindNumsAppearOnce(int[] array) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }
        int i = 0;
        for (Integer num : map.keySet()) {
            result[i++] = num;
        }
        return result;
    }
}
