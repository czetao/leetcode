package previous.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.util.Arrays.sort;

/***
 * Arrays.sort()
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 */
public class DFS2 {


    /***
     * 根据dfs算法思想，dfs所有的可能情况，+ -，像需要对数组遍历 的，可以在dfs（）中，对数组元素加一,提供全局变量，记录所有的可能次数
     * @param nums
     * @param S
     * @return
     */
    public static int cnt;
    public static int findTargetSumWays(int[] nums, int S) {
        cnt = 0;
       dfs(nums,0,0,S);
       return cnt;
    }

    public static void dfs(int[] nums,int val,int i ,int s){

        if (i == nums.length){
            if(val == s) cnt++;
            return;
        }
        dfs(nums,val+nums[i],i+1,s);
        dfs(nums,val-nums[i],i+1,s);


    }

    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        int s=3;
        System.out.println( findTargetSumWays(nums,s));
    }

}
