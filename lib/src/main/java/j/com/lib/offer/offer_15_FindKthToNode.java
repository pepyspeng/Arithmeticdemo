package j.com.lib.offer;

import j.com.lib.bean.ListNode;

/**
 * 倒数第K个节点
 */
public class offer_15_FindKthToNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(7);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = FindKToNode(head, -1);
        System.out.println(result == null ? "-1" : result.val);
    }

    public static ListNode FindKToNode(ListNode node, int k) {
        if (node == null || node.next == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        ListNode kNode = node.next;
        int i = 1;
        while (i < k - 1) {
            kNode = kNode.next;
            if (kNode == null) {
                return null;
            }
            i++;
        }

        while (kNode.next != null) {
            node = node.next;
            kNode = kNode.next;
        }

        return node;

    }

}
