package dynamicprogramming;

import java.util.Arrays;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/11 15:08
 * @Description: 在m个节点的分布式计算系统中，有一批任务需要执行，每个任务需要的时间array[i]，每个节点同一时间只能执行一个任务，每个节点只能执行连续的任务。
 * 例如i,i+1,i+2但是不能执行i,i+2，请问任务完成的最短时间。
 * 输入数据包含两行
 * 第一行，空格分隔的两个整数m和n，分别表示节点个数和任务个数（m>0,n>=0）
 * 第二行，空格分隔的正整数序列，表示每个任务需要的时间。
 */
public class ScheDule {
    static int scheDule(int m,int[] array) {
        //任务个数为行，节点个数为列的二维数组
        int[][] dp = new int[array.length +1][m+1];
        for (int i =1 ;i<=array.length;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 1;i<= array.length;i++){
            for (int j= 1;j<=m;j++){
                int min = Integer.MIN_VALUE;
                int t =0;
                for (int k = 1;k<=i;k++){
                    t += array[i-k];
                    if (t>=min) {break;}
                    min = Math.min(min,Math.max(dp[i - k][j-1],t));
                }
                dp[i][j] = min;
            }

        }
        System.out.println(Arrays.deepToString(dp));
        return dp[array.length][m];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,5,3,4,2};
        scheDule(3,array);
    }
}
