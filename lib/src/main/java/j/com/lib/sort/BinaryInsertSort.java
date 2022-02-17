package j.com.lib.sort;


import java.util.ArrayList;
import java.util.List;

import j.com.lib.stack.BroadcastBean;

public class BinaryInsertSort {
    public static void main(String[] args) {
        getProperty();
//        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        System.out.println("排序之前：");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
//        //二分插入排序
//        sort(a);
//        System.out.println();
//        System.out.println("排序之后：");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
    }

    public static void getProperty() {
        //静态的
        ArrayList<BroadcastBean> receivers = new ArrayList<>();
        receivers.add(new BroadcastBean(1, "静态的"));
        receivers.add(new BroadcastBean(3, "静态的"));
        receivers.add(new BroadcastBean(5, "静态的"));
        receivers.add(new BroadcastBean(7, "静态的"));
        receivers.add(new BroadcastBean(9, "静态的"));
        //动态的
        ArrayList<BroadcastBean> registeredReceivers = new ArrayList<>();
        registeredReceivers.add(new BroadcastBean(2, "动态的"));
        registeredReceivers.add(new BroadcastBean(4, "动态的"));
        registeredReceivers.add(new BroadcastBean(6, "动态的"));
        registeredReceivers.add(new BroadcastBean(8, "动态的"));
        registeredReceivers.add(new BroadcastBean(9, "动态的"));
        //静态的
        int NT = receivers.size();
        //动态的
        int NR = registeredReceivers.size();
        //
        int ir = 0;
        //合成的坐标
        int it = 0;
        BroadcastBean curt = null;
        BroadcastBean curr = null;
        while (it < NT && ir < NR) {
            if (curt == null) {
                //receivers保存的是静态注册的广播接受者
                curt = receivers.get(it);
            }
            if (curr == null) {
                //registeredReceivers保存的是动态注册的广播接受者
                curr = registeredReceivers.get(ir);
            }
            //动态注册广播和静态注册的广播接受者比较优先级，根据Priority从小到大排序
            if (curr.getmPriority() >= curt.getmPriority()) {
                // Insert this broadcast record into the final list.
                //同一个级别的 动态接受者 必定在 静态接受者的receivers 前面。
                receivers.add(it, curr);
                ir++;
                curr = null;
                it++;
                NT++;
            } else {
                // Skip to the next ResolveInfo in the final list.
                it++;
                curt = null;
            }
        }
        //把剩余的动态注册的广播接受者放在最后。
        while (ir < NR) {
            if (receivers == null) {
                receivers = new ArrayList();
            }
            receivers.add(registeredReceivers.get(ir));
            ir++;
        }
        for (BroadcastBean i : receivers) {
            System.out.println("i:" + i.getDesc() + "--" + i.getmPriority());
        }
    }

    //二分法插入
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            //确定要插入的位置
            while (left <= right) {
                //先获取中间位置
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    //如果值比中间值小，让right左移到中间下标-1
                    right = mid - 1;
                } else {
                    //如果值比中间值大,让left右移到中间下标+1
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                //以左下标为标准，在左位置前插入该数据，左及左后边全部后移
                a[j + 1] = a[j];
            }
            if (left != i) {
                //左位置插入该数据
                a[left] = temp;
            }
        }
    }
}