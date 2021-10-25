package j.com.lib.offer;

import java.util.ArrayList;
import java.util.List;

import j.com.lib.bean.Node;
import j.com.lib.bean.TreeNode;

/**
 * 搜索二叉树和双相链表
 */
public class offer_36_Convert {

    Node head;
    Node pre;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;

        return  head;
    }

    /**
     * 中序遍历
     * @param cur
     */
    private void dfs(Node cur) {
        if(cur == null){
            return;
        }
        dfs(cur.left);
        if(pre == null){
            //说明这里是头节点
            pre = cur;
        }else {
            //不是头节点。需要指向前后节点
            pre.right = cur;
        }
        //指向前节点
        cur.left = pre;
        pre = cur;
        dfs(cur.right);

    }


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
