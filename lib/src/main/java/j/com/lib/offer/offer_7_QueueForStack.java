package j.com.lib.offer;

import java.util.Stack;

/**
 * Created by pepys on 2019/6/26
 * description:
 * stack：先进后出
 * queue：先进先出
 *
 */
public class offer_7_QueueForStack {

    Stack<Integer> integer1;
    Stack<Integer> integer2;

    public offer_7_QueueForStack() {
        integer1 = new Stack<>();
        integer2 = new Stack<>();
    }

    /**
     * 让先进的在栈顶，那么这次入栈的值应该在栈底
     * @param x
     */
    public void push(int x){
        while (!integer1.empty()){
            integer2.push(integer1.pop());
        }
        integer1.push(x);
        while (!integer2.empty()){
            integer1.push(integer2.pop());
        }
    }

    public int peek(){
        return integer1.peek();
    }

    public int pop(){
        return integer1.pop();
    }


}
