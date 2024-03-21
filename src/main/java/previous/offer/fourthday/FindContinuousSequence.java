package previous.offer.fourthday;

import java.util.ArrayList;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/19 10:07
 * @Description: 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    /**
     * 同样也是用双指针思想，
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        int small = 1;
        int big = 2;
        int value = 0;
        int middle = (1+sum)/2;
        while (small < middle){
            value = GetSum(small,big);

            if (value == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=small;i<=big;i++){
                    list.add(i);
                }
                listAll.add(list);
                //再增加big,继续往后找
                big ++;
            }else if (value > sum){
                small++;
            }else {
                big++;
            }
        }
        return listAll;
    }

    private int GetSum(int small, int big) {
        int index = 0;
        for (int i =small;i<=big;i++){
            index += i;
        }
        return index;
    }

    public static void main(String[] args) {
        FindContinuousSequence g = new FindContinuousSequence();
        g.FindContinuousSequence(15);
    }
}
