package j.com.lib.sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] a = {1,2,3,2,2,2,5,4,2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        //直接插入排序
        for (int i = 1; i < a.length; i++) {
            //待插入元素
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;//插入进来
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
