package j.com.lib.offer;


import java.util.ArrayList;

/**
 * @author : zhupp
 * @date : 2021/9/4
 * description : 连续证书和为
 */
public class offer_51_FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(9));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (target < 3) {
            return result;
        }
        int left = 1;
        int right = 2;
        while (right > left) {
            int count = (left + right) * (right - left + 1) / 2;
            if (target == count) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    temp.add(i);
                }
                result.add(temp);
                right++;
            } else if (target > count) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }

}
