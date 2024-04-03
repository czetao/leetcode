package labuladuo.贪心;

/**
 * @author chenzetao
 * @description 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * @time 2024/4/3 11:00
 */
public class CanJump {

    /*
    思路:循环求每个值的最大覆盖范围, 如果覆盖范围已经达到最大, 则true
    覆盖范围下标: cover = i+nums[i]
    着重注意 , for循环的范围 在cover之内
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int cover = 0;
        // bugfix i 每次移动只能在 cover 的范围内移动，每移动一个元素，cover 得到该元素数值
        for (int i = 0; i <= cover; i++) {

            cover = Math.max(i + nums[i], cover);

            if (cover >= nums.length - 1) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        boolean b = canJump.canJump(new int[]{2,3,1,1,4});
        System.out.println(b);
    }
}
