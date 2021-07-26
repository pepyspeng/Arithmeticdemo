package j.com.lib.offer;

public class offer_6_roteMin {

    public int minNumberInRotateArray(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] < array[right]) {
                //说明左边到右边是递增的。
                return array[left];
            }
            int mid = (left + right) >> 1;
            if (array[mid] > array[right]) {
                //说明右半去飞递增，因为已知最小值，所以可以直接过array[mid]
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                //右半区递增，直接舍弃右半区
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
