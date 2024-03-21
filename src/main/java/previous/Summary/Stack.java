package previous.Summary;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 用栈实现队列
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 两个队列实现
 */
public class Stack {
    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public Stack() {
       q1 = new LinkedList<>();
       q2 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (!q1.isEmpty() && q1.size()>1){
            q2.add(q1.poll());
        }
        int el = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();
        return el;
    }

    /** Get the top element. */
    public int top() {
        while (!q1.isEmpty() && q1.size()>1){
            q2.add(q1.poll());
        }
        int el = q1.peek();

        return el;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty()&&q2.isEmpty();
    }
}
