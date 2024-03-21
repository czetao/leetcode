package previous.offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/15 19:43
 * @Description: 旋转数组中最小的元素
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinSum {
    //根据二分查找，逆转数组，如果中间值大于第一个数，则最小值在后半部分
    //如果中间值小于最后一个数，则最小值在前半部分
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int index1 = 0;
        int index2 = array.length-1;
        int indexMid = index1;
        //如果第一个数小于最后一个数，则数组是有序的，返回第一个数
        while (array[index1] >=array[index2]){
            //当两个指针之差为1时，最小值为index2
            if (index2 - index1==1){
                indexMid = index2;
                break;
            }
            indexMid = (index1+index2)/2;
            //如果index1，index2，indexMid指针的元素相等，无法判断范围，只能顺序查找
            if (array[indexMid] == array[index1] && array[indexMid] == array[index2]){
                return MinInOrder(array,index1,index2);
            }
            //范围在后半段，指针往后移
            if (array[indexMid] >=array[index1]){
                index1 = indexMid;
            }
            else if (array[indexMid] <= array[index2]){
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }

    //顺序查找数组中最小的元素
    private int MinInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 +1;i<index2;i++){
            if (result > array[i]){
                result = array[i];
            }
        }
        return result;
    }
}
