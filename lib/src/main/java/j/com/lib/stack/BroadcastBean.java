package j.com.lib.stack;

public class BroadcastBean {
    private int mPriority;
    private String desc;

    public BroadcastBean(int mPriority, String desc) {
        this.mPriority = mPriority;
        this.desc = desc;
    }

    public int getmPriority() {
        return mPriority;
    }

    public void setmPriority(int mPriority) {
        this.mPriority = mPriority;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
