package j.com.lib.bean;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode getTreeNode() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);

        root4.left = root2;
        root4.right = root6;
        root2.left = root1;
        root2.right = root3;
        root6.left = root5;
        root6.right = root7;
        return root4;
    }
}
