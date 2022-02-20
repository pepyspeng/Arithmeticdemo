package j.com.lib.leetcode;

import java.util.List;

import j.com.lib.bean.ListNode;

/**
 * 环行链表
 */
public class lt_142_detectCycle {

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * head:表示链表起点，当找到环相遇点时，，，
     * 设：slow前进了k步,那么这时候fast肯定走了2k步。因为fase是双倍再走
     * 假设从 环起始点->相遇点的距离是M，那么从头结点->环起点就是（k-m）, 又能算出 相遇点转一圈到起点也是 k-m。
     * 所以当相遇时，其中一个几点回到起始位置，再次相遇时就是 环的起点。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        //快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //找到环后退出
            if (fast == slow) {
                break;
            }
        }
        //发生这种情况，就说明 链表没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 让快慢之一回到head，之后相遇就是起点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
