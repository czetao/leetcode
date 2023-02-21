package offer;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/15 19:13
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddEven {
    public static void reOrderArray(int[] array) {

        //通过双指针
        int first = 0;
        int last = array.length - 1;
        while (first < last) {
            //找到第一个偶数
            while (first < last && array[first] % 2 == 1) {
                first++;
            }
            last = first + 1;
            //找到偶数后面的第一个奇数
            while (last < array.length && array[last] % 2 == 0) {
                last++;
            }
            //将i+1到j-1的所有数字后移
            if (last < array.length) {
                int temp = array[last];
                for (int jj = last - 1; jj >= first; jj--) {
                    array[jj + 1] = array[jj];
                }
                array[first] = temp;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 5, 7, 72, 12, 5, 1, 20};
        reOrderArray(test);
        for (int i : test) {
            System.out.println(i);
        }
    }

}
