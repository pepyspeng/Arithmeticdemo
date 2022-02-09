package j.com.lib.offer;

import java.util.Arrays;

public class offer_42_PrintMinNumber {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }

    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] nums = new String[n];
        //先将整数类型转字符串数组
        for (int i = 0; i < n; i++) {
            nums[i] = numbers[i] + "";
        }
        //用定义好的排序规则排序
        //若 x + y > y + x, 则表明 x “大于” y，sort默认升序排序，因此x 和 y 交换位置，实现排序
        Arrays.sort(nums, (s1, s2) -> {
            int x = (s1 + s2).compareTo(s2 + s1);
            System.out.println(x);
            return x;
        });
        StringBuilder sb = new StringBuilder();
        for (String s:nums){
            sb.append(s);
        }
        return sb.toString();
    }
}
