package algorithm.stack;

import java.util.Stack;

/**
 stack里面只记录与当时min的差值，这样的花只需要一个int来记录最小值。
 如果当我们pop出得数值小于0时，我们就应该更新min.
 这种解法可以少用一个stack,但是空间复杂度任然为O(n)
 */
public class MinStackOne {
    private int min;
    private Stack<Integer> stack;

    public MinStackOne() {
        // do intialization if necessary
        stack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (stack.isEmpty()) {
            min = number;
            stack.push(0);
        } else if (number < min) {
            stack.push(number - min);
            min = number;
        } else {
            stack.push(number - min);
        }
        return;
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int number = stack.pop();
        if (number < 0) {
            min = min - number;
        }
        return number + min;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }
}