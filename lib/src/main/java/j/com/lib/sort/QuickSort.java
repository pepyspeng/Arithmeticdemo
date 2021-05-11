package j.com.lib.sort;

public class QuickSort {


    public static void main(String[] args) {

        QuickSort quickSort = new QuickSort();
        int[] a = {19, 23, 4, 58, 13, 54, 90, 2, 1, -5, 6, 33, 85};
        quickSort.quickSort(a, 0, a.length - 1);
        for (int num : a) {
            System.out.println(" " + num);
        }
    }

    private void quickSort(int[] array, int left, int right) {
        if(left<right){
            int mid=getIndex(array,left,right);
            quickSort(array,left,mid-1);
            quickSort(array,mid+1,right);
        }
    }


    private int getIndex(int[] array, int left, int right) {
        int result = array[left];
        while (left < right) {
            while (left < right && array[right] >= result) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= result) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = result;
        return left;
    }


//    private void quickSort(int[] a, int left, int right) {
//        if (left < right) {
//            int index = getIndex(a, left, right);
//            quickSort(a, left, index - 1);
//            quickSort(a, index + 1, right);
//        }
//    }
//
//    private int getIndex(int[] a, int left, int right) {
//        int result = a[left];
//        while (left < right) {
//            while (left < right && a[right] >= result) {
//                right--;
//            }
//            a[left] = a[right];
//            while (left < right && a[left] <= result) {
//                left++;
//            }
//            a[right] = a[left];
//        }
//        a[left] = result;
//        return left;
//
//    }

    /*
     *//**
     * 快速排序
     *
     * @param a
     *//*
    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quickSort(a, low, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    *//**
     * 获取中间下标
     *
     * @param a
     * @param low
     * @param high
     * @return
     *//*
    private int getMiddle(int[] a, int low, int high) {
        int temp = a[high];//基准元素
        while (low < high) {
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];

        }
        a[low] = temp;//插入到排序后正确的位置
        return low;
    }*/
}
