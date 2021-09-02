package j.com.lib.offer;

import j.com.lib.bean.TreeNode;

public class offer_48_treeDepth {
    public static void main(String[] args) {

    }

    public static int TreeDepth(TreeNode root) {
        if(root ==null){
            return 0;
        }
        int leftH = TreeDepth(root.left);
        int rightH = TreeDepth(root.right);
        return Math.max(leftH,rightH)+1;
    }
}
