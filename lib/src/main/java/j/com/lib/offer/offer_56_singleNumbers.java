package j.com.lib.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 数组中数字出现的次数
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 */
public class offer_56_singleNumbers {

    public static void main(String[] args) {
        System.out.println(singleNumbers2(new int[]{9, 1, 7, 9, 7, 9, 7}));
    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     * @param nums
     * @return
     */
    public static int singleNumbers2(int[] nums) {
        int[] arr = new int[32];
        for (int num : nums) {
            //循环这个数字，可记录当前数字的各二进制位的 1 的出现次数。
            for (int i = 0; i < 32; i++) {
                //使用 与运算 ，可获取二进制数字 num 的最右一位 n
                //配合下面的右移，可得到 n1-n32位所有的值
                arr[i] = arr[i] + (num & 1);
                //无符号右移
                num >>>= 1;
            }
        }
        int res = 0;
        //实际上，只需要修改求余数值 m ，即可实现解决 除了一个数字以外，其余数字都出现 m 次 的通用问题。
        int m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            // 恢复第 i 位的值到 res
            res |= arr[31 - i] % m;
        }
        return res;
    }

    public int[] singleNumbers1(int[] nums) {
        //因为相同的数字异或为0，任何数字与0异或结果是其本身。
        //所以遍历异或整个数组最后得到的结果就是两个只出现一次的数字异或的结果：即 z = x ^ y
        int z = 0;
        for (int i : nums) z ^= i;
        //我们根据异或的性质可以知道：z中至少有一位是1，否则x与y就是相等的。
        //我们通过一个辅助变量m来保存z中哪一位为1.（可能有多个位都为1，我们找到最低位的1即可）。
        //举个例子：z = 10 ^ 2 = 1010 ^ 0010 = 1000,第四位为1.
        //我们将m初始化为1，如果（z & m）的结果等于0说明z的最低为是0
        //我们每次将m左移一位然后跟z做与操作，直到结果不为0.
        //此时m应该等于1000，同z一样，第四位为1.
        int m = 1;
        while ((z & m) == 0) m <<= 1;
        //我们遍历数组，将每个数跟m进行与操作，结果为0的作为一组，结果不为0的作为一组
        //例如对于数组：[1,2,10,4,1,4,3,3]，我们把每个数字跟1000做与操作，可以分为下面两组：
        //nums1存放结果为0的: [1, 2, 4, 1, 4, 3, 3]
        //nums2存放结果不为0的: [10] (碰巧nums2中只有一个10，如果原数组中的数字再大一些就不会这样了)
        //此时我们发现问题已经退化为数组中有一个数字只出现了一次
        //分别对nums1和nums2遍历异或就能得到我们预期的x和y
        int x = 0, y = 0;
        for (int i : nums) {
            //这里我们是通过if...else将nums分为了两组，一边遍历一遍异或。
            //跟我们创建俩数组nums1和nums2原理是一样的。
            if ((i & m) == 0) x ^= i;
            else y ^= i;
        }
        return new int[]{x, y};
    }


    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        map.forEach((key, value) -> {
            list.add(key);
        });
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
