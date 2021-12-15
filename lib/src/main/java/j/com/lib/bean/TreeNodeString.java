package j.com.lib.bean;

public class TreeNodeString {

    public String val;
    public TreeNodeString left;
    public TreeNodeString right;

    public TreeNodeString(String x) {
        val = x;
    }

    /**
     *              4
     *          2       6
     *       1    3   5   7
     *
     *
     * @return
     */
    public static TreeNodeString getTreeNode() {
        TreeNodeString root1 = new TreeNodeString("1");
        TreeNodeString root2 = new TreeNodeString("2");
        TreeNodeString root3 = new TreeNodeString("3");
        TreeNodeString root4 = new TreeNodeString("4");
        TreeNodeString root5 = new TreeNodeString("5");
        TreeNodeString root6 = new TreeNodeString("6");
        TreeNodeString root7 = new TreeNodeString("7");

        root4.left = root2;
        root4.right = root6;
        root2.left = root1;
        root2.right = root3;
        root6.left = root5;
        root6.right = root7;
        return root4;
    }
}
