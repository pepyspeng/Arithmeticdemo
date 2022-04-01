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

//        root = binaryTree.reBuild1(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
//        binaryTree.preOrder(root);
    }

    /**
     * 前序，根左右
     * 中序，左根右
     *
     * @param pre
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    private TreeNode reBuild(int[] pre, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //根节点的值
        int rootVal = pre[preStart];
        // 中序中的根节点 索引
        int midRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                //找到了中序中的根节点
                midRootIndex = i;
                break;
            }
        }
        //找到了左子树的长度
        int leftLength = midRootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = reBuild(pre,
                preStart + 1,
                preStart + leftLength,
                inorder,
                inStart,
                midRootIndex - 1);
        //inStart+leftLength-1 = midRootIndex -1 这俩相等？
        // inStart +(midRootIndex-inStart) = midRootIndex -1
        root.right = reBuild(pre,
                preStart + leftLength + 1,
                preEnd,
                inorder,
                midRootIndex + 1,
                inEnd);
        return root;
    }


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


}
