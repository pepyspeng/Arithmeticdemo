package j.com.lib.offer;

import j.com.lib.bean.TreeNode;

/**
 * Created by pepys on 2019/6/25
 * description:重建二叉树
 */
public class offer_6_ConstructBinaryTree {

    static BinaryTreeNode root;

    /**
     * 构建二叉树
     * A
     * B       C
     * D       E      F
     * G  H    I
     */
    public void createBinaryTree() {
        root = new BinaryTreeNode("A");
        BinaryTreeNode treeNodeB = new BinaryTreeNode("B");
        BinaryTreeNode treeNodeC = new BinaryTreeNode("C");
        BinaryTreeNode treeNodeD = new BinaryTreeNode("D");
        BinaryTreeNode treeNodeE = new BinaryTreeNode("E");
        BinaryTreeNode treeNodeF = new BinaryTreeNode("F");
        BinaryTreeNode treeNodeG = new BinaryTreeNode("G");
        BinaryTreeNode treeNodeH = new BinaryTreeNode("H");
        BinaryTreeNode treeNodeI = new BinaryTreeNode("I");

        root.leftChild = treeNodeB;
        root.rightChild = treeNodeC;
        treeNodeB.leftChild = treeNodeD;
        treeNodeD.leftChild = treeNodeG;
        treeNodeD.rightChild = treeNodeH;
        treeNodeC.leftChild = treeNodeE;
        treeNodeC.rightChild = treeNodeF;
        treeNodeE.rightChild = treeNodeI;

    }


    public static void main(String[] args) {
        offer_6_ConstructBinaryTree binaryTree = new offer_6_ConstructBinaryTree();
        binaryTree.createBinaryTree();
//        binaryTree.preOrder(root);
        String[] pre = {"A", "B", "D", "G", "H", "C", "E", "I", "F"};

        String[] mid = {"G", "D", "H", "B", "A", "E", "I", "C", "F"};
        /**
         * 前序：根左右
         * 中序：左根右
         * 那么就能根据前序和中序得到二叉的根节点和左右子节点。
         * 然后左右子节点不断递归，得到整个二叉树
         */
//        root = binaryTree.resetBinaryTree1(
//                pre, //前序
//                0,//前序开始
//                pre.length - 1,//前序结束
//                mid,//中序
//                0,//中序开始
//                mid.length - 1//中序结束
//        );
        root = binaryTree.resetBinaryTree(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
        binaryTree.preOrder(root);
    }

//    public BinaryTreeNode resetBinaryTree1(String[] pre, int preStart, int preEnd, String[] mid, int midStart, int midEnd) {
//        if (preStart > preEnd || midStart > midEnd) {
//            return null;
//        }
//        BinaryTreeNode treeNode = new BinaryTreeNode(pre[preStart]);
//        for (int i = midStart; i <= midEnd; i++) {
//            if (pre[preStart].equals(mid[i])) {
//                BinaryTreeNode leftNode = resetBinaryTree(
//                        pre,
//                        preStart + 1,////当前节点+1,得到这个左子树的起始节点
//                        preStart + (i - midStart),
//                        mid,
//                        midStart,
//                        midStart+i
//                );
//            }
//        }
//    }

    /**
     * 前序遍历  递归
     *
     * @param treeNode
     */
    public void preOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        } else {
            //首先输出根节点。
            System.out.println("data:" + treeNode.value);
            //不断的调用自身函数，把左节点输出。
            preOrder(treeNode.leftChild);
            //根节点和左节点输出完成，输出右节点。
            preOrder(treeNode.rightChild);
        }
    }

    public BinaryTreeNode resetBinaryTree1(String[] pre, int preStart, int preEnd, String[] mid, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd) {
            return null;
        }
        BinaryTreeNode treeNode = new BinaryTreeNode(pre[preStart]);
        for (int i = midStart; i <= midEnd; i++) {
            if (pre[preStart].equals(mid[i])) {
                treeNode.leftChild = resetBinaryTree1(pre,
                        preStart + 1,
                        preStart + (i - midStart),// (i - startIn)是中序遍历中左子树的长度，所以左子树的总长度：前序的 startPre + 中序遍历中左子树的长度
                        mid,
                        midStart,
                        i - 1);
                treeNode.rightChild = resetBinaryTree1(pre,
                        preStart + (i - midStart) + 1,
                        preEnd,
                        mid,
                        i + 1,
                        midEnd);
                break;
            }
        }
        return treeNode;
    }

    public TreeNode reBuild(int[] pre, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        /**
         * 前序：根左右
         * 中序：左根右
         * 那么就能根据前序和中序得到二叉的根节点和左右子节点。
         * 然后左右子节点不断递归，得到整个二叉树
         * 第一次循环
         * String[] pre = {"A", "B", "D", "G", "H", "C", "E", "I", "F"};
         *
         * String[] mid = {"G", "D", "H", "B", "A", "E", "I", "C", "F"};
         * A 是根节点，那么i = 4 是找到根节点。也就是 以A为根节点的树，
         * 左子树的长度是 4，也就是
         * 前序遍历中 左子树 BDGH 位置  , preStart =preStart +1,preEnd = preStart +(i-inStart),
         * 中序遍历中 左子树 BDGH 位置    inStart =inStart, inEnd = i-1
         *
         * 前序遍历中 右子树的 CEIF位置，preStart =(上面的preEnd+1) = preStart +(i-inStart)+1,preEnd = preEnd,
         * 中序遍历中 右子树的 CEIF位置，inStart =i+1 ,indEnd = inEnd
         */
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i < inEnd; i++) {
            if (root.val == i) {
                //找到了中序数组中的根节点。
                root.left = reBuild(pre,
                        preStart + 1,
                        preStart + (i - inStart),
                        inorder,
                        inStart,
                        i - 1);
                root.right = reBuild(pre,
                        preStart + (i - inStart)+1,
                        preEnd,
                        inorder,
                        i+1,
                        inEnd);
                break;
            }
        }

        return root;
    }

    public BinaryTreeNode resetBinaryTree(String[] pre, int preStart, int preEnd, String[] mid, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd) {
            return null;
        }
        BinaryTreeNode treeNode = new BinaryTreeNode(pre[preStart]);
        for (int i = midStart; i <= midEnd; i++) {
            if (pre[preStart].equals(mid[i])) {
                treeNode.leftChild = resetBinaryTree(pre,
                        preStart + 1,
                        preStart + (i - midStart),
                        mid,
                        midStart,
                        i - 1);
                treeNode.rightChild = resetBinaryTree(pre,
                        preStart + (i - midStart) + 1,
                        preEnd,
                        mid,
                        i + 1,
                        midEnd);
                break;
            }
        }
        return treeNode;
    }

}
