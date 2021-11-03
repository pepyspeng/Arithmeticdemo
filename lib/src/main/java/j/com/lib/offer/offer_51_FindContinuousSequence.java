package j.com.lib.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhupp
 * @date : 2021/9/4
 * description : 连续证书和为
 */
public class offer_51_FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence1(9));
    }
    public static int[][] FindContinuousSequence1(int target) {
        List<int[]> result = new ArrayList<>();
//        if (target < 3) {
//            return result;
//        }
        int left = 1;
        int right = 2;
        while (right > left) {
            //连续证书求和公式 1-9 =(1+9)*个数/2 =  (首+尾)*(尾-首+1)/2
            int count = (left + right) * (right - left + 1) / 2;
            if (target == count) {
                int[] ans = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    ans[i-left] = i;
                }
                result.add(ans);
                left++;
            } else if (target > count) {
                right++;
            } else {
                left++;
            }
        }
        return result.toArray(new int[0][]);
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
