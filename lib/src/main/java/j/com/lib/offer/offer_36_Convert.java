package j.com.lib.offer;

import j.com.lib.bean.Node;

/**
 * 搜索二叉树和双相链表
 */
public class offer_36_Convert {
    /**
     * 相当于尾节点
     */
    Node pre;
    /**
     * 相当于头结点
     */
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        midDfs(root);
        //要求头尾相接
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序遍历，然后让中间节点，指向前后
     *
     * @param root
     */
    private void midDfs(Node root) {
        if (root == null) {
            return;
        }
        midDfs(root.left);
        if (pre == null) {
            //说明这里是头结点
            //pre为空，不需要让pre.right指向当前
            head = root;
        } else {
            //上一个节点的右节点指向当前节点
            //只需要让上一节点 右边指向 当前节点
            pre.right = root;
        }
        //当前节点的左节点指向上一节点
        root.left = pre;
        pre = root;
        midDfs(root.right);
    }












   /* Node head;
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

    *//**
     * 中序遍历
     * @param cur
     *//*
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
    }*/
}
