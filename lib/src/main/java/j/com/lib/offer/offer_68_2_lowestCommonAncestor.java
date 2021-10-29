package j.com.lib.offer;

import j.com.lib.bean.TreeNode;

/**
 * 二叉搜的最近公共祖先
 */
public class offer_68_2_lowestCommonAncestor {


    /**
     * 3
     * /       \
     * 5       1
     * /   \    /   \
     * 6    2   0     8
     * / \
     * 7   4
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * <p>
     * <p>
     * 如果root为空， 直接返回null
     * 如果root本身是p 、q .比如root是p,如果q 存在 root中，那么root是最近根节点，即使q不存在，也应该返回存在的root.也就是p.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            //如果root为空， 直接返回null
            return null;
        }
        if (root == p || root == q) {
            //如果root本身是p 、q .比如root是p,如果q 存在 root中，那么root是最近根节点，即使q不存在，也应该返回存在的root。
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            //如果q、p都存在已root为根的树中，那么left和right 就一定是left和right;
            return root;
        }
        if (left == null && right == null) {
            //如果q、p都不存在root树中，那么直接返回null
            return null;
        }
        //如果只有一个存在root为根的树中，那么返回对应的。
        return left == null ? right : left;

    }

}
