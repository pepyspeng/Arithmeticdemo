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

    public int[] quickSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = getMidIndex(a, left, right);
            quickSort(a, left, mid);
            quickSort(a, mid + 1, right);
        }
        return a;
    }

    private int getMidIndex(int[] a, int left, int right) {
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] > temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] < temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }


}
