package j.com.lib.leetcode;

import j.com.lib.bean.ListNode;

public class lt_82_deleteDuplicates {

    public static void main(String[] args) {
        lt_82_deleteDuplicates duplicates = new lt_82_deleteDuplicates();
//        ListNode.printListNode(duplicates.deleteDuplicates(ListNode.getDupInstance()));
        ListNode.printListNode(duplicates.deleteDuplicates1(ListNode.getDupInstance()));
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * head = [1,1,2]
     * 输出：[1,2]
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 删除排序链表中的重复元素 II,给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return node.next;
    }

}
