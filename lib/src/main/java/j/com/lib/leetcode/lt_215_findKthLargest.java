package j.com.lib.leetcode;

/**
 * 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 */
public class lt_215_findKthLargest {

    public static void main(String[] args) {
        lt_215_findKthLargest largest = new lt_215_findKthLargest();
        System.out.println(largest.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

    public int findKthLargest(int[] nums, int k) {
        int lastk = nums.length - k;
        return quickSort(nums,0,nums.length - 1,lastk);
    }

    public int quickSort(int[] arr,int left,int right,int k){
        int index = getIndex(arr,left,right);
        if( index == k ){
            return arr[index];
        }else if(index < k){
            //如果 找到的 比 目标 小了，说明要找的区域 在右边
            return quickSort(arr,index+1,right,k);
        }else{
            return quickSort(arr,left,index-1,k);
        }
    }

    public int getIndex(int[] arr,int left,int right){
        int temp = arr[left];
        while(left <right){
            while(left <right &&  temp <= arr[right]){
                //如果右边比左边的大，直到找到右边比
                right--;
            }
            arr[left] = arr[right];
            while(left < right && temp >= arr[left]){
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
