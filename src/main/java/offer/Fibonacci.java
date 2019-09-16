package offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/15 20:23
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Fibonacci {
    public int fibonacci(int n) {
        //注意程序的鲁棒性
        int[] result = {0,1};
        if (n<2){
            return result[n];
        }

        int FirstNum = 0;
        int SecondNum =1;
        int ThirdNum = 0;
        for (int i =2;i<=n;i++){
            ThirdNum = FirstNum +SecondNum;
            FirstNum = SecondNum;
            SecondNum = ThirdNum;
        }
        return ThirdNum;
    }
}
