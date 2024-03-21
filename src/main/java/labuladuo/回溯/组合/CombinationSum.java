package labuladuo.回溯.组合;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzetao
 * @description 39 组合总数
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * @time 2024/3/21 16:41
 */
public class CombinationSum {

    List<List<Integer>> all = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int sum = 0;
        backTracking(sum, target, candidates, 0);
        return all;
    }

    private void backTracking(int sum, int target, int[] candidates, int startIndex) {
        if (target == sum) {
            all.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            // 可以重复使用 ,就在当前树开始
            backTracking(sum,target,candidates,i);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
