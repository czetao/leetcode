package previous.offer.fourthday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/19 10:08
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    /**
     * 用双指针，当找到的数，大于s,较大的数往下走，小于S，较小的数往上走。
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length <2|| sum ==0){
            return list;
        }

        int first = 0;
        int end = array.length-1;
        int value = 0;
        while (first < end){
             value = array[first] + array[end];
             //>,尾指针往下走
            if ( value > sum){
                end -=1;
            }else if (value<sum){
                first +=1;
            }else {
                list.add(array[first]);
                list.add(array[end]);
                return list;
            }
        }

        return list;
     }

    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
        FindNumbersWithSum s  =new FindNumbersWithSum();
        s.FindNumbersWithSum(a,15);
    }
}
