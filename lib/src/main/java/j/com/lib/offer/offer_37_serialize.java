package j.com.lib.offer;

import java.util.LinkedList;

import j.com.lib.bean.TreeNode;

/**
 * 序列化二叉树
 */
public class offer_37_serialize {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        offer_37_serialize serialize = new offer_37_serialize();
        System.out.println(serialize.serialize(root));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preDfs(root);
        return sb.toString();
    }

    String NULL = "#";
    String SEP = ",";
    StringBuilder sb = new StringBuilder();

    public void preDfs(TreeNode node) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        /****** 前序遍历位置 ******/
        sb.append(node.val).append(SEP);
        /****** 前序遍历位置 ******/

        preDfs(node.left);
        preDfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return dePre(nodes);
    }

    public TreeNode dePre(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        //前序第一个就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = dePre(nodes);
        root.right = dePre(nodes);
        return root;
    }
}
