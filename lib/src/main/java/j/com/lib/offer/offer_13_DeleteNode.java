package j.com.lib.offer;

import j.com.lib.bean.ListNode;

/**
 * Created by pepys on 2019/6/26
 * description:
 * ��0(1)ʱ����ɾ��������ĳһ���ڵ�
 *
 */
public class offer_13_DeleteNode {


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
        System.out.println("ɾ���м䣺");
        deleteNode(head, node);
        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }

        System.out.println("ɾ��β����");
        deleteNode(head, node5);
        ListNode temp1 = head;
        while (temp1.next != null) {
            System.out.print(temp1.val + "->");
            temp1 = temp1.next;
        }
    }


    public static void deleteNode(ListNode head, ListNode delNode) {
        if (delNode.next == null) {
            //˵��Ҫɾ���Ľڵ���β������ֻ��ѭ��ɾ��
            while (head.next != null) {
                if (head.next == delNode) {
                    head.next = null;
                } else {
                    head = head.next;
                }
            }
        } else if (head.next == null) {
            head = null;
        } else {
            delNode.val = delNode.next.val;
            delNode.next = delNode.next.next;
        }
    }
}
