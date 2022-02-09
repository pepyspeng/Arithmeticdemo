package j.com.lib.offer;

/**
 * @author : zhupp
 * @date : 2021/9/7
 * description : 在排序数组中查找数字
 * 统计一个数字在排序数组中出现的次数。
 */
public class offer_55_search {
    public static void main(String[] args) {
        int[] array = new int[]{1};
        System.out.println(search1(array, 1));
    }

    /**
     * @param array
     * @param target
     * @return
     */
    public static int search1(int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = getLeftIndex1(array, target);
        int right = getLeftIndex1(array, target+1);
        System.out.println(left + "--" + right);
        if (left == -1 || right == -1) {
            return 0;
        }
        return right - left ;
    }
    //设计一个查找左侧位置的算法
    public static int getLeftIndex1(int[] array,int target){
        int left = 0;
        int right = array.length -1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(array[mid] < target){
                //中间的数比目标的数 小，说明数在左边
                left = mid+1;
            }else if(array[mid]> target){
                right = mid -1;
            }else{
                //找左侧边界，往左继续挪
                right = mid - 1;
            }
        }
        if(left < 0 || left > array.length ){
            return -1;
        }
        return left;
    }


    public static int getRightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0  || nums[right] != target) {
            return -1;
        }
        return right;
    }

    /**
     * 寻找左侧边界，
     * nums = [2,3,5,7],target = 1 ，算法会返回 0，含义是：nums中小于 1 的元素有 0 个。
     * nums = [2,3,5,7], target = 8，算法会返回 4，含义是：nums中小于 8 的元素有 4 个。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int getLeftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            //如果相等，有可能当前这个不是最左边的，所以搜索右边边界，继续找。
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 如果target不再nums里，有两种情况，
        // 1是target大于所有的数，这里left就是length
        // 2是target小于所有的数，这里left是0，当nums[left] != target
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    /**
     * -----------------------------------------------------------------------------------
     *
     * @param array
     * @param target
     * @return
     */
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
            } else {
                left = mid + 1;
            }

        }
        return left;
    }


}


