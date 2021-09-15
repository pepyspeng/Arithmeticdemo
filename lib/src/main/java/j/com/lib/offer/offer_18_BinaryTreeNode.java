package j.com.lib.offer;

import j.com.lib.bean.TreeNode;

public class offer_18_BinaryTreeNode {

    /**
     * 构建二叉树
     *          A
     *      B       C
     *   D       E      F
     * G  H    I
     */
    public  BinaryTreeNode createBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode("A");
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
        return root;
    }
    /**
     * 构建二叉树
     *      B       
     *   D            
     *      
     */
    public BinaryTreeNode createChildBinaryTree() {
        BinaryTreeNode treeNodeB = new BinaryTreeNode("B");
        BinaryTreeNode treeNodeD = new BinaryTreeNode("D");

        treeNodeB.leftChild = treeNodeD;
        return treeNodeB;
    }

    /**
     * 树的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean isSub = false;
        if (A != null && B != null) {
            if (A.val == B.val) {
                isSub = aHaveB(A, B);
            }
            if (!isSub) {
                isSub = isSubStructure(A.left, B);
            }
            if (!isSub) {
                isSub = isSubStructure(A.right, B);
            }
        }
        return isSub;

    }

    public boolean aHaveB(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return aHaveB(A.left, B.left) && aHaveB(A.right, B.right);
    }

    public static void main(String[] args) {
        offer_18_BinaryTreeNode binaryTreeNode = new offer_18_BinaryTreeNode();
        BinaryTreeNode father = binaryTreeNode.createBinaryTree();
        BinaryTreeNode child = binaryTreeNode.createChildBinaryTree();

        System.out.println(isChildTree(father,child));
    }

    public static boolean isChildTree(BinaryTreeNode father,BinaryTreeNode child){
        boolean result = false;
        if(father != null &&  child != null){
            if(father.value == child.value){
                 result = getSample(father,child);
            }
            if(!result){
                result = isChildTree(father.leftChild,child);
            }
            if(!result){
                result = isChildTree(father.rightChild,child);
            }
        }

       return result;
    }

    private static boolean getSample(BinaryTreeNode father, BinaryTreeNode child) {
        if(child ==null){
            return true;
        }
        if(father == null){
            return false;
        }
        if(father.value != child.value){
            return false;
        }
        return getSample(father.leftChild,child.leftChild) && getSample(father.rightChild,child.rightChild);

    }
}
