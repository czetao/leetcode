package offer.ThirdDay;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/18 21:23
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 对每一个数字做异或运算，得到的结果用二进制表示，找出第一个数出现是1的，根据1将数组分成2个子数组。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
