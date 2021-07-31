package j.com.lib.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import j.com.lib.bean.TreeNode;

public class offer_32_levelOrder {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> ooffer(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return  result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right !=null){
                queue.offer(temp.right);
            }

        }
        return result;
    }
}
