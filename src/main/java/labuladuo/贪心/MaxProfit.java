package labuladuo.贪心;

/**
 * @description 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 *
 * @author chenzetao
 * @time 2024/4/3 10:45
 */

public class MaxProfit {

    /**
     * @description 思路:
     * [7,1,5,3,6,4] 贪心思路 , 当天收益 - 昨日收益 , 可以得到今天的收益  将所有 > 0 的收益 加起来,就是这些交易里,最大的收益
     *
     * @author chenzetao
     * @time 2024/4/3 10:48
     */
    public int maxProfit(int[] prices) {

        int sum = 0 ;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i] - prices[i - 1];
            if(price > 0 ){
                sum += price;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit(new int[]{1,2,3,4,5});
        System.out.println(i);

    }
}
