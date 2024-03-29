package j.com.lib.offer;

import j.com.lib.bean.ListNode;

/**
 * @author : zhupp
 * @date : 2021/9/1
 * description : 输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class offer_46_firstCommonNode {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
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

        node0.next = node1;

//        while (node0 !=null){
//            System.out.println(node0.val);
//            node0 = node0.next;
//        }
//        System.out.println("----------------------------");
//        while (head !=null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        System.out.println(""+ FindFirstCommonNode(node0,head).val);
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
