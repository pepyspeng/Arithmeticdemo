package j.com.lib.offer;

import j.com.lib.bean.ListNode;

/**
 * 合并两个有序链表
 */
public class offer_17_MergeNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node4_1 = new ListNode(6);
        ListNode node5 = new ListNode(7);
        //1->2->4->6
        head.next = node;
        node.next = node2;
        node2.next = node4;

        //3->5->6->7
        node1.next = node3;
        node3.next = node4_1;
        node4_1.next = node5;

        ListNode temp1 = mergeNode(head,node1);

//        ListNode temp1 = revNodeWhile(head);
        while (temp1 != null) {
            System.out.print(temp1.val + "->");
            temp1 = temp1.next;
        }
    }

    public static ListNode mergeNode(ListNode node1, ListNode node2) {
        ListNode result = new ListNode();
        ListNode first = result;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                result.next = node1;
                node1 = node1.next;
            } else if(node1.val > node2.val){
                result.next = node2;
                node2 = node2.next;
            }else{
                result.next = node1;
                node1 = node1.next;
                result = result.next;
                result.next = node2;
                node2 = node2.next;
            }
            result = result.next;
        }
        while (node1 != null){
            result.next = node1;
            node1 = node1.next;
            result = result.next;
        }
        while (node2 != null){
            result.next = node2;
            node2 = node2.next;
            result = result.next;
        }
        return first.next;
    }

}
