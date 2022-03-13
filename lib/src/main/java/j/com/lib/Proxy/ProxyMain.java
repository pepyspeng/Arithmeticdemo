package j.com.lib.Proxy;

import java.lang.reflect.Proxy;

public class ProxyMain {

    public static void main(String[] args) {
        // 构造一个小明
        ILawsuit xiaoMin = new XiaoMin();
        //构造一个动态代理
        DynamicProxy proxy = new DynamicProxy(xiaoMin);
        //获取被代理类的classloader
        ClassLoader loader = xiaoMin.getClass().getClassLoader();
        //动态构造一个代理者律师
        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, proxy);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
