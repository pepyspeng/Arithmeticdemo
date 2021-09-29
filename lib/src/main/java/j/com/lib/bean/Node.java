package j.com.lib.bean;

public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int x) {
        val = x;
    }

    /**
     *              4
     *          2       6
     *       1    3   5   7
     *
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
