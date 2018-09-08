package algorithm.stack;

import java.util.Stack;


// version 2, save more space. but space complexity doesn't change.
public class MinStackV2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStackV2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.empty() == true)
            minStack.push(number);
        else {
            // 这里考虑的相等的情况也会继续push
            if (minStack.peek() >= number)
                minStack.push(number);
        }
    }

    public int pop() {
        if (stack.peek().equals(minStack.peek()) )
            minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
