package j.com.lib.offer;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class offer_66_constructArr {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        constructArr(array);
    }
    public static int[] constructArr(int[] a) {
        int length = a.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
