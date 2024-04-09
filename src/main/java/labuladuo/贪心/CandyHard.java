package labuladuo.贪心;

import java.util.Arrays;

/**
 * @description n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * @author chenzetao
 * @time 2024/4/6 15:38
 */
public class CandyHard {

    /*
    需要满足 比左边大的 则比左边多, 比右边大 就要比右边多 .
    使用两次贪心思路  先计算 左边比右边大的情况, 得到一个candy数组
    再计算 右边比左边大的情况 ,取candy[i]较大的一个,则能满足两边的情况, 得到最优解
     */
    public int candy(int[] ratings) {

        int sum = 0 ;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        // 先计算左边比右边大的情况
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] +1;
            }
        }
        // 从后计算 右边比左边大的
        for (int i = ratings.length-1; i>0 ;i--){
            if (ratings[i-1] >ratings [i]){
                candy[i-1] =Math.max(candy[i-1] ,candy[i] +1);
            }
        }
        for (int j : candy) {
            sum += j;
        }
        return sum;

    }

    public static void main(String[] args) {
        CandyHard candyHard = new CandyHard();
        int candy = candyHard.candy(new int[]{1,2,2});
        System.out.println(candy);
    }
}
