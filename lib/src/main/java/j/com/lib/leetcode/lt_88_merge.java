package j.com.lib.leetcode;

import java.util.Arrays;

public class lt_88_merge {
    public static void main(String[] args) {
        lt_88_merge merge = new lt_88_merge();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0) {
            return;
        }
        if (n2 == 0) {
            return;
        }
        int[] res = new int[m + n];
        int resIndex = 0;
        int n1Index = 0;
        int n2Index = 0;
        while (n1Index < m && n2Index < n) {
            while (n1Index < m && nums1[n1Index] <= nums2[n2Index]) {
                res[resIndex++] = nums1[n1Index++];
            }
            while (n2Index < n && nums1[n1Index] >= nums2[n2Index]) {
                res[resIndex++] = nums2[n2Index++];
            }
        }
        while (n1Index < m) {
            res[resIndex++] = nums1[n1Index++];
        }
        while (n2Index < n) {
            res[resIndex++] = nums2[n2Index++];
        }
        for (int i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }
}
