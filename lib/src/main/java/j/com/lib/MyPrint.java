package j.com.lib;

public class MyPrint {
    //记录层级
    public int count = 0;

    //打印
    public void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }
}
