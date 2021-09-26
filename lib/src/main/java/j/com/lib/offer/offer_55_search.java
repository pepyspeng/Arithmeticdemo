package j.com.lib.offer;

/**
 * @author     : zhupp
 * @date       : 2021/9/7
 * description : 在排序数组中查找数字
 * 统计一个数字在排序数组中出现的次数。
 */
public class offer_55_search {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,4,4,4,4,7};
        System.out.println(search(array,4));
    }

    public static int search(int[] array, int target) {
        int left = binarySearch(array, target, true);
        int right = binarySearch(array, target, false) - 1;
        if (left <= right && right < array.length
                && array[left] == target && array[right] == target) {
            return right - left + 1;
        }
        return 0;
    }

    public static int binarySearch(int[] array, int target, boolean isLeft) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target || (isLeft && array[mid] >= target)) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }

        }
        return left;
    }


}


