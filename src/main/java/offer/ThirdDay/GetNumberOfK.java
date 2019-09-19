package offer.ThirdDay;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/18 19:31
 * @Description: 统计一个数字在排序数组中出现的次数。
 * 先通过二分查找的方法，找出出现的第一次和出现的第二次。时间复杂度都是logn
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0 ){
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        int number =0;
        int first = GetFirstNum(array,k,start,end);
        int last = GetLastNum(array,k,start,end);
        if (last !=-1 && first != -1){
            number = last-first+1;
        }
        return number;
    }

    private int GetFirstNum(int[] arrry,int k,int start,int end ){
        if (start>end){
            return -1;
        }
        int middle = (start+end)/2;
        if (arrry[middle] == k){
            if (middle >0 && arrry[middle-1] != k || middle == 0 ){
                return middle;
            }else {
                end = middle -1;
            }
        }
        else if (arrry[middle] > k ){
            end = middle -1;
        }
        else {
            start = middle+1;
        }
        return GetFirstNum(arrry,k,start,end);
    }
    private int GetLastNum(int[] array ,int k,int start ,int end){
        if (start >end){
            return -1;
        }
        int middle = (start+end)/2;
        if (array[middle] == k ){
            //条件不同
            if (middle <end && array[middle+1] != k || middle ==end){
                return middle;
            }else {
                start =middle+1;
            }
        }else if (array[middle] <k){
            start = middle+1;
        }else {
             end = middle-1;
        }
        return GetLastNum(array,k,start,end);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,4,5};
        GetNumberOfK g = new GetNumberOfK();

        System.out.println(  g.GetLastNum(a,3,0,a.length-1));
    }
}
