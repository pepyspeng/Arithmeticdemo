package j.com.lib.offer;

import j.com.lib.bean.ListNode;

/**
 * 反转链表
 */
public class offer_16_revserNode {

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
        ListNode temp1 = revNodeWhile(head);
        while (temp1 != null) {
            System.out.print(temp1.val + "->");
            temp1 = temp1.next;
        }
    }

    /**
     * 首先定义一个指针，用于保存下一个节点
     * 每次循环先保存下一个节点
     * 然后让当前节点的下一个节点指向前一个节点
     * 然后让下一节点等于现在的节点--用于下次循环使用
     * 最后让现在节点等于最开始的下一节点
     * @param node
     * @return
     */
    public static ListNode revNodeWhile(ListNode node){
        //存储前一个节点
        ListNode nextNode = null;
        while (node !=null){
            ListNode temp = node.next;
            node.next = nextNode;
            nextNode = node;
            node = temp;
        }
        return nextNode;

    }


    /**
     * 递归
     * @param headNode
     * @return
     */
    public static ListNode revNode(ListNode headNode){
        if(headNode == null ){
            return null;
        }
        if( headNode.next ==null){
            return headNode;
        }
        ListNode nextNode = headNode.next;
        headNode.next = null;
        ListNode head = revNode(nextNode);
        nextNode.next = headNode;
        return  head;
    }
}
