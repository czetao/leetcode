package Array;

import java.util.Scanner;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/20 14:40
 * @Description: 给定两个排序的整数数组nums1和nums2，
 * 将nums2中的元素合并到nums1中，并且作为一个排序的数组。
 */
public class MergeArray {

    /***
     * 解法1.合并数组，再使用冒泡排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=m,k=0;m<m+n &&k<n;i++,k++){
            nums1[i] = nums2[k];
        }
        //最多做n-1道排序
        for (int i=0;i<nums1.length-1;i++){
            for (int j=0;j<nums1.length-1-i;j++){
                if (nums1[j]>nums1[j+1]){
                    int tem = nums1[j+1];
                    nums1[j+1] = nums1[j];
                    nums1[j] = tem;
                }
            }
        }
    }

    /***
     * 解法2. 解法1的时间复杂度过高，两个有序数组相比，对两个数组的最大值比较，从后往前填
     * 特殊情况 ： num1的最小值仍大于num2的最大值。需要再做一次循环，检查num2是否填进nums1
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        //一旦有一个不符合判定，即填充结束
        while (i>=0 && j>=0){
            if (nums1[i]>nums2[j]){
                nums1[i+j+1] = nums1[i];
                i--;
            }else {
                nums1[i+j+1] = nums2[j];
                j--;
            }

        }

        while (j>=0){
            nums1[i+j+1] = nums2[j];
            j--;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(nums.length);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
    }

}
