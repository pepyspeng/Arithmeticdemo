package j.com.lib.offer;

/**
 * @author : zhupp
 * @date : 2021/8/25
 * description : 数组中的逆序对
 */
public class offer_45_InversePairs {

    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 6, 4};
        System.out.println(InversePairs(array));
    }

    public static int InversePairs(int[] array) {
        int length = array.length;
        if (length < 2) {
            return 0;
        }
        int[] temp = new int[length];
        return reversPairs(array, 0, length - 1, temp);
    }

    private static int reversPairs(int[] array, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftPairs = reversPairs(array, left, mid, temp);
        int rightPairs = reversPairs(array, mid + 1, right, temp);
        int crossPairs = mergeAndCount(array, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private static int mergeAndCount(int[] array, int left, int mid, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (leftIndex == mid + 1) {
                array[i] = temp[rightIndex++];
            } else if (rightIndex == right + 1) {
                array[i] = temp[leftIndex++];
            } else if (temp[i] <= temp[rightIndex]) {
                array[i] = temp[leftIndex++];
            } else {
                array[i] = temp[rightIndex++];
                count += (mid - left) + 1;
            }
        }
        return count;
    }
}
