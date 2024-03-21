package previous.Summary;

import java.util.Stack;

/***
 * 小结
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class Demo1 {
    /***
     * 用栈数据结构  第①种情况 ，次数是双位数，计算后再进栈，然后需要重置次数=0  。第②种，遇到‘]’,将前面的字符串重组再进栈，取出数值，计算重复值 第③种，将栈的元素相加
     * 先将所有情况入栈， 都进栈了之后，将所有情况再组成字符串相加
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            } else {
                if (num != 0){
                stack.push(String.valueOf(num));}
                num =0;
                if (s.charAt(i) != ']') {
                    stack.push(String.valueOf(s.charAt(i)));
                } else {
                    String b = "";
                    String c = "";
                    while (!stack.peek().equals("[")) {
                        String a = stack.pop();
                        b = a + b;
                    }
                    stack.pop();
                    int j = Integer.parseInt(stack.pop());
                    for (int d = 0; d < j; d++) {
                        c = c + b;
                    }
                    stack.push(c);
                }

            }

        }
        String g = "";
        while (!stack.empty()) {
            g = stack.pop() + g;
        }
        return g;
    }

    public static void main(String[] args) {
        String a="2[abc]3[cd]ef";
        Demo1 demo1 = new Demo1();

        System.out.println(demo1.decodeString(a));
    }
}
