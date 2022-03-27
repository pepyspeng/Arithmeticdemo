package j.com.lib.offer;

import j.com.lib.bean.Node;

/**
 * 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 */
public class lt_116_connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        transformNode(root.left, root.right);
        return root;
    }

    public void transformNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            //完全二叉树，到这就说明到底了
            return;
        }
        //首先让两个节点先连上
        node1.next = node2;
        //然后让两个节点的左右节点分别连上
        transformNode(node1.left, node1.right);
        transformNode(node2.left, node2.right);
        //最后让左右节点连上
        transformNode(node1.right, node2.left);
    }


}
