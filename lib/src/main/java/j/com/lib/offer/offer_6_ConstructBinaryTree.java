package j.com.lib.offer;

/**
 * Created by pepys on 2019/6/25
 * description:重建二叉树
 */
public class offer_6_ConstructBinaryTree {

    static BinaryTreeNode root;

    /**
     * 构建二叉树
     *          A
     *      B       C
     *   D       E      F
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
        binaryTree.preOrder(root);
        String[] pre = {"A", "B", "D", "G", "H", "C", "E", "I", "F"};

        String[] mid = {"G", "D", "H", "B", "A", "E", "I", "C", "F"};
        root = binaryTree.resetBinaryTree(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
        binaryTree.preOrder(root);
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


    public BinaryTreeNode resetBinaryTree(String[] pre, int preStart, int preEnd, String[] mid, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd) {
            return null;
        }
        BinaryTreeNode treeNode = new BinaryTreeNode(pre[preStart]);
        for (int i = midStart; i < midEnd; i++) {
            if (pre[preStart].equals(mid[i])) {
                treeNode.leftChild = resetBinaryTree(pre,
                        preStart + 1,
                        preStart + (i - midStart),
                        mid,
                        midStart,
//                        ,i-1
                        midStart + i);
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
