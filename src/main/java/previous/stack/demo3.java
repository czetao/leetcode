package previous.stack;

import java.util.Stack;

/***
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */
public class demo3 {
    //若不用栈的数据结构，用两个指针的思想
    public int[] dailyTemperatures(int[] T) {
      /*  int[] t = new int[T.length];
        for (int i =0;i<T.length;i++){
            int step =0;
          for (int j=i+1;j<T.length;j++){
              if (T[i]<T[j]){
                  t[i] = j-i;
                  break;
              }
          }
        }*/
      //尝试用栈的数据结构，时间效率上增加了很多,进栈的是符号的位置
        Stack<Integer> stack = new Stack<>();
        int[] t = new int[T.length];
        for (int i=0;i<T.length;i++){
            //栈不为空，且算出小的
            while (!stack.empty() && T[stack.peek()] < T[i]){
                int step=stack.pop();
                t[step] = i-step;
            }
            stack.push(i);
        }

    return t;
    }

    public static void main(String[] args) {
        demo3 d = new demo3();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] t = d.dailyTemperatures(temperatures);
        for (int j=0;j<t.length;j++){
            System.out.print(t[j]);
        }
    }
}
