package j.com.lib.offer;

import j.com.lib.bean.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 */
public class offer_68_1_lowestCommonAncestor {


    /**
     *          6
     *      /       \
     *      2       8
     *   /   \    /   \
     *  0    4   7     9
     *      / \
     *     3   5
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            //搜索二叉树，根比两个小，说明在右边
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            //说明在右边
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

}
