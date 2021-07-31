package j.com.lib.offer;

import java.util.Stack;

public class offer_30_MinStack {
    public static void main(String[] args) {
        offer_30_MinStack minStack = new offer_30_MinStack();
        minStack.push(9);
        minStack.push(10);
        minStack.push(7);
        minStack.push(3);
        minStack.push(5);

    }

    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

}
