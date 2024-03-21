package labuladuo.回溯.组合;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzetao
 * @description 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * @time 2024/3/21 16:16
 */
public class CombinationSum2 {

    List<List<Integer>> all = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int sum = 0;
        boolean[] use = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(candidates, target, sum, 0, use);
        return all;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex, boolean[] use) {
        if (sum == target) {
            all.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (sum > target) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i-1] && !use[i-1]){
                continue;
            }

            use[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backTracking(candidates, target, sum, i + 1, use);
            sum -= candidates[i];
            path.removeLast();
            use[i] = false;

        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(lists);
    }
}
