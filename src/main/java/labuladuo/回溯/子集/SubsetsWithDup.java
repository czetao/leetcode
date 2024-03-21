package labuladuo.回溯.子集;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzetao
 * @description 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 * （幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 解题思路,  画成一棵树, 将相邻的剪枝  收集子节点,可以解决问题
 * @time 2024/3/21 10:36
 */
public class SubsetsWithDup {

    // 定义全局参数
    List<List<Integer>> all = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        boolean[] use = new boolean[nums.length];
        // 数组先排序
        Arrays.sort(nums);
        backTracking(path, nums, 0, use);

        return all;
    }

    private void backTracking(LinkedList<Integer> path, int[] nums, int startIndex, boolean[] use) {

        all.add(new LinkedList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 而我们要对同一树层使用过的元素进行跳过
            if (i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) {
                continue;
            }
            use[i] = true;
            path.add(nums[i]);
            backTracking(path, nums, i + 1, use);
            use[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists.toString());
    }

}
