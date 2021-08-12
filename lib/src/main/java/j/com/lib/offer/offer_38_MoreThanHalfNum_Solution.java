package j.com.lib.offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntPredicate;

import j.com.lib.sort.BinaryInsertSort;
import j.com.lib.sort.MergeSort;
import j.com.lib.sort.QuickSort;

public class offer_38_MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        int[] array  =new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println( MoreThanHalfNum_Solution(array));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        BinaryInsertSort.sort(array);
        int mid = array[array.length / 2];
        long count =Arrays.stream(array).filter(i -> (i == mid)).count();
        return count>array.length/2 ? mid:-1;
    }
}
