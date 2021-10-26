package j.com.lib.offer;

import java.util.Arrays;
import java.util.Comparator;

public class offer_45_minNumber {

    public String minNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] + "";
        }
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

}
