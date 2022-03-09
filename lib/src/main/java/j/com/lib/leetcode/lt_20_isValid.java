package j.com.lib.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 */
public class lt_20_isValid {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == getLeft(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public char getLeft(char c) {
        if (c == '}') {
            return '{';
        } else if (c == ')') {
            return '(';
        } else {
            return '[';
        }
    }
}
