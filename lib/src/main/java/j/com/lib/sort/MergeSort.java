package j.com.lib.sort;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] tempArray = new int[a.length];
        mergeSort.mergeSort(a, 0, a.length - 1, tempArray);
        for (int n : a) {
            System.out.print(" " + n);
        }
    }

    public void mergeArray1(int[] array, int left, int right, int mid, int[] tempArray) {
        int tempIndex = left;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] > array[rightIndex]) {
                tempArray[tempIndex++] = array[rightIndex++];
            }else{
                tempArray[tempIndex++] = array[leftIndex++];
            }
        }
    }


    public int[] mergeSort(int[] array, int left, int right, int[] tempArray) {
        if (left < right) {
            int midIndex = (left + right) / 2;
            mergeSort(array, left, midIndex, tempArray);
            mergeSort(array, midIndex + 1, right, tempArray);
            mergeArray(array, left, midIndex, right, tempArray);
        }
        return array;
    }


    private void mergeArray(int[] array, int left, int mid, int right, int[] tempArray) {
        int tempIndex = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (leftIndex <= mid && array[leftIndex] < array[rightIndex]) {
                tempArray[tempIndex++] = array[leftIndex++];
            } else {
                tempArray[tempIndex++] = array[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            tempArray[tempIndex++] = array[leftIndex++];
        }
        while (rightIndex <= right) {
            tempArray[tempIndex++] = array[rightIndex++];
        }
        tempIndex = 0;
        while (left <= right) {
            array[left++] = tempArray[tempIndex++];
        }

    }

    /**
     * @param array 数组
     * @param left  假如两个数组，那么就是第一个数组的起始位置
     * @param mid   假如两个数组，那么就是第二个数组的起始位置
     * @param right
     */
    private void mergeArray(int[] array, int left, int mid, int right) {

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

    }

}
