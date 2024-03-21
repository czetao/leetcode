package previous.offer;

import java.util.Stack;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/16 14:42
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class MinStack {
    /**
     * 问题思路：通过一个辅助栈，存放着当前最小值。每一次push，都会将当前最小值push进去。每一次pop，都会将辅助栈
     * 以及栈两个栈的元素都push
     * @param node
     */
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        data.push(node);
        if (min.isEmpty() || min.peek()>node){
            min.push(node);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return  data.peek();
    }

    public int min() {
        return min.peek();
    }
}
