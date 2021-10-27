package j.com.lib.offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * <p>
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class offer_41_MedianFinder {
    Queue<Integer> A, B;

    public offer_41_MedianFinder() {
        // 小顶堆，保存较大的一半
        A = new PriorityQueue<>();
        // 大顶堆，保存较小的一半
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            //如果两个堆的数据一样，说明是偶数，需向 AA 添加一个元素。实现方法：将新元素 num 插入至 BB ，再将 BB 堆顶元素插入至 AA ；
            A.add(num);
            //假设插入数字 num 遇到情况 1. 。由于 num 可能属于 “较小的一半” （即属于 BB ），因此不能将 nums 直接插入至 AA 。
            // 而应先将 num 插入至 BB ，再将 BB 堆顶元素插入至 AA 。这样就可以始终保持 AA 保存较大一半、 BB 保存较小一半。
            B.add(A.poll());
        } else {
            //说明是奇数，需向 B 添加一个元素。实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 BB ；
            B.add(num);
            // 如果B是较大的一半，那么它一定在堆顶，放入A，如果B属于较小的一半，原来堆顶就属于较大的一半
            A.add(B.poll());
        }
    }

    public double findMedian() {
        if (A.size() == B.size()) {
            return (A.peek() + B.peek()) / 2.0;
        } else {
            return A.peek() / 1.0;
        }
    }
}
