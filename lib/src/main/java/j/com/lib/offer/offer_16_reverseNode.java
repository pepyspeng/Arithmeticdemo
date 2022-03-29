package j.com.lib.offer;

import j.com.lib.bean.ListNode;

/**
 * 反转链表
 */
public class offer_16_reverseNode {


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
        offer_16_reverseNode reverseNode = new offer_16_reverseNode();
        ListNode temp1 = reverseNode.reverseKGroup(head, 2);
        while (temp1 != null) {
            System.out.print(temp1.val + "->");
            temp1 = temp1.next;
        }
    }


    public ListNode reverseKGroup(ListNode node, int k) {
        if (node == null || k == 0) {
            return node;
        }
        ListNode fast = node;
        //先用快指针移动k个
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return node;
            }
            fast = fast.next;
        }
        //然后就反转快慢之间的节点
        ListNode reverseHead = reverse(node, fast);
        node.next = reverseKGroup(fast,k);
        return reverseHead;
    }

    /**
     * 1->2->3->4
     * 返回的就是 4 ： 4->3->2->1
     *
     *
     * @param slow
     * @param fast
     * @return
     */
    private ListNode reverse(ListNode slow, ListNode fast) {
        ListNode pre = null;
        ListNode cur = slow;
        ListNode next = null;
        while (cur.val != fast.val) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 递归实现 反转列表
     * 对于递归算法，最重要的就是明确递归函数的定义。
     * 具体来说，我们的 reverse 函数定义是这样的：
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     *
     * @param head
     * @return
     */
    public ListNode reverseDpNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        /**
         * head
         *  1   ->  2   ->  3   ->  4
         *
         *  head->reverse( 2->3->4 ) 执行完毕后
         *  head            last
         *  1 - >(2<-3<-3<- 4)
         */
        ListNode last = reverseDpNode(head.next);
        /**
         * head     head.next
         *  1   ->      2
         *  也就是让2指向1
         */
        head.next.next = head;
        /**
         * head.next = null
         * 也就是让  1.next 指向 空
         */
        head.next = null;
        return last;
    }


    //记录反转之后的头结点的后一个节点
    ListNode next = null;

    /**
     * 反转链表前 N 个节点
     *
     * @param head
     * @return
     */
    public ListNode reverseDpNodeN(ListNode head, int n) {

        if (n == 1) {
            // base case 变为 n == 1，反转一个元素，就是它本身，同时要记录后驱节点。
            // 记录第 n + 1 个节点
            next = head.next;
            return head;
        }
        //// 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseDpNodeN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = next;
        return last;

    }

    /**
     * 反转链表的一部分
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            //首先，如果 m == 1，就相当于反转链表开头的 n 个元素嘛，也就是我们刚才实现的功能：
            return reverseDpNodeN(head, n);
        }
        //如果 m != 1 怎么办？
        //如果我们把 head 的索引视为 1，那么我们是想从第 m 个元素开始反转对吧；如果把 head.next 的索引视为 1 呢？
        //那么相对于 head.next，反转的区间应该是从第 m - 1 个元素开始的；那么对于 head.next.next 呢……
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


}
