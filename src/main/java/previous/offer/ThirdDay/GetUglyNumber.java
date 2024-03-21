package previous.offer.ThirdDay;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/18 15:28
 * @Description: 找出某个排序好的丑数。
 * 创建数组保存已经找到的丑数。
 * 根据丑数的定义，丑数应该是另一个丑数乘以2,3或者5的结果。因此我们可以创建一个数组，里面的数字是排好序的丑数。
 * 每一个丑数都是前面的丑数乘以2,3,5得到的。
 * 因为已有的丑数是按顺序存放在数组中的，对乘以2而言，肯定存在某一个丑数T2,排在它之前的每一个丑数乘以2得到的结果
 * 都会小于已有最大的丑数，在它之后的每一个丑数乘以2得到的结果都会太大，我们只需要记下这个丑数的位置，同时，每次生成新
 * 的丑数的时候，去更新这个T2，对于3和5，都存在T3，T5。
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        int[] a = new int[index];
        //习惯上把1当成第一个丑数
        a[0] = 1;
        int uglyNumber2 = 0;
        int uglyNumber3 = 0;
        int uglyNumber5 = 0;
        int indexNumber = 1;
        while (indexNumber < index){
            int min = Min(a[uglyNumber2]*2,a[uglyNumber3]*3,a[uglyNumber5]*5);
            a[indexNumber] = min;
            while (a[uglyNumber2]*2 <=a[indexNumber]) {
                ++uglyNumber2;
            }
            while (a[uglyNumber3]*3 <= a[indexNumber]){
                ++uglyNumber3;
            }
            while (a[uglyNumber5]*5 <= a[indexNumber]){
                ++uglyNumber5;
            }
            indexNumber++;
        }

        return a[indexNumber-1];
    }

    private int Min(int i, int i1, int i2) {
        int min = Math.min(i,i1);
        min = Math.min(min,i2);
        return min;
    }

    public static void main(String[] args) {
        GetUglyNumber g = new GetUglyNumber();
        g.GetUglyNumber_Solution(5);
    }
}
