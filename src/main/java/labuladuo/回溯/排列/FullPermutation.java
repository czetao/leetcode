package labuladuo.回溯.排列;

import java.util.LinkedList;
import java.util.List;

/**
 * @description 全排列 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author chenzetao
 * @time 2024/3/19 16:37
 *
 * 使用回溯法
 * 回溯法 基本框架
 */
public class FullPermutation {

    List<List<Integer>> all;

    public List<List<Integer>> permute(int[] nums){
        // 结果列表
        all = new LinkedList<>();
        // 选择列表
        boolean[] b = new boolean[nums.length];
        // 路径列表
        LinkedList<Integer> path = new LinkedList<>();

        backTrack(b,path,nums);
        return all;


    }

    public void backTrack(boolean[] b, LinkedList<Integer> path, int[] nums){
        int length = nums.length;
        // 结束条件
        if (path.size() == length){
            all.add(new LinkedList<>(path));
            return;
        }
        // for i
        for (int i = 0; i < length; i++) {
            // 已经加入路径的跳过条件
            if (b[i]){
                continue;
            }
            // 选择条件进path
            path.add(nums[i]);
            // 设置为已新增
            b[i] = true;
            backTrack(b,path,nums);

            // 移除条件
            path.removeLast();
            // 设置为false
            b[i] = false;

        }
    }

    public static void main(String[] args) {
        FullPermutation fullPermutation = new FullPermutation();
        int[] nums = new int[]{1,2,3,4};
        fullPermutation.permute(nums);
    }

}


