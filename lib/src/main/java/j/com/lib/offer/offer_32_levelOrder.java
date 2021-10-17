package j.com.lib.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import j.com.lib.bean.TreeNode;

public class offer_32_levelOrder {
    public static void main(String[] args) {
        System.out.println(levelOrder_2(TreeNode.getTreeNode()));
    }


    public static List<List<Integer>> levelOrder_2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (result.size() % 2 == 1) {
                Collections.reverse(list);
            }
            result.add(list);
        }
        return result;

    }

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder_1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            //必须是倒序，或者把queue初始size记录下来，不然for中会改变queue的值
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
    public int[] levelOrder1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return  new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList  <>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if(temp.left!=null){
                queue.offer(temp.left);

            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
        int[] array = new int[result.size()];
        for(int i=0;i<result.size();i++){
            array[i] = result.get(i);
        }
        return array;
    }

    public static int[] levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] reuslt1 = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            reuslt1[i] = result.get(i);
        }
        return reuslt1;

    }

    public ArrayList<Integer> offer(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }

        }
        return result;
    }
}
