package cn.a2vk.algorithm.stack;

import java.util.Stack;


// version 2, save more space. but space complexity doesn't change.
public class MinStackV2<T extends Comparable<? super T>> {
    private Stack<T> stack;
    private Stack<T> minStack;

    public MinStackV2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(T number) {
        stack.push(number);
        if (minStack.empty())
            minStack.push(number);
        else {
            // 这里考虑的相等的情况也会继续push
            if (number.compareTo(minStack.peek()) < 0) {
                minStack.push(number);
            }
        }
    }

    public T pop() {
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        return stack.pop();
    }

    public T min() {
        return minStack.peek();
    }
}
