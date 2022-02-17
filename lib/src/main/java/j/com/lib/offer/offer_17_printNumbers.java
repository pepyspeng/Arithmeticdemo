package j.com.lib.offer;

import java.util.Arrays;

/**
 * @author : zhupp
 * @date : 2022/2/16
 * description : 打印从1到最大的n位数
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class offer_17_printNumbers {


    public static void main(String[] args) {
        offer_17_printNumbers numbers = new offer_17_printNumbers();
        System.out.println(Arrays.toString(numbers.printNumbers(2)));
    }

    StringBuilder res = new StringBuilder();
    //一共几位
    int n = 0;
    //组成的数字
    char[] num;
    int[] nums;
    //num的index
    int count = 0;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 递归生成全排列
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        this.n = n;
        num = new char[n];
        nums = new int[(int) (Math.pow(10, n) - 1)];
        for (int i = 1; i <= n; i++) {
            dfs(0, i);
        }
        String str = res.deleteCharAt(res.length() - 1).toString();
        System.out.println(str);
        return nums;
    }

    public void dfs(int index, int x) {
        if (index == x) {
            //说明已经到最后一位了，将生成的数字放到队尾，可以直接返回
            int curNum = Integer.parseInt(String.valueOf(num).trim());
            if (curNum != 0) nums[count++] = curNum;
            res.append(curNum).append(",");
            return;
        }
        int start = 0;
        if (index == 0) {
            //1.当num的下标index是0时，则loop从下标1开始进行全排列
            start = 1;
        } else {
            //x非0时，则loop从下标0开始进行全排列
            start = 0;
        }
        int length = loop.length;
        for (int i = start; i < length; i++) {
            num[index] = loop[i];
            dfs(index + 1, x);
        }
    }
}
