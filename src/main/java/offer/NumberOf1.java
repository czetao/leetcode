package offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/15 20:31
 * @Description:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    //将该数值二进制与1相与，如果为1，value++；第二步，将数值向右移一位，继续相与
    public int NumberOf1(int n) {
        //计数器
        int value = 0;
        while (n != 0){
            value += n&1;

            n = n>>>1;
        }


        return value;

    }
    /***
     * 如果是负数解法，
     * flag = 1
     * while (n != 0){
     *  if (n & flag)
     *    value ++;
     *    flag <<1;
     *   }
     *
     *
     *    public int NumberOf1(int n) {
     *         int count = 0;
     *         while(n!= 0){
     *             count++;
     *             n = n & (n - 1);
     *          }
     *         return count;
     *     }
     */
}
