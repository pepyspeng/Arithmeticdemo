package j.com.lib.offer;

/**
 * @author : zhupp
 * @date : 2021/8/25
 * description : 数组中的逆序对
 */
public class offer_45_InversePairs {

    public static void main(String[] args) {
        int[] array = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(reversePairs(array));
    }
    public static int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

//    public static int InversePairs(int[] array) {
//        int length = array.length;
//        if (length < 2) {
//            return 0;
//        }
//        int[] temp = new int[length];
//        for (int i = 0; i < length; i++) {
//            temp[i] = array[i];
//        }
//        return reversPairs(array, 0, length - 1, temp);
//    }
//
//    private static int reversPairs(int[] array, int left, int right, int[] temp) {
//        if (left >= right) {
//            return 0;
//        }
//        int mid = left + (right - left) / 2;
//        int leftPairs = reversPairs(array, left, mid, temp);
//        int rightPairs = reversPairs(array, mid + 1, right, temp);
//        //如果数组已经有序，就不需要合并了。
//        if (array[mid] <= array[mid + 1]) {
//            return leftPairs + rightPairs;
//        }
//        int crossPairs = mergeAndCount(array, left, mid, right, temp);
//        return leftPairs + rightPairs + crossPairs;
//    }
//
//    private static int mergeAndCount(int[] array, int left, int mid, int right, int[] temp) {
//        if (left >= right) {
//            return 0;
//        }
//        for (int i = left; i <= right; i++) {
//            temp[i] = array[i];
//        }
//        int leftIndex = left;
//        int rightIndex = mid + 1;
//        int count = 0;
//        for (int i = left; i <= right; i++) {
//            if (leftIndex == mid + 1) {
//                array[i] = temp[rightIndex++];
//            } else if (rightIndex == right + 1) {
//                array[i] = temp[leftIndex++];
//            } else if (temp[i] <= temp[rightIndex]) {
//                array[i] = temp[leftIndex++];
//            } else {
//                array[i] = temp[rightIndex++];
//                count += (mid - i + 1);
//            }
//        }
//        return count;
//    }
}
