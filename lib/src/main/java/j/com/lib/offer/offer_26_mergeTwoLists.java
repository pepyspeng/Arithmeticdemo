package j.com.lib.offer;

import java.util.List;

import j.com.lib.bean.ListNode;

/**
 * @author : zhupp
 * @date : 2021/10/22
 * description :  合并两个排序的链表
 */
public class offer_26_mergeTwoLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node5 = new ListNode(7);

        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node4 = new ListNode(6);

        head.next = node1;
        node1.next = node3;
        node3.next = node5;

        node.next = node2;
        node2.next = node4;

        ListNode result = mergeTwoLists(head, node);
        while (result.next != null) {
            System.out.print(result.next + "->");
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode();
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }

        return cur.next;
    }
}
