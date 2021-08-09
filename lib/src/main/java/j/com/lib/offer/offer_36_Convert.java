package j.com.lib.offer;

import java.util.ArrayList;
import java.util.List;

import j.com.lib.bean.TreeNode;

/**
 * 搜索二叉树和双相链表
 */
public class offer_36_Convert {
    List<TreeNode> mid = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        getMid(pRootOfTree);
        if(mid.size()<=1){
            return mid.get(0);
        }
        for (int i = 0;i<mid.size();i++){
            TreeNode root = mid.get(i);
            if(i == 0){
                root.right = mid.get(i+1);
            }else if(i == mid.size()-1){
                root.left = mid.get(i-1);
            }else{
                root.right = mid.get(i+1);
                root.left = mid.get(i-1);
            }
        }
        return mid.get(0);
    }

    public void getMid(TreeNode root){
        if(root == null){
            return;
        }
        getMid(root.left);
        mid.add(root);
        getMid(root.right);
    }
}
