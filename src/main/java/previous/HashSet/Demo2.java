package previous.HashSet;

import java.util.HashSet;
import java.util.Set;

/***
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 */
public class Demo2 {
    /***
     * 有个小坑，要确定数组的长度
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> ret = new HashSet<Integer>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int i:nums2){
            if (set.contains(i)){
               ret.add(i);
            }
        }
        int d =0;
        int[] a = new int[ret.size()];
        for (int i :ret){
            a[d++] = i;
        }
        return a;
    }

    public static void main(String[] args) {
        int[]  nums1 = {1,2,2,1}, nums2 = {2,2};
        Demo2 demo2 = new Demo2();
        int[] ints = demo2.intersection(nums1, nums2);
        for (int i :ints){
            System.out.println(i);
        }
    }
}
