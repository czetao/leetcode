package offer;

import java.util.Stack;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/16 15:13
 * @Description:  判断压栈顺序序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {

    /**
     * 借助辅助栈，可以得出规律：如果下一个出栈的元素是栈顶元素，则直接出栈。如果不是，需要将压入顺序之前的元素都进栈，
     * 直到把下一个需要弹出的数字压入栈顶为止。如果所有数字都压入栈了，还没有需要弹出的数字。则这个序列不是该栈的弹出顺序。
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
        {return false;}
        Stack<Integer> data = new Stack<>();

        int index =0;
        for (int i=0;i<popA.length;i++){
            data.push(pushA[i]);
            while (!data.isEmpty() && data.peek() == popA[index]){
                data.pop();
                index++;
            }

        }
        return data.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        System.out.println(IsPopOrder(a,b));
    }
}
