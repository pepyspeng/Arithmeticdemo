package j.com.lib.offer;

import java.util.Arrays;

public class Offer_39_Topk {
    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 3, 7, 2, 8, 5, 4, 9};
        Offer_39_Topk topK = new Offer_39_Topk();
        System.out.println(Arrays.toString(topK.getLeastNumbers(array, 3)));
//        System.out.println(Arrays.toString(topK.getTopK(array, 9)));

    }


    private int[] getLeastNumbers(int[] array, int k) {
        if(k ==0 || array.length ==0){
            return new int[0];
        }
        return quickSearch(array, 0, array.length-1, k-1);
    }

    private int[] quickSearch(int[] array, int left, int right, int k) {
        int index = getIndex(array,left,right);
        if(index == k){
            //得到的正好是需要的index
            return  Arrays.copyOf(array,k+1);
        }else if(index<k){
            //说明 需要的值在右边区域
            return quickSearch(array,index+1,right,k);
        }else {
            //说明 需要的值在左边区域
            return  quickSearch(array,left,index-1,k);
        }

    }

    private int getIndex(int[] array, int left, int right) {
        int temp = array[left];
        while (left<right){
            while (left<right && array[right] >= temp){
                right--;
            }
            array[left] = array[right];
            while (left<right && array[left] <= temp){
                left++;
            }
            array[right] = array[left];
        }
        array[left] =temp;
        return left;

    }


//
//    public int[] getTopK(int[] arr, int k) {
//        if (k == 0 || arr.length == 0) {
//            return new int[0];
//        }
//        //最后一个参数表示我们要找的是下标为k-1的数
//        return quickSearch1(arr, 0, arr.length - 1, k - 1);
//    }
//
//    private int[] quickSearch1(int[] arr, int left, int right, int k) {
//        //快排一次，找到排序后下表为 index 的元素，如果index等于k就返回index以及index左边所有的数
//        int index = partition1(arr, left, right);
//        if (index == k) {
//            return Arrays.copyOf(arr, index + 1);
//        }
//        //否则根据下标index与k的关系来决定 继续切分 左端还是右端
//        return index > k ? quickSearch1(arr, left, index - 1, k) : quickSearch1(arr, index + 1, right, k);
//    }
//
//    private int partition1(int[] a, int left, int right) {
//        int temp = a[left];
//        while (left < right) {
//            while (left < right && a[right] >= temp) {
//                right--;
//            }
//            a[left] = a[right];
//            while (left < right && a[left] <= temp) {
//                left++;
//            }
//            a[right] = a[left];
//        }
//        a[left] = temp;
//        return left;
//    }




}
