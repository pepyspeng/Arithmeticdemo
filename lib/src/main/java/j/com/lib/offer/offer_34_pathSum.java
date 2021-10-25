package j.com.lib.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import j.com.lib.bean.TreeNode;

/**
 * @author     : zhupp
 * @date       : 2021/10/25
 * description : 二叉树中和为某一值的路径
 * root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 */
public class offer_34_pathSum {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        if(root == null){
            return result;
        }
        dfs(root,target,new ArrayList<Integer>());
        return result;
    }

    private void dfs(TreeNode root, int target, ArrayList<Integer> path) {
        if(root == null){
            return;
        }
        int temp = target - root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && temp == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        dfs(root.left,temp,new ArrayList<>(path));
        dfs(root.right,temp,new ArrayList<>(path));
    }


//    public static void main(String[] args) {
//        TreeNode root = TreeNode.getTreeNode();
//        offer_34_pathSum pathSum = new offer_34_pathSum();
//        pathSum.FindPath(root, 7);
//        for (List<Integer> list : pathSum.result){
//            System.out.println(list.toString());
//        }
//    }
//
//    List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> FindPath(TreeNode root, int target) {
//        if(root == null){
//            return result;
//        }
//        find(root,target,new ArrayList<>());
//        return result;
//    }
//
//    private void find(TreeNode root, int target, ArrayList<Integer> path) {
//        if(root == null){
//            return;
//        }
//        path.add(root.val);
//        target -= root.val;;
//        if(target == 0 && root.left ==null && root.right == null){
//            result.add(new ArrayList<>(path));
//        }
//        find(root.left,target,new ArrayList<>(path));
//        find(root.right,target,new ArrayList<>(path));
//    }
}
