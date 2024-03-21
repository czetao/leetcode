package labuladuo.回溯.排列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzetao
 * @description 全排列2
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * @time 2024/3/21 14:21
 */
public class PermuteUnique {

    List<List<Integer>> all = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] use = new boolean[nums.length];
        // 不重复的队列都需要先进行排序
        Arrays.sort(nums);
        backTracking(nums, 0, use);
        return all;
    }

    private void backTracking(int[] nums, int startIndex, boolean[] use) {
        if (path.size() == nums.length) {
            all.add(new LinkedList<>(path));
            return;
        }

        //这里和77.组合问题 (opens new window)、131.切割问题 (opens new window)和78.子集问题 (opens new window)最大的不同就是for循环里不用startIndex了。
        //
        //因为排列问题，每次都要从头开始搜索，例如元素1在[1,2]中已经使用过了，但是在[2,1]中还要再使用一次1。
        for (int i = 0; i < nums.length; i++) {

            if (use[i]) {
                continue;
            }
            // 进行剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) {
                continue;
            }

            use[i] = true;
            path.add(nums[i]);
            backTracking(nums, i + 1, use);
            use[i] = false;
            path.removeLast();

        }

    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> lists = permuteUnique.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists.toString());
    }
}
