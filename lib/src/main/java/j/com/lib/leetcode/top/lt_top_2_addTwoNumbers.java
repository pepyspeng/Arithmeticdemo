package j.com.lib.leetcode.top;

import java.util.ArrayList;
import java.util.List;

import j.com.lib.bean.ListNode;

/**
 * @author     : zhupp
 * @date       : 2021/10/22
 * description : 两数相加
 * //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * //输入：l1 = [2,4,3], l2 = [5,6,4]
 * //输出：[7,0,8]
 * //解释：342 + 465 = 807.
 */
public class lt_top_2_addTwoNumbers {

    public static void main(String[] args) {
        int[] a = {1,4,3,2};
        int[] b = {13,5,1,4};
//        System.out.println(addTwoNumbers(a,b));
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //用来做虚拟头部
        ListNode temp = new ListNode(-1);
        ListNode p = temp;
        //记录进位
        int carry = 0;
        while(l1!=null || l2 !=null || carry>0){
            //只有有一个不为0，或者进位大于0的情况，就继续
            //先加上进位
            int val = carry;
            if(l1 !=null){
                val +=l1.val;
                l1 = l1.next;
            }
            if(l2 !=null){
                val += l2.val;
                l2 = l2.next;
            }
            //进位取除数
            carry = val / 10;
            //当前数字取模
            val = val%10;
            p.next = new ListNode(val);
            p = p.next;
        }
        return temp.next;
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumHead = new ListNode(-1);
        ListNode sumNode = sumHead;
        while (l1 != null || l2 != null) {
            // 求和
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            sumNode.next = new ListNode(sum);
            // 三个指针后移
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            sumNode = sumNode.next;
        }
        if (carry != 0) {
            sumNode.next = new ListNode(carry);
        }
        return sumHead.next;
    }
}

