package j.com.lib.offer;

import j.com.lib.bean.TreeNode;

/**
 * @author : zhupp
 * @date : 2021/9/2
 * description : 判断一棵树是否是平衡二叉树
 */
public class offer_49_IsBalanced_Solution {

    public static void main(String[] args) {

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        DepthTree(root);
        return isBalanced;
    }

    private boolean isBalanced = true;

    public int DepthTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = DepthTree(node.left);
        int right = DepthTree(node.right);
        if (Math.abs(right - left) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
