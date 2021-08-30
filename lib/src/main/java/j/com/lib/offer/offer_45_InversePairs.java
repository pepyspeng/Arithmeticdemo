package j.com.lib.offer;

/**
 * @author : zhupp
 * @date : 2021/8/25
 * description : 数组中的逆序对
 */
public class offer_45_InversePairs {

    public static void main(String[] args) {
        int[] array = new int[]{
                627126,415347,850134,371085,279048,705820,453064,944751,92317,58592,167988,284065,992573,78043,190215,104546,607528,391775,701214,849731,231053,603058,975374,199773,479544,143961,206797,325662,90035,69615,429916,717161,484962,796403,604598,280362,502223,57662,741466,594540,632606,909454,394957,625180,503849,585172,729726,627729,976947,947293,477461,724352,66703,452835,440478,62599,596797,163627,388261,203184,233243,334529,436697,234557,647284,41295,514920,665859,615310,256386,776752,247916,682192,171709,389448,186041,273234,635527,813771,766533,582820,807584,490886,649523,260419,447716,228474,373568,611343,616735,576752,844586,467616,529801,595496,631253,571097,110416,297112,186407,883154,73864,950675,81698,245574,340124,267739,35160,975651,597862,801693,74823,921798,292579,240698,182218,256647,469172,72138,867991,602259,165243,228929,69875,695044,824425,701128,782493,451193,998241,485252,334347,588457,435928,416045,350383,292404,200137,385543,268055,314351,187237,859230,236150,996168,99928,934720,252816,569100,523210,120807,171359,688453,866088,757586,383498,206866,458715,682343,658059,973308,167596,508759,78117,603524,441156,428501,412280,157645,814044,196687,471997,1281,55917,224499,997450,155845,159219,250266,241297,682429,887425,412656,887235,269865,686594,787085,476731,661661,469428,134791,634969,637024,643550,229439,756900,601058,657940,169180,758704,471984,365867,230701,473266,421784,455200,470716,93981,130771,237334,335278,329552,641111,264286,733139,910976,950881,520224,904060,612542,989653,38851,763864,143029,198753,993303,899930,799811,651243,585462,558515,639579,951330,305568,112845,889466,277120,99913,499800,924243,853599,835078,770148,11062,615717,503287,922039,82950,23512,826099,695492,529517,381302,975708,672546,96407,485363,88828,896218,652958,674291,971086,292538,141973,276654,921735,547791,70127,21649,47591,994370,391600,399022,764518,402663,14739,267806,841054,97689,807670,183505,309533,337187,564807,801594,9733,661214,803309,614914,73784,45626
        };
         System.out.println(InversePairs(array));
    }
//    public static int reversePairs(int[] nums) {
//        int len = nums.length;
//
//        if (len < 2) {
//            return 0;
//        }
//
//        int[] copy = new int[len];
//        for (int i = 0; i < len; i++) {
//            copy[i] = nums[i];
//        }
//
//        int[] temp = new int[len];
//        return reversePairs(copy, 0, len - 1, temp);
//    }
//
//    private static int reversePairs(int[] nums, int left, int right, int[] temp) {
//        if (left == right) {
//            return 0;
//        }
//
//        int mid = left + (right - left) / 2;
//        int leftPairs = reversePairs(nums, left, mid, temp);
//        int rightPairs = reversePairs(nums, mid + 1, right, temp);
//
//        if (nums[mid] <= nums[mid + 1]) {
//            return leftPairs + rightPairs;
//        }
//
//        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
//        return leftPairs + rightPairs + crossPairs;
//    }
//
   /* private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
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
    }*/
    public static int InversePairs(int[] array) {
        int length = array.length;
        if (length < 2) {
            return 0;
        }
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = array[i];
        }
        return reversPairs(array, 0, length - 1, temp);
    }

    private static int reversPairs(int[] array, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversPairs(array, left, mid, temp);
        int rightPairs = reversPairs(array, mid + 1, right, temp);
        //如果数组已经有序，就不需要合并了。
        if (array[mid] <= array[mid + 1]) {
            return leftPairs + rightPairs;
        }
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
            } else if (temp[leftIndex] <= temp[rightIndex]) {
                array[i] = temp[leftIndex++];
            } else {
                array[i] = temp[rightIndex++];
                count += (mid - leftIndex + 1);
            }
        }
        return count;
    }
}
