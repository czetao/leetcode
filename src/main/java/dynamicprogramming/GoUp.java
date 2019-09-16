package dynamicprogramming;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/2 09:39
 * @Description: 动态规划经典问题，爬楼梯。其实符合斐波那契数列的思路
 *
 */
public class GoUp {
    /**
     * 没有使用记忆性递归，导致在每次计算都会重新再算一遍，超出栈大小
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs(n-1)+ climbStairs(n-2);
    }

    /**
     * 使用动态规划的思想  n=1,count=1;n=2 ,count=2,n=3,count=3.....即f(n) = f(n-1)+f(n-2)
     * 使用数组来记录所有的f(n)
     * 特殊情况，n=1 ,return 1
     * 递推公式，f(n) = f(n-1)+f(n-2)
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n == 1){
            return 1;
        }
        int[] num = new int[n+1];
        num[1] =1;
        num[2] =2;
        for (int i = 3; i<num.length;i++){
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];
    }

    public static void main(String[] args) {
        GoUp g = new GoUp();

        System.out.println( g.climbStairs2(5));
    }
}
