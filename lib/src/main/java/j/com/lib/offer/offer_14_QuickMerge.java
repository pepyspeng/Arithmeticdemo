package j.com.lib.offer;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;

public class offer_14_QuickMerge {

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 6, 3, 1, 2, 3, 4, 8, 7, 9};
        quickMerge(array, 0, array.length - 1);
        qiou(array);
        for (int i : array) {
            System.out.print(i);
        }
    }


    public static void qiou(int[] array) {
        if (array.length <= 0) {
            return;
        }
        Queue<Integer> qishu = new LinkedList<>();
        Queue<Integer> oushu = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                oushu.add(array[i]);
            }else{
                qishu.add(array[i]);
            }
        }
        int i = 0;
        while (!qishu.isEmpty()){
            array[i++] = qishu.poll();
        }
        while (!oushu.isEmpty()){
            array[i++] = oushu.poll();
        }
    }


    public class Reorder implements VoidTest {

        @Override
        public boolean getResult(int temp) {
            return false;
        }
    }

    interface VoidTest {
        public boolean getResult(int temp);
    }

    /**
     * 奇数在前，偶数在后
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickMerge(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

        }

    }

    private static void quickMerge(int[] array, int left, int right, VoidTest getResult) {
        if (left >= right) {
            return;
        }

        while (left < right) {
            while (left < right && getResult.getResult(array[left])) {
                left++;
            }
            while (left < right && getResult.getResult(array[right])) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

        }

    }

}
