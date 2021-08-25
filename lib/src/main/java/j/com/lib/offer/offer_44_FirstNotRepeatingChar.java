package j.com.lib.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhupp
 * @date : 2021/8/25
 * description :  第一个只出现一次的字符
 */
public class offer_44_FirstNotRepeatingChar {

    public static void main(String[] args) {
        System.out.println((FirstNotRepeatingChar("google")));
    }

    public static int FirstNotRepeatingChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for (int i =0;i<s.toCharArray().length;i++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}
