package j.com.lib.offer;

import java.util.Arrays;

public class Offer_39_Topk {
    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 3, 7, 2, 8, 5, 4, 9};
        Offer_39_Topk topK = new Offer_39_Topk();
        System.out.println(Arrays.toString(topK.getLeastNumbers(array, 4)));
        System.out.println(Arrays.toString(topK.getTopK(array, 7)));

    }

    public int[] getTopK(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch1(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch1(int[] arr, int left, int right, int k) {
        //快排一次，找到排序后下表为 index 的元素，如果index等于k就返回index以及index左边所有的数
        int index = partition1(arr, left, right);
        if (index == k) {
            return Arrays.copyOf(arr, index + 1);
        }
        //否则根据下标index与k的关系来决定 继续切分 左端还是右端
        return index > k ? quickSearch1(arr, left, index - 1, k) : quickSearch1(arr, index + 1, right, k);
    }

    private int partition1(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }


}
