package previous.offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/15 20:23
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n， 青蛙跳级 ： 可以跳一级，可以跳二级，问n级台阶 有几种跳法。
 *
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * <p>
 * fn = ｛  0 . n =0
 * 1 . n =1
 * fn-1 + fn-2 n > 1
 * ｝
 * n<=39
 */
public class Fibonacci {

    /**
     * 使用递归的解法
     *
     */
    public int diGui(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return diGui(n - 1) + diGui(n - 2);
    }


    /**
     * o(n) 的解法
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        //注意程序的鲁棒性
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        int FirstNum = 0;
        int SecondNum = 1;
        int ThirdNum = 0;
        for (int i = 2; i <= n; i++) {
            ThirdNum = FirstNum + SecondNum;
            FirstNum = SecondNum;
            SecondNum = ThirdNum;
        }
        return ThirdNum;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.diGui(3));
        System.out.println(fibonacci.fibonacci(3));

    }
}
