package j.com.lib.sort;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import j.com.lib.stack.TreeNode;

public class Sort {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(2);
        root.left = root1;
        TreeNode root2 = new TreeNode(6);
        root.right = root2;
        TreeNode root4 = new TreeNode(1);
        root1.left = root4;
        TreeNode root5 = new TreeNode(3);
        root1.right = root5;
        minDiffInBST(root);
//        int[] arrays = new int[]{10, 2, 4, 7, 23, 87, 54, 0, -10, 5};
//        Sort sort = new Sort();
//        arrays = sort.selectSort(arrays);
//        for (int data : arrays) {
//            System.out.println(data);
//        }


//        final MyTask myTask = new MyTask();
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                myTask.execute("A");
//            }
//        }, "A").start();
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                myTask.execute("B");
//            }
//        }, "B").start();
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                myTask.execute("C");
//            }
//        }, "C").start();
    }

    static int min = Integer.MAX_VALUE;
    static TreeNode pre;

    /**
     * 二叉搜索树的节点的最小距离
     *
     * @param root
     * @return
     */
    public static int minDiffInBST(TreeNode root) {
        if (root == null) {
            return min;
        } else {
            minDiffInBST(root.left);
            if (pre != null && (root.val - pre.val) < min)
                min = root.val - pre.val;
            pre = root;
            minDiffInBST(root.right);
        }
        return min;
    }


    /**
     * 冒泡排序
     * 值两两比较，因为需要循环良边，时间复杂度O（n^2）
     *
     * @param arrays
     * @return
     */
    private int[] bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                if (arrays[i] < arrays[j]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
        return arrays;
    }


    private int[] selectSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int minPosition = i;
            int j;
            for (j = i; j < arrays.length; j++) {
                if (arrays[minPosition] > arrays[j]) {
                    minPosition = j;
                }
            }
            int temp = arrays[i];
            arrays[i] = arrays[minPosition];
            arrays[minPosition] = temp;
        }

        return arrays;
    }


    static class MyTask {
        private static ReentrantLock rl = new ReentrantLock();
        private static Condition conditionA = rl.newCondition();
        private static Condition conditionB = rl.newCondition();
        private static Condition conditionC = rl.newCondition();

        public void execute(String flag) {
            rl.lock();

            try {
                for (int i = 1; i <= 10; i++) {
                    if ("A".equals(flag)) {
                        System.out.println(Thread.currentThread().getName() + " - " + i);
                        conditionB.signal();
                        conditionA.await();
                    }

                    if ("B".equals(flag)) {
                        System.out.println(Thread.currentThread().getName() + " - " + i);
                        conditionC.signal();
                        conditionB.await();
                    }

                    if ("C".equals(flag)) {
                        System.out.println(Thread.currentThread().getName() + " - " + i);
                        conditionA.signal();
                        conditionC.await();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rl.unlock();
            }
        }
    }


}
