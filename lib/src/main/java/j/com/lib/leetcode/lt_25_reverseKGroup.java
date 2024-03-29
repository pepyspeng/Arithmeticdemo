package j.com.lib.leetcode;

import j.com.lib.bean.ListNode;


/**
 * K 个一组翻转链表
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class lt_25_reverseKGroup {

    /**
     * 首先先
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        //base case
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        ListNode slow = head;
        ListNode reverseNode = reverse(slow, fast);
        slow.next = reverseKGroup(fast, k);
        return reverseNode;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.getInstance();
        ListNode result = reverse(node, new ListNode(5));
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 这个是反转链表的变准迭代式，其中第二个参数是NULL,那就是反转整个链表，否则就是反转一个[a,b) 左闭右开。
     *
     * @param a
     * @param b
     * @return
     */
    public static ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode next;
        ListNode pre = null;
        while (cur.val != b.val) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
