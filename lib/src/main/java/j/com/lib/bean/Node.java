package j.com.lib.bean;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;
    public List<Node> children;

    public Node(int x) {
        val = x;
    }

    /**
     * 4
     * 2       6
     * 1    3   5   7
     *
     * @return
     */
    public static Node getChildrenTreeNode() {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        ArrayList<Node> children1 = new ArrayList<Node>();
        children1.add(root2);
        children1.add(root3);
        children1.add(root4);
        root1.children = children1;
        ArrayList<Node> children3 = new ArrayList<Node>();
        children3.add(root5);
        children3.add(root6);
        root3.children = children3;

        return root1;
    }

    /**
     * 4
     * 2       6
     * 1    3   5   7
     *
     * @return
     */
    public static Node getTreeNode() {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);

        root4.left = root2;
        root4.right = root6;
        root2.left = root1;
        root2.right = root3;
        root6.left = root5;
        root6.right = root7;
        return root4;
    }
}
