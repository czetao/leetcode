package offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/17 10:55
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */


/***
 * 解法2：通过数组的特点  数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其它所有数字出现的次数的
 * 和还要多。
 * int time =0;
 * int result = array[0];
 * for (int i =1;i<length;i++){
 *     if(time == 0){
 *         result = array[i];
 *         time =1 ;
 *         }
 *         else if(array[i] == result){
 *             time ++;
 *         }else{
 *             time --;
 *         }
 *         return restult;
 *         }
 */


public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length ==0){
            return 0;
        }
        int middle = array.length >>1;
        int start = 0,end = array.length-1;
        int index = Partition(array,start,end);
        //这里只是得到了中位数，但并不知道是否符合要求，因此还需要一个函数，判断是否超过一半的值
        while(index != middle){
            if (index > middle){
                end = index -1;
                index = Partition(array,start,end);
            }
            else {
                start = index+1;
                index =Partition(array,start,end);
            }
        }
        int result = array[middle];

        if(!CheckMoreThanHalf(array,result)) {
            result = 0;
        }
        return result;
    }

    /***
     * 判断中位数是否超过array数组的一半。
     * @param array
     * @param result
     * @return
     */
    private boolean CheckMoreThanHalf(int[] array, int result) {
        int times = 0;
        for (int i=0;i<array.length;i++){
            if (array[i] == result){
                times ++;
            }
        }
        boolean isMoreThanHalf = true;
        if (times *2 <=array.length){
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    //得到枢纽的函数
    public static int Partition(int[] array ,int low ,int high){
        //子表的第一个记录做枢轴记录
        int key = array[low];
        while(low < high){
            //如果是第一个记录做枢轴，那么这里一定要从后往前排查！
            while (low<high && array[high] >=key){
                high--;
            }
            swap(array,low,high);

            while(low<high && key >=array[low]){
                low++;
            }
            swap(array,high,low);
        }
        return low;
    }

    private static void swap(int[] array, int low, int key) {
        int temp = array[low];
        array[low] = array[key];
        array[key] = temp;

    }

    public static void main(String[] args) {
        int[] a = {2,8,1,7,0,8,5};
        Partition(a,0,6);
        for (int i:a){
            System.out.println(i);
        }
    }

}
