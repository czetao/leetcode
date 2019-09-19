package offer.fourthday;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/19 14:14
 * @Description:
 */
public class isContinuous {
    /**
     * 先将数组排序
     * 判断是不是顺子，统计相邻之间的数字间额的总数，再统计0的个数。如果间额总数<=0的个数，则是一个顺子对
     * @param numbers
     * @return
     */
    public static boolean isContinuous(int [] numbers) {
        Arrays.sort(numbers);
        int countZero = 0;
        int countNumber = 0;
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i] == 0){
                countZero +=1;
                continue;
            }
            if (numbers[i] == numbers[i+1]){
                return false;
            }
            countNumber += numbers[i+1] - numbers[i] -1;
        }
        if (countNumber <= countZero){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] a = {0,1,3,4,5};
        isContinuous(a);
    }
}
