package j.com.lib.sort;

public class mergeSort {

    public static void main(String[] args) {
        mergeSort mergeSort = new mergeSort();
        int[] a = new int[]{90, 3, 2, 67, 44, -9, 87, 65, 11, 9, 2, 8};
        mergeSort.mergeSort(a, 0, a.length - 1);
        for (int n : a) {
            System.out.print(" " + n);
        }
    }

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            mergeArray(array, left, mid, right);
//            merge(array, left, mid, right);
        }
    }

    private void mergeArray(int[] array, int left, int mid, int right) {
        int[] tempArray = new int[array.length];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int temoIndex = left;

        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                tempArray[temoIndex++] = array[leftIndex++];
            } else {
                tempArray[temoIndex++] = array[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            tempArray[temoIndex++] = array[leftIndex++];
        }
        while (rightIndex <= right) {
            tempArray[temoIndex++] = array[rightIndex++];
        }

        while (left<=right){
            array[left] = tempArray[left++];
        }

    }

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
