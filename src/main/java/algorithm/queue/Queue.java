package algorithm.queue;

import java.util.Stack;

/**
 正如标题所述，你需要使用两个栈来实现队列的一些操作。

 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。

 pop和top方法都应该返回第一个元素的值。
 */
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
        // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    public int pop() {
        // write your code here
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        // write your code here
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}