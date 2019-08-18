package Summary;

import java.util.Stack;

/***
 * 用栈实现队列
 * 使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class Queue {
    /**
     * s1用做入队栈 ， s2用做出队栈
     * Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public Queue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /** Push element x to the back of queue.*/
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element.
     * 判断s2是否空，将s1中元素全部出栈到s2,s2中的永远是最前的，s2出完再重新进栈*/
    public int pop() {
        if (s2.empty()) {
            while(s1.empty()){
            s2.push(s1.pop());}
        }else {
            return s2.pop();
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s2.empty()) {
            while(s1.empty()){
                s2.push(s1.pop());}
        }else {
            return s2.peek();
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}
