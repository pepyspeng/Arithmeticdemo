package j.com.lib.sort;

/**
 * @author : zhupp
 * @date : 2021/5/11
 * description : 归并排序
 */
public class mergeSort {

    public static void main(String[] args) {
        mergeSort mergeSort = new mergeSort();
        int[] a = new int[]{90, 3, 2, 67, 44, -9, 87, 65, 11, 9, 2, 8};
        int[] tempArray = new int[a.length];
        mergeSort.mergeSort(a, 0, a.length - 1, tempArray);
        for (int n : a) {
            System.out.print(" " + n);
        }
    }


    private void mergeSort(int[] array, int left, int right, int[] tempArray) {
        if (left < right) {
            int midIndex = (left + right) / 2;
            mergeSort(array, left, midIndex, tempArray);
            mergeSort(array, midIndex + 1, right, tempArray);
            mergeArray(array, left, midIndex, right, tempArray);
        }
    }


    private void mergeArray(int[] array, int left, int mid, int right, int[] tempArray) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = left;
        while (left <= mid && rightIndex <= right) {

        }


    }


//    public void mergeSort(int[] array, int left, int right,int[] tempArray) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//            mergeSort(array, left, mid,tempArray);
//            mergeSort(array, mid + 1, right,tempArray);
//            mergeArray(array, left, mid, right,tempArray);
////            merge(array, left, mid, right);
//        }
//    }
//
//    private void mergeArray(int[] array, int left, int mid, int right,int[] tempArray) {
//        int leftIndex = left;
//        int rightIndex = mid + 1;
//        int tempIndex = left;
//
//        while (leftIndex <= mid && rightIndex <= right) {
//            if (array[leftIndex] < array[rightIndex]) {
//                tempArray[tempIndex++] = array[leftIndex++];
//            } else {
//                tempArray[tempIndex++] = array[rightIndex++];
//            }
//        }
//        while (leftIndex <= mid) {
//            tempArray[tempIndex++] = array[leftIndex++];
//        }
//        while (rightIndex <= right) {
//            tempArray[tempIndex++] = array[rightIndex++];
//        }
//
//        while (left<=right){
//            array[left] = tempArray[left++];
//        }
//
//    }

    /**
     *
     * @param array 数组
     * @param left 假如两个数组，那么就是第一个数组的起始位置
     * @param mid 假如两个数组，那么就是第二个数组的起始位置
     * @param right
     */
    /*private void mergeArray(int[] array, int left, int mid, int right) {

        int[] tempArray = new int[array.length];
        //左边起始位置
        int leftSt = left;
        //右边的起始位置
        int rightSt = mid + 1;
        //结果数组的index
        int tmpIndex = left;

        while (leftSt <= mid && rightSt <= right) {
            if (array[leftSt] <= array[rightSt]) {
                tempArray[tmpIndex++] = array[leftSt++];
            } else {
                tempArray[tmpIndex++] = array[rightSt++];
            }
        }
        while (leftSt <= mid) {
            tempArray[tmpIndex++] = array[leftSt++];
        }
        while (rightSt <= right) {
            tempArray[tmpIndex++] = array[rightSt++];
        }
        while (left <= right) {
            array[left] = tempArray[left++];
        }

    }*/

}
