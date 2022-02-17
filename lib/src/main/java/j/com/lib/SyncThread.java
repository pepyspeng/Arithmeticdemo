package j.com.lib;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import j.com.lib.stack.MyClass;

public class SyncThread {
    private int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    public static void main(String[] args) {
       /* SyncThread syncThread = new SyncThread();
        Thread t1 = new Thread(syncThread::fb);
        Thread t2 = new Throwead(syncThread::fb);*/

//        MyClass myClass = new MyClass();
//        Class cla1 = myClass.getClass();
//
//        Class cla2 = MyClass.class;
//
//        try {
//            Class cla3 = Class.forName("j.com.lib.stack.MyClass");
//
//            System.out.println("cla1 == cla2 :"+(cla1 == cla2));
//            System.out.println("cla2 == cla3 :"+(cla2 == cla3));
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        test();


    }

    public void fb() {
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    }


    private final static ReferenceQueue QUEUE = new ReferenceQueue<>();

    public static void test(){
        PhantomReference<byte[]> phantom = new PhantomReference<byte[]>(new byte[102],QUEUE);
        //尝试获取虚引用，返回null
        System.out.println("get1="+phantom);
        new Thread(()->{
            while (true){
                Reference poll = QUEUE.poll();
                if(poll != null){
                    System.out.println("被回收了。"+poll);
                    return;
                }
            }
        }).start();
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get2="+phantom);
    }
}
