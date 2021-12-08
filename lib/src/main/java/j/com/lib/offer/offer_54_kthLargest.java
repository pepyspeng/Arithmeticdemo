package j.com.lib.offer;


import j.com.lib.bean.TreeNode;

/**
 * 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class offer_54_kthLargest {


    int result = 0;
    int position = 0;

    /**
     * 二叉搜索树的中序遍历是递增的，那么可以倒着遍历，既能得到递减的，
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        position = k;
        dfs(root);
        return result;
    }

    /**
     * 中序是  左根右
     * 倒着是  右根左
     * @param root
     */
    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.right);
        if(position == 0){
            // 若 k = 0k=0 ，代表已找到目标节点，无需继续遍历，因此直接返回；
            return;
        }
        //执行 k = k - 1 （即从 kk 减至 00 ）
        if(--position == 0){
            // 若 k = 0 ，代表当前节点为第 k 大的节点，因此记录 res = root.val
            result = root.val;
        }
        dfs(root.left);
    }
}
