package j.com.lib.offer;


import j.com.lib.bean.TreeNode;

/**
 * @author : zhupp
 * @date : 2021/9/2
 * description :二叉搜索树的后续遍历
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class offer_33_VerifySquenceOfBST {
    public static void main(String[] args) {
        System.out.println(new offer_33_VerifySquenceOfBST().verifyPostorder(new int[]{3,5,4 ,11,13,12,8}));
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    /**
     * @param root 根节点
     * @param min  最小值
     * @param max  最大值
     * @return
     */
    private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            //走到底了。
            return true;
        }
        if (min != null && min.val >= root.val) {
            //如果根节点小于等于 最小节点 ，那么就不是搜索二叉树
            return false;
        }
        if (max != null && max.val <= root.val) {
            //如果根节点 大于等于 最大节点，也不是
            return false;
        }
        //左节点，最大节点就是自己，最小节点还是min
        //右节点，最大节点是max,最小节点是自己
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }

    /**
     * 8
     * /    \
     * 4       12
     * /  \     /   \
     * 3    5   11   13
     * <p>
     * 二叉搜索树的
     * 中序遍历是 顺序的，也就是
     * 2、3、4 、8、11、12、13
     * 后续遍历： 3，5，4 ，11，13，12，8
     **/
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verifyPostorderDfs(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorderDfs(int[] postorder, int left, int right) {
        if (left > right) {
            //说明只有一个节点了
            return true;
        }
        //后续的最后一个，也就是根节点、
        int end = postorder[right];
        int i = 0;
        int position =0;
        for (i = left; i < right; i++) {
            position = i;
            if (postorder[i] > end) {
                //也就是找到了子节点的前半部分。
                break;
            }
        }
        for (int j = i; j < right; j++) {
            //在右子树中，一旦找到比根节点小的，说明不是搜索二叉树
            if (postorder[j] < end) {
                return false;
            }
        }
        System.out.println("I:"+i+"--position:"+position);
        return verifyPostorderDfs(postorder, left, i - 1) && verifyPostorderDfs(postorder, i, right - 1);
    }


    /**
     * 二叉搜索树的中序排列是有序的。
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }
        return dfs(sequence, 0, sequence.length - 1);
    }

    public boolean dfs(int[] array, int left, int right) {
        if (left > right) {
            //只有一个节点
            return true;
        }
        //后序的最后一个是根节点。
        int root = array[right];
        int i = 0;
        for (i = left; i < right; i++) {
            //后序遍历中，通过找到比根节点大的，来区分左右子树
            if (array[i] > root) {
                break;
            }
        }
        for (int j = i; j < right; j++) {
            //在右子树中，一旦找到比根节点小的，说明不是搜索二叉树
            if (array[j] < root) {
                return false;
            }
        }
        return dfs(array, left, i - 1) && dfs(array, i, right - 1);
    }


  /*  public boolean dfs(int[] array,int left,int right){
        if(left>right){
            return true;
        }
        int root = array[right];
        int i;
        for(i = left;i<right;i++){
            if(array[i]>root){
                //i 区分左右节点
                break;
            }
        }
        for(int j = i;j<right;j++){
            if(array[j]<root){
                return false;
            }
        }
        return dfs(array,left,i-1) && dfs(array,i,right-1);

    }*/
}
