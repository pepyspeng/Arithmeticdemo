package j.com.lib.offer;

/**
 * JZ37 数字在升序数组中出现的次数
 */
public class offer_47_GetNumberOfK {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,5,6};
        System.out.println(GetNumberOfK(array,3));
    }

    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = binarySearch(array, k);
        int right = binarySearch(array, k + 1);
        if (left == array.length || array[left] != k) {
            return 0;
        } else {
            return right - left;
        }
    }

    public static int binarySearch(int[] array, int k) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid+1;
            } else{
                right = mid-1 ;
            }
        }
        return left;
    }
}
