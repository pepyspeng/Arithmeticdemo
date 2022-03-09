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
        System.out.println(findContinuousSequence1(9));
    }


    public static int[][] findContinuousSequence1(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        int sum = 3;
        while (left < right) {
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
                sum -= left;
                left++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<int[]>();
        int left = 0;
        int right = 1;
        int count = 1;
        while (left < right) {
            if (count == target) {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                result.add(temp);

            }
            //相等的时候也要移除右边界， 否则会死循环
            if (count >= target) {
                count -= left;
                left++;
            } else if (count < target) {
                right++;
                count += right;

            }
        }

        return result.toArray(new int[0][]);
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
                    ans[i - left] = i;
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
