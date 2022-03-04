package j.com.lib.leetcode;

import java.util.HashMap;

public class lt_146_LRUCache_1 {

    HashMap<Integer, Node> map = new HashMap<>();
    /**
     * 保存顺序的
     */
    DoubleNode cache;

    int maxSize = 0;

    public lt_146_LRUCache_1(int size) {
        cache = new DoubleNode();
        maxSize = size;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //如果有，找到，并提高优先级
        Node node = map.get(key);
        cache.remove(node);
        cache.addLastNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //如果已经有了，那么就删除老的，添加新的
            Node node = map.get(key);
            cache.remove(node);
            map.remove(key);
            //添加新的
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            cache.addLastNode(newNode);
            return;
        }
        //如果没有
        if (maxSize == map.size()) {
            //已经达到最大容量
            Node node = cache.removeFirst();
            map.remove(node.key);
        }
        //添加新的
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        cache.addLastNode(newNode);
    }


    static class DoubleNode {
        Node head;
        Node tail;
        int size;

        public DoubleNode() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public void addLastNode(Node node) {
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeFirst() {
            if (head.next == null) {
                return null;
            }
            Node node = head.next;
            remove(node);
            return node;
        }

        public int getSize() {
            return size;
        }

    }

    static class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
