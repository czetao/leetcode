package offer.digital;

/**
 * 2023/3/1
 * czetao
 * Description 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 **/
public class offer11 {

    /**
     * 通过二分查找，
     * left right
     * 如果 middle > right  最小值在右边
     * 如果 middle < right 最小值在左边
     * if ==  ，right --
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right){
            int middle = left + (right - left)/2;
            if (numbers[middle] > numbers[right]){
                // middle >  + 1 排除
                left = middle +1 ;
            }if (numbers[middle] < numbers[right]){
                right = middle;
            }else {
                right -- ;
            }
        }

        return numbers[left];


    }
}
