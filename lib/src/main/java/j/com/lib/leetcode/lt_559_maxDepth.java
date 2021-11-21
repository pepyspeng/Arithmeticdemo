package j.com.lib.leetcode;



import j.com.lib.bean.Node;

/**
 * N 叉树的最大深度
 */
public class lt_559_maxDepth {
    public static void main(String[] args) {
        Node node = Node.getChildrenTreeNode();
        System.out.println(maxDepth(node));
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if(root.children == null){
            return 1;
        }
        int maxDepth = 0;
        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            int depth = maxDepth(node);
            System.out.println(node.val + "depth " + depth);
            maxDepth = Math.max(maxDepth, depth);
            System.out.println("maxDepth "+maxDepth);
        }
        return maxDepth + 1;
    }
}
