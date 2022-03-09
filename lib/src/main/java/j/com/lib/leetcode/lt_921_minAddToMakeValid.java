package j.com.lib.leetcode;


/**
 * 使括号有效的最少添加
 */
public class lt_921_minAddToMakeValid {

    //需要以左括号有基准
    public int minAddToMakeValid(String s) {
        //需要的左括号数量
        int leftNum = 0;
        //需要的右括号数量
        int rightNum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                //如果遇到左括号，右括号的需求加1
                rightNum++;
            }
            if (c == ')') {
                //如果遇到右括号，那么右括号的需求减1
                rightNum--;

                if (rightNum == -1) {
                    //右括号需求超量了。
                    //先把右括号的需求变为0
                    rightNum = 0;
                    //再把左括号的需求加1
                    leftNum++;
                }
            }
        }
        return leftNum + rightNum;
    }
}
