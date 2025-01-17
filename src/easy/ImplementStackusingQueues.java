package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by GAOSHANSHAN835 on 2016/1/18.
 * 用一个deque就可以了  每次push的时候  都把之前的给加到后面 这样dq的顺序其实就是堆栈的顺序
 */

public class ImplementStackusingQueues {
    Queue<Integer> queue = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> swap = new LinkedList<Integer>();
        swap.add(x);
        while (!queue.isEmpty()) {
            swap.add(queue.remove());
        }
        queue = swap;
    }

    // Removes the element on top of the stack.
    public void pop() {
        // pop from front
        queue.remove();
    }

    // Get the top element.
    public int top() {
        // peek from front
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }

}

