package j.com.lib.offer;

import j.com.lib.bean.ListNode;

/**
 * @author : zhupp
 * @date : 2021/10/22
 * description : 两个链表的第一个公共节点
 */
public class offer_52_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return  h1;
    }
}
