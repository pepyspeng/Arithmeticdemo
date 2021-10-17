package j.com.lib.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import j.com.lib.bean.TreeNode;

public class offer_6_roteMin {

    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return  new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(root !=null){
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if(root.left!=null){
                queue.offer(root.left);

            }
            if(root.right!=null){
                queue.offer(root.right);
            }
        }
        int[] array = new int[result.size()];
        for(int i=0;i<result.size();i++){
            array[i] = result.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,1};
        System.out.println( minArray1(array));
    }
    public static int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static int minArray(int[] numbers) {
        if(numbers.length == 0){
            return 0;
        }
        int left = 0;
        int right = numbers.length -1;
        if(numbers[left]<numbers[right]){
            //说明整个数组有序
            return numbers[left];
        }
        while(left<right){
            int mid = (left+right)/2;
            if(numbers[mid]>numbers[right]){
                //中间的大于右边的，说明左半区是递增的，舍弃左半区
                left = mid+1;
            }else if(numbers[mid]<numbers[right]){
                //中间的小于右边的，说明右半区是递增的，舍弃右半区
                right = mid;
            } else{
                right --;
            }
        }
        return numbers[left];
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] < array[right]) {
                //说明左边到右边是递增的。
                return array[left];
            }
            int mid = (left + right) >> 1;
            if (array[mid] > array[right]) {
                //说明右半去飞递增，因为已知最小值，所以可以直接过array[mid]
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                //右半区递增，直接舍弃右半区
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
