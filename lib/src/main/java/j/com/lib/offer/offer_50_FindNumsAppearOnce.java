package j.com.lib.offer;

import java.util.HashMap;

/**
 * JZ40 数组中只出现一次的两个数字
 */
public class offer_50_FindNumsAppearOnce {

    public static void main(String[] args) {

    }
    public int[] FindNumsAppearOnce (int[] array) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:array){
            if(map.containsKey(i)){
                map.remove(i);
            }else{
                map.put(i,1);
            }
        }
        int i = 0;
        for (Integer num: map.keySet()){
            result[i++] = num;
        }
        return result;
    }
}
