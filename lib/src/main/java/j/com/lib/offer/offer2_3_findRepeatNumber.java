package j.com.lib.offer;

import java.util.HashMap;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class offer2_3_findRepeatNumber {

    public static void main(String[] args) {
        int[] array =new int[]{1, 1, 1};
        System.out.println(findRepeatNumber(array));
    }

    static HashMap<Integer,Integer> map = new HashMap<>();
    static int result = -1;
    public static int findRepeatNumber(int[] nums) {
        for (int i :nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        map.forEach((key, value) -> {
            System.out.println("key:"+key+"----value:"+value);
            if(value>1){
                result = key;
            }
        });
        return result;
    }


}
