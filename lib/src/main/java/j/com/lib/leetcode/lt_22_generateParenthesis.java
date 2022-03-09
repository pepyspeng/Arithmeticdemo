package j.com.lib.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class lt_22_generateParenthesis {

    List<String> res = new ArrayList<>();

    /**
     * 1. 一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解。
     * 2. 对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
     * 因为从左往右算的话，肯定是左括号多嘛，到最后左右括号数量相等，说明这个括号组合是合法的。
     * 反之，比如这个括号组合 ))((，前几个子串都是右括号多于左括号，显然不是合法的括号组合。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, n);
        return res;
    }

    /**
     * @param sb
     * @param leftCount
     * @param rightCount
     */
    public void backtrack(StringBuilder sb, int leftCount, int rightCount) {
        if (leftCount > rightCount) {
            // 剪枝 ，若左括号剩下的多，说明不合法
            return;
        }
        if (leftCount < 0 || rightCount < 0) {
            //剪枝，不合法
            return;
        }
        if (leftCount == 0 && rightCount == 0) {
            res.add(sb.toString());
            return;
        }

        sb.append("(");
        backtrack(sb, leftCount - 1, rightCount);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        backtrack(sb, leftCount, rightCount - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
