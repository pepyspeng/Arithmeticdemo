package j.com.lib.offer;

/**
 * 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 输入: [0,1,3]
 输出: 2
 */
public class offer_2_53_missingNumber {


    public int missingNumber(int[] nums) {
        if(nums ==null || nums.length==0){
            return -1;
        }
        int left =0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(mid == nums[mid]){
                //说明缺失的在右边
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
