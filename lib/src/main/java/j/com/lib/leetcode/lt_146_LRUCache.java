package j.com.lib.leetcode;

import java.util.HashMap;

public class lt_146_LRUCache {

    static class LRUCache {
        /**
         *
         */
        HashMap<Integer, Node> map;
        /**
         * 用来记录 顺序。
         */
        private DoubleNode cache;
        /**
         * 容量
         */
        private int cap;

        /**
         * 容量
         *
         * @param capacity
         */
        public LRUCache(int capacity) {
            this.cap = capacity;
            cache = new DoubleNode();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 将该数据提升为最近使用的
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            //逻辑先分为两步，
            //1: 若key已经存在
            if (map.containsKey(key)) {
                //删除老的数据
                remove(key);
                //添加新数据
                addRecently(key, value);
                return;
            }
            //2:若key不存在
            if (cap == map.size()) {
                //已经达到最大容量
                removeRecently();
            }
            addRecently(key, value);
        }

        /**
         * 将某个key提升为最近使用的
         *
         * @param key
         */
        private void makeRecently(int key) {
            Node node = map.get(key);
            cache.remove(node);
            cache.addLast(node);
        }

        /**
         * 添加一个最近使用元素
         *
         * @param key
         * @param val
         */
        private void addRecently(int key, int val) {
            Node node = new Node(key, val);
            cache.addLast(node);
            map.put(key, node);
        }

        /**
         * 删除某一个元素
         *
         * @param key
         */
        private void remove(int key) {
            Node node = map.get(key);
            cache.remove(node);
            map.remove(key);
        }

        /**
         * 删除最长未使用的
         */
        private void removeRecently() {
            Node node = cache.removeFirst();
            map.remove(node.key);
        }


        static class DoubleNode {
            /**
             * 尾节点
             */
            Node tail;
            /**
             * 头结点
             */
            Node head;
            /**
             * 双链表长度
             */
            int size = 0;

            public DoubleNode() {
                tail = new Node(0, 0);
                head = new Node(0, 0);
                head.next = tail;
                tail.pre = head;
            }

            /**
             * 添加尾节点
             *
             * @param node
             */
            public void addLast(Node node) {
                node.pre = tail.pre;
                node.next = tail;
                tail.pre.next = node;
                tail.pre = node;
                size++;
            }

            /**
             * 移除某个节点
             *
             * @param node
             */
            public void remove(Node node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                size--;
            }

            /**
             * 移除头结点，头结点一般都是需要删除的
             *
             * @return
             */
            public Node removeFirst() {
                if (head.next == null) {
                    return null;
                }
                /**
                 * head 和 tail 是临时的，不能使用。
                 */
                Node first = head.next;
                remove(first);
                return first;
            }

            public int getSize() {
                return size;
            }
        }

        static class Node {
            int val;
            int key;
            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.val = value;
            }
        }
    }
}
