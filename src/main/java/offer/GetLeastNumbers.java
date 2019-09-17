package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/17 12:24
 * @Description:
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length ==0){
            return list;
        }

        int start = 0,end = input.length-1;
        int index = Partition(input,start,end);
        //这里只是得到了中位数，但并不知道是否符合要求，因此还需要一个函数，判断是否超过一半的值
        while(index != k-1){
            if (index > k-1){
                end = index -1;
                index = Partition(input,start,end);
            }
            else {
                start = index+1;
                index =Partition(input,start,end);
            }
        }

        for(int i =0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
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
        int[] a = {4,5,1,6,2,7,3,8};
        GetLeastNumbers g = new GetLeastNumbers();
        List<Integer> list = g.GetLeastNumbers_Solution(a,4);
        for (int i:list){
            System.out.print(i);
        }
    }
}
