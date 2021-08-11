package j.com.lib.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import j.com.lib.bean.TreeNode;
import sun.security.krb5.internal.PAData;

public class offer_34_pathSum {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        offer_34_pathSum pathSum = new offer_34_pathSum();
        pathSum.FindPath(root, 7);
        for (List<Integer> list : pathSum.result){
            System.out.println(list.toString());
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return result;
        }
        find(root,target,new ArrayList<>());
        return result;
    }

    private void find(TreeNode root, int target, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.val);
        target -= root.val;;
        if(target == 0 && root.left ==null && root.right == null){
            result.add(new ArrayList<>(path));
        }
        find(root.left,target,new ArrayList<>(path));
        find(root.right,target,new ArrayList<>(path));
    }
}
