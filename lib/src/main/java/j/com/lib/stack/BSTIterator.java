package j.com.lib.stack;

import java.util.Stack;

import j.com.lib.bean.TreeNode;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator {

    Stack<Integer> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        mid(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return stack.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }


    public void mid(TreeNode root) {
        if(root==null){
            return;
        }else{
            mid(root.right);
            stack.push(root.val);
            mid(root.left);
        }

    }



}
