package j.com.lib.offer;

import java.util.Stack;

import j.com.lib.node.ListNode;

/**
 * Created by pepys on 2019/6/25
 * description:从尾到头输出链表
 */
public class offer_5_NodePrint {

    private static ListNode head;

    public offer_5_NodePrint(int size) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < size; i++) {
            ListNode tmp = new ListNode(i);
            cur.next = tmp;
            cur = tmp;
        }
        this.head = head;
    }

    public static void main(String[] args) {
        offer_5_NodePrint nodePrint = new offer_5_NodePrint(5);
        nodePrint.nodePrint(head);
        System.out.println();
        nodePrint.nodeIteration(head);
    }

    /**
     * 利用栈先进后出
     *
     * @param node
     */
    public void nodePrint(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        for (ListNode node1 = node; node1 != null; node1 = node1.next) {
            stack.push(node1);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop().val);
        }

    }

    /**
     * 利用迭代
     *
     * @param node
     */
    public static void nodeIteration(ListNode node) {
        if (node == null) {
            return;
        }
        nodeIteration(node.next);
        System.out.print(node.val);
    }

}
