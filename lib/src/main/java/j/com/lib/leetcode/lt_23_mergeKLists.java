package j.com.lib.leetcode;

import java.util.List;
import java.util.PriorityQueue;

import j.com.lib.bean.ListNode;

/**
 * 合并K个升序链表
 */
public class lt_23_mergeKLists {


    /**
     * 可以利用优先级队列，将所有链表的头结点放入 优先级队列中。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //虚拟头结点
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        //优先级队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            //所有头结点放入优先级队列中
            priorityQueue.offer(node);
        }

        while (!priorityQueue.isEmpty()) {
            //取出最小的节点
            ListNode node = priorityQueue.poll();
            temp.next = node;
            if (node.next != null) {
                //下一节点继续放入队列中
                priorityQueue.offer(node.next);
            }
            temp = temp.next;
        }
        return res;
    }
}
