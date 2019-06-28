package j.com.lib;

public class Singleton {


    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance.singleton;
    }


    static class instance {
        static Singleton singleton = new Singleton();
    }
}
