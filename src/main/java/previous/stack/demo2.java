package previous.stack;

import java.util.Scanner;
import java.util.Stack;

/***
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class demo2 {
    /***
     * 解题思路。这题还是比较简单的，碰到左括号就开始进栈，知道遇到右括号，则出栈比较。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                if (stack.empty())
                    return false;
                char top = stack.pop();
                if(top =='(' && c!=')')
                    return false;
                if (top=='{' && c!='}')
                    return false;
                if (top=='[' && c!=']')
                    return false;
            }
        }

        //如果成功匹配，那么栈应该为空
        return stack.empty();
    }

    public static void main(String[] args) {
        demo2 de  = new demo2();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(de.isValid(s));
    }
}
