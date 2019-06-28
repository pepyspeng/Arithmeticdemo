package j.com.lib.demo;

public interface Animal {


    default void call(){
        System.out.println("动物叫");
    }


    interface Dog extends Animal{

        default void call() {
            System.out.println("小狗叫");
        }
    }

}
