package j.com.lib.Proxy;

public class XiaoMin implements ILawsuit{
    @Override
    public void submit() {
        System.out.println("老板拖欠工资，申请诉讼");
    }

    @Override
    public void burden() {
        System.out.println("劳动合同和工资卡流水");
    }

    @Override
    public void defend() {
        System.out.println("证据确凿！");
    }

    @Override
    public void finish() {
        System.out.println("成功");
    }
}
