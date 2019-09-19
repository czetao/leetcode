package offer.fourthday;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/19 11:36
 * @Description:汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    /**
     * 通过n将字符串分成两段，分别反转，再将整个反转，则能得到左移的字符串
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        //鲁邦性，str.length ==0
        if (str.length() ==0 || n == 0){
            return str;
        }
        char[] c = str.toCharArray();
        reverse(c,0,n-1);
        reverse(c,n,c.length-1);
        reverse(c,0,c.length-1);
        for (char s :c){
            System.out.print(s);
        }
        return String.valueOf(c);
    }
    private void reverse(char[] c, int start, int end) {
        for (int i=start,j=end;i<j;i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    public static void main(String[] args) {
        LeftRotateString s = new LeftRotateString();
        s.LeftRotateString("abcdefg",2);
    }
}
