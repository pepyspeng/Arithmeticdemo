package j.com.lib.sort;

/**
 * @author : zhupp
 * @date : 2021/5/11
 * description : 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{21, 4, 3, 98, 76, 47, 36, 65, 43, 13, 54, 85};
        int[] tempArray = new int[array.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array, tempArray, 0, array.length - 1);
        for (int value : array) {
            System.out.println(value);
        }
    }

    private void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, tempArray, left, mid);
            mergeSort(array, tempArray, mid + 1, right);
            mergeArray(array, tempArray, left, mid, right);
        }
    }

    private void mergeArray(int[] array, int[] tempArray, int left, int mid, int right) {
        int tempStarIndex = left;
        int leftStarIndex = left;
        int rightStarIndex = mid + 1;
        while (leftStarIndex <= mid && rightStarIndex <= right) {
            if (array[leftStarIndex] < array[rightStarIndex]) {
                tempArray[tempStarIndex++] = array[leftStarIndex++];
            } else {
                tempArray[tempStarIndex++] = array[rightStarIndex++];
            }
        }
        while (leftStarIndex <= mid) {
            tempArray[tempStarIndex++] = array[leftStarIndex++];
        }
        while (rightStarIndex <= right) {
            tempArray[tempStarIndex++] = array[rightStarIndex++];
        }
        while (left <= right) {
            array[left] = tempArray[left++];
        }
    }

}
