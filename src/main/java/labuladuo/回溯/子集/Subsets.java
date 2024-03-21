package labuladuo.回溯.子集;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzetao
 * @description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * <p>
 * （幂集）。
 * @time 2024/3/20 16:58
 */
public class Subsets {
    List<List<Integer>> all;

    public List<List<Integer>> subsets(int[] nums) {
        all = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backTrack(path, 0, nums);
        return all;
    }

    private void backTrack(LinkedList<Integer> path, int start, int[] nums) {
        all.add(new LinkedList<>(path));

        for (int i = start; i < nums.length; i++) {

            // 先序 新增path
            path.add(nums[i]);
            backTrack(path, i + 1, nums);
            path.removeLast();

        }

    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
        System.out.printf(subsets1.toString());
    }
}
