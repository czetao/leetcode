package labuladuo.贪心;

/*
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2
 */
public class Jump {

    /*
    同之前的题目不同的是, 求最少跳跃步数, 就是计算 两个覆盖范围 当前,与下一个覆盖范围, 如果下一个覆盖范围 达到了终点, 则当前步数就是最少步数
    如果没到,且当前范围走完了, 就要 步数++
     */
    public int jump(int[] nums) {

        if (nums.length ==1){
            return 0;
        }
        int result = 0;
        int curCover = 0;
        int nextCover = 0;
        for (int i = 0; i < nums.length; i++) {

            nextCover = Math.max( i + nums[i],nextCover);
            // 到达当前覆盖范围
            if (i == curCover){
                result ++;
                curCover = nextCover;
                if (nextCover >= nums.length -1) break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int jump1 = jump.jump(new int[]{1, 2, 1, 1, 1});
        System.out.println(jump1);
    }
}

