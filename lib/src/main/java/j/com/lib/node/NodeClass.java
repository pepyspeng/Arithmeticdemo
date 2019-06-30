package j.com.lib.node;

import java.util.Stack;

import j.com.lib.bean.ListNode;

public class NodeClass {

    private ListNode head;

    public NodeClass(int size) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < size; i++) {
            ListNode tmp = new ListNode(i);
            cur.next = tmp;
            cur = tmp;
        }
        this.head = head;
    }

    public static void printChain(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        sb.append(cur.val);
        while (null != cur.next) {
            sb.append(" -> ");
            sb.append(cur.next.val);
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        NodeClass nodeClass = new NodeClass(5);
        nodeClass.head = nodeClass.reverseListStack(nodeClass.head);
        printChain(nodeClass.head);
    }

    public ListNode reverseListStack(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next) {
            stack.push(node);
        }
        ListNode reverseHead = stack.pop();
        ListNode current = reverseHead;
        while (!stack.empty()) {
            current.next = stack.pop();
            current = current.next;
            current.next = null;
        }

        return reverseHead;
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
       /* if(head.next == null){
            return null;
        }
        reverseList(head.next);
        head.next = head;
        return head;*/
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curren = head;
        ListNode result = null;
        while (curren != null) {
            ListNode nextTemp = curren.next;
            curren.next = result;
            result = curren;
            curren = nextTemp;

        }
        return result;
    }

    /**
     * 删除当前节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

    }
}
