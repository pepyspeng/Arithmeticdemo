package j.com.lib.demo;

public class SleepThread implements Runnable {

    private Service service;

    public SleepThread(Service service) {
        this.service = service;
    }

    public void run() {
        service.mSleep();
    }

}
