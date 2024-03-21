package previous;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/9/11 20:15
 * @Description:数组移动
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给定一个数列，每一次移动可以将数列某个数移动到某个位置上，移动多次后，形成新的数列。定义数列中相邻两两之间的差的绝对值为“移动距离”，
 * 定义所有移动距离的总和为“总移动距离”。希望计算出最少的移动次数，使得新数列的“总移动距离”最小。 例如原数列为[4,2,7,6]，总移动距离为2+5+1=8。
 * 将6移动到7之前，会变成[4,2,6,7]，总移动距离变成2+4+1=7。
 *
 * 需要编写一个函数，输入为一个int数组表示数列内容，输出为一个int数字，表示最小移动次数
 */
public class XiaoMi2 {
    //移动次数最少的排序
    static int solution(int[] arr) {
        int i,j,min;
        int count = 0;
        for (i=0;i<arr.length;i++){
            min = i;
            for (j = i+1 ; j<arr.length;j++){
                if (arr[min] > arr[j]){
                    min = j;
                }

            }
            if (min !=i){
                swap(arr,i,min);
                count++;
            }
        }
    return  count;
    }
    static void swap(int[] arr,int i ,int min){
        int t = arr[i];
        arr[i] = arr[min];
        arr[min] = t;
    }
}
