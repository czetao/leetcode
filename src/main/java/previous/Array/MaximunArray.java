package previous.Array;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/20 11:28
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximunArray {
    /***
     * 求一个数组的最大序列和，第一次循环，第一个元素作为最大值，第二次循环，sum+=num[2],sum要与当前nums[2]比较，如果小于nums[2]，那
     * 最大元素改成nums[2]开始。
     * 再与前面的最大和比较，获取最大值。
     * @param nums
     * @return 最大值
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length ;i++){
            sum += nums[i];
            if (sum < nums[i]){
                sum = nums[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
}
